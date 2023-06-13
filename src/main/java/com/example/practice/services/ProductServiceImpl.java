package com.example.practice.services;

import com.example.practice.entity.ProductEntity;
import com.example.practice.entity.StoreEntity;
import com.example.practice.repository.ProductRepository;
import com.example.practice.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductEntity create(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity update(Long id, ProductEntity productEntity) throws Exception {
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new Exception("PRODUCT NOT FOUND"));
        GeneralUtil.getCopyOf(productEntity, product);
        return productRepository.save(productEntity);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
