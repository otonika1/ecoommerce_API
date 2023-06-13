package com.example.practice.services;

import com.example.practice.entity.CarouselEntity;

import java.util.List;
import java.util.Optional;

public interface CarouselService {
    List<CarouselEntity> getAllCarousel();
    Optional<CarouselEntity> findById(Long id);
    CarouselEntity createCarousel(CarouselEntity carouselEntity);

    CarouselEntity updateCarousel(Long id, CarouselEntity carouselEntity) throws Exception;

    void deleteCarousel(Long id);
}
