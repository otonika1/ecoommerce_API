package com.example.practice.controller;

import com.example.practice.entity.ClientEntity;
import com.example.practice.entity.StoreEntity;
import com.example.practice.services.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/store")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = {"application/json"})
    public List<StoreEntity> getAll(){
        return storeService.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {"application/json"})
    public Optional<StoreEntity> findById(@PathVariable("id") Long id){
        return storeService.findById(id);
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/json"})
    public StoreEntity create(@RequestBody StoreEntity storeEntity){
        return  storeService.create(storeEntity);
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public StoreEntity update(@PathVariable Long id,@RequestBody StoreEntity storeEntity) throws Exception {
        return  storeService.update(id,storeEntity);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable("id") Long id){
        storeService.delete(id);
    }


}
