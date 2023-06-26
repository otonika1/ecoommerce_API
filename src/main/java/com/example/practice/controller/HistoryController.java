package com.example.practice.controller;

import com.example.practice.entity.AddToCart;
import com.example.practice.entity.History;
import com.example.practice.services.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/history")
public class HistoryController {
    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = {"application/json"})
    public List<History> getAll(){
        return historyService.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {"application/json"})
    public Optional<History> findById(@PathVariable("id") Long id){
        return historyService.findById(id);
    }
    @RequestMapping(value = "clientId/{client_id}",method = RequestMethod.GET, produces = {"application/json"})
    public List<History> findByClientId(@PathVariable("client_id") Long clientId){
        return historyService.findByClientId(clientId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/json"})
    public History create(@RequestBody History history) throws Exception {
        return  historyService.create(history);
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public History update(@PathVariable Long id,@RequestBody History history) throws Exception {
        return  historyService.update(id,history);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable("id") Long id){
        historyService.delete(id);
    }
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deleteAll(){
        historyService.deleteAll();
    }
}
