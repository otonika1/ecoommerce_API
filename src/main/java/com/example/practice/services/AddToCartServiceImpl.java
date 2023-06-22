package com.example.practice.services;

import com.example.practice.entity.AddToCart;
import com.example.practice.entity.CarouselEntity;
import com.example.practice.entity.ProductEntity;
import com.example.practice.repository.AddToCartRepository;
import com.example.practice.util.GeneralUtil;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddToCartServiceImpl implements AddToCartService{
    @Autowired
    private final AddToCartRepository addToCartRepository;

    public AddToCartServiceImpl(AddToCartRepository addToCartRepository) {
        this.addToCartRepository = addToCartRepository;
    }

    @Override
    public List<AddToCart> getAll() {
        return addToCartRepository.findAll();
    }

    @Override
    public Optional<AddToCart> findById(Long id) {
        return addToCartRepository.findById(id);
    }
    @Override
    public AddToCart create(AddToCart addToCart) throws Exception {
        return addToCartRepository.save(addToCart);
    }

    @Override
    public AddToCart update(Long id, AddToCart addToCart) throws Exception {
        AddToCart a = addToCartRepository.findById(id).orElseThrow(() -> new Exception("ADDTOCART NOT FOUND"));
        GeneralUtil.getCopyOf(addToCart, a);
        return addToCartRepository.save(a);
    }

    @Override
    public void delete(Long id) {
        addToCartRepository.deleteById(id);
    }
}
