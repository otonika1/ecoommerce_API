package com.example.practice.controller;

import com.example.practice.dto.SearchClient;
import com.example.practice.dto.request.Payment;
import com.example.practice.dto.request.RequestData;
import com.example.practice.entity.CarouselEntity;
import com.example.practice.entity.ClientEntity;
import com.example.practice.services.ClientService;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = {"application/json"})
    public List<ClientEntity> getAll(){
        return clientService.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {"application/json"})
    public Optional<ClientEntity> findById(@PathVariable("id") Long id){
        return clientService.findById(id);
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/json"})
    public ClientEntity create(@RequestBody ClientEntity clientEntity){
        return  clientService.create(clientEntity);
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public ClientEntity update(@PathVariable Long id,@RequestBody ClientEntity clientEntity) throws Exception {
        return  clientService.update(id,clientEntity);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable("id") Long id){
        clientService.delete(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = {"application/json"})
    public Slice<ClientEntity> search(@RequestBody RequestData<SearchClient> rd) {
        return clientService.search(rd.getData(), rd.getPaging());
    }

}
