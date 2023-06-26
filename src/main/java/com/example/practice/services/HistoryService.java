package com.example.practice.services;

import com.example.practice.entity.AddToCart;
import com.example.practice.entity.History;

import java.util.List;
import java.util.Optional;

public interface HistoryService {

    List<History> getAll();
    Optional<History> findById(Long id);
    List<History> findByClientId(Long clientId);
    History create(History history) throws Exception;

    History update(Long id, History history) throws Exception;

    void delete(Long id);

    void deleteAll();
}
