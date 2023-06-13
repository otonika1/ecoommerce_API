package com.example.practice.controller;

import com.example.practice.entity.CityEntity;
import com.example.practice.entity.ClientEntity;
import com.example.practice.services.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = {"application/json"})
    public List<CityEntity> getAll(){
        return cityService.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {"application/json"})
    public Optional<CityEntity> findById(@PathVariable("id") Long id){
        return cityService.findById(id);
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/json"})
    public CityEntity create(@RequestBody CityEntity cityEntity){
        return  cityService.create(cityEntity);
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public CityEntity update(@PathVariable Long id,@RequestBody CityEntity cityEntity) throws Exception {
        return  cityService.update(id,cityEntity);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable("id") Long id){
        cityService.delete(id);
    }
}
