package com.example.practice.services;

import com.example.practice.entity.ProductEntity;
import com.example.practice.entity.StoreEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> getAll();

    Optional<ProductEntity> findById(Long id);

    ProductEntity create(ProductEntity productEntity);

    ProductEntity update(Long id, ProductEntity productEntity) throws Exception;

    void delete(Long id);
}
