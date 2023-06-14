package com.example.practice.services;

import com.example.practice.dto.SearchClient;
import com.example.practice.dto.request.Paging;
import com.example.practice.entity.ClientEntity;
import com.example.practice.repository.ClientRepository;
import com.example.practice.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientEntity> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<ClientEntity> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public ClientEntity create(ClientEntity clientEntity) {
        return clientRepository.save(clientEntity);
    }

    @Override
    public ClientEntity update(Long id, ClientEntity clientEntity) throws Exception {
        ClientEntity client = clientRepository.findById(id).orElseThrow(() -> new Exception("CLIENT NOT FOUND"));
        GeneralUtil.getCopyOf(clientEntity, client);
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
    @Override
    public Slice<ClientEntity> search(SearchClient searchClient, Paging paging) {
        String name = null;
        if (searchClient.getName() != null && !searchClient.getName().equals("")) {
            name = "%" + searchClient.getName() + "%";
        }
        Pageable pageable = PageRequest.of(paging.getPage(), paging.getSize(), Sort.by("hire_date").descending());
        return clientRepository.search(searchClient.getClientId(), name, pageable);
    }



    @Override
    public ClientEntity pay(Long id, Double price) throws Exception {
        ClientEntity client = clientRepository.findById(id).orElseThrow(() -> new Exception("CLIENT NOT FOUND"));
        //GeneralUtil.getCopyOf(clientEntity, client);
        client.setBalance(client.getBalance() - price);
        return clientRepository.save(client);
    }

}
