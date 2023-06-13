package com.example.practice.controller;

import com.example.practice.entity.ProductEntity;
import com.example.practice.entity.StoreEntity;
import com.example.practice.services.ProductService;
import com.example.practice.services.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = {"application/json"})
    public List<ProductEntity> getAll(){
        return productService.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {"application/json"})
    public Optional<ProductEntity> findById(@PathVariable("id") Long id){
        return productService.findById(id);
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/json"})
    public ProductEntity create(@RequestBody ProductEntity productEntity){
        return  productService.create(productEntity);
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public ProductEntity update(@PathVariable Long id,@RequestBody ProductEntity productEntity) throws Exception {
        return  productService.update(id,productEntity);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }
}
