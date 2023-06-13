package com.example.practice.security.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = "select t from Token t inner join ClientEntity c " +
            " on t.client.id = c.id where c.id = :id ")
    List<Token> findAllValidTokenByClient(@Param("id") Long id);

    Optional<Token> findByToken(String token);
}
