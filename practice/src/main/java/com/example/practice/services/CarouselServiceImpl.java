package com.example.practice.services;

import com.example.practice.entity.CarouselEntity;
import com.example.practice.repository.CarouselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CarouselServiceImpl implements CarouselService{
    @Autowired
    private final CarouselRepository carouselRepository;

    public CarouselServiceImpl(CarouselRepository carouselRepository) {
        this.carouselRepository = carouselRepository;
    }

    @Override
    public List<CarouselEntity> getAllCarousel() {
        return carouselRepository.findAll();
    }

    @Override
    public Optional<CarouselEntity> findById(Long id) {
        return carouselRepository.findById(id);
    }

    @Override
    public CarouselEntity createCarousel(CarouselEntity carouselEntity) {
        return carouselRepository.save(carouselEntity);
    }

    @Override
    public CarouselEntity updateCarousel(Long id, CarouselEntity carouselEntity) throws Exception {
        CarouselEntity carousel = carouselRepository.findById(id).orElseThrow(() -> new Exception("CAROUSEL NOT FOUND"));
        return carouselRepository.save(carouselEntity);
    }

    @Override
    public void deleteCarousel(Long id) {
        carouselRepository.deleteById(id);
    }
}
