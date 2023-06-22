package com.example.practice.controller;

import com.example.practice.entity.AddToCart;
import com.example.practice.entity.CarouselEntity;
import com.example.practice.services.AddToCartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/addtocart")
public class AddToCartController {
    private final AddToCartService addToCartService;
    public AddToCartController(AddToCartService addToCartService) {
        this.addToCartService = addToCartService;
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = {"application/json"})
    public List<AddToCart> getAll(){
        return addToCartService.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {"application/json"})
    public Optional<AddToCart> findById(@PathVariable("id") Long id){
        return addToCartService.findById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/json"})
    public AddToCart create(@RequestBody AddToCart addToCart) throws Exception {
        return  addToCartService.create(addToCart);
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public AddToCart update(@PathVariable Long id,@RequestBody AddToCart addToCart) throws Exception {
        return  addToCartService.update(id,addToCart);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable("id") Long id){
        addToCartService.delete(id);
    }
}
