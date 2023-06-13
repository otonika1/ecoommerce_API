package com.example.practice.controller;

import com.example.practice.entity.CarouselEntity;
import com.example.practice.services.CarouselService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/carousel")
public class CarouselController {

    private final CarouselService carouselService;
    public CarouselController(CarouselService carouselService) {

        this.carouselService = carouselService;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = {"application/json"})
    public List<CarouselEntity> getAllCarousel(){
        return carouselService.getAllCarousel();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {"application/json"})
    public Optional<CarouselEntity> findById(@PathVariable("id") Long id){
        return carouselService.findById(id);
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/json"})
    public CarouselEntity createCarousel(@RequestBody CarouselEntity carouselEntity){
        return  carouselService.createCarousel(carouselEntity);
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public CarouselEntity updateCarousel(@PathVariable Long id,@RequestBody CarouselEntity carouselEntity){
        return  carouselService.createCarousel(carouselEntity);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deleteCarousel(@PathVariable("id") Long id){
        carouselService.deleteCarousel(id);
    }
}
