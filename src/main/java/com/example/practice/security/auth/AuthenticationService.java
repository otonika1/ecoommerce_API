package com.example.practice.security.auth;


import com.example.practice.entity.ClientEntity;
import com.example.practice.repository.ClientRepository;
import com.example.practice.security.config.JwtService;
import com.example.practice.util.GeneralUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final ClientRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(ClientRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) throws Exception {
        ClientEntity user = new ClientEntity();
        GeneralUtil.getCopyOf(request, user, "password");
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        repository.save(user);
        var jwtToken = jwtService.generateToken((UserDetails) user, user.getRole(),user.getBalance(), user.getFirstname(), user.getId());
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken((UserDetails) user, user.getRole(),user.getBalance(),user.getFirstname(), user.getId());
        return new AuthenticationResponse(jwtToken);
    }
}
