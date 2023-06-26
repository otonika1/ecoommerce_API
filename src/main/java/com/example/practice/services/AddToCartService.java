package com.example.practice.services;

import com.example.practice.entity.AddToCart;
import com.example.practice.entity.History;

import java.util.List;
import java.util.Optional;

public interface AddToCartService {

    List<AddToCart> getAll();
    Optional<AddToCart> findById(Long id);
    List<AddToCart> findByClientId(Long clientId);
    AddToCart create(AddToCart addToCart) throws Exception;

    AddToCart update(Long id, AddToCart addToCart) throws Exception;

    void delete(Long id);

    void deleteAll();
}
