package com.example.practice.services;

import com.example.practice.dto.SearchClient;
import com.example.practice.dto.request.Paging;
import com.example.practice.dto.request.Payment;
import com.example.practice.entity.CarouselEntity;
import com.example.practice.entity.ClientEntity;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<ClientEntity> getAll();
    Optional<ClientEntity> findById(Long id);
    ClientEntity create(ClientEntity clientEntity);

    ClientEntity update(Long id, ClientEntity clientEntity) throws Exception;

    void delete(Long id);

    Slice<ClientEntity> search(SearchClient searchClient, Paging paging);
}
