package com.example.practice.repository;

import com.example.practice.entity.ProductEntity;
import com.example.practice.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
