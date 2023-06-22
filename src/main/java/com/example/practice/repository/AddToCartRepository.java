package com.example.practice.repository;

import com.example.practice.entity.AddToCart;
import com.example.practice.entity.CarouselEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddToCartRepository extends JpaRepository<AddToCart,Long> {
}
