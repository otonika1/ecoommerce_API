package com.example.practice.services;


import com.example.practice.dto.SearchClient;
import com.example.practice.dto.request.Paging;
import com.example.practice.entity.ClientEntity;
import com.example.practice.entity.StoreEntity;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.Optional;

public interface StoreService {
    List<StoreEntity> getAll();
    Optional<StoreEntity> findById(Long id);
    StoreEntity create(StoreEntity storeEntity);

    StoreEntity update(Long id, StoreEntity storeEntity) throws Exception;

    void delete(Long id);

}
