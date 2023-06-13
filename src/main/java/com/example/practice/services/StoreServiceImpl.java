package com.example.practice.services;

import com.example.practice.dto.SearchClient;
import com.example.practice.dto.request.Paging;
import com.example.practice.entity.ClientEntity;
import com.example.practice.entity.StoreEntity;
import com.example.practice.repository.StoreRepository;
import com.example.practice.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<StoreEntity> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public Optional<StoreEntity> findById(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public StoreEntity create(StoreEntity storeEntity) {
        return storeRepository.save(storeEntity);
    }

    @Override
    public StoreEntity update(Long id, StoreEntity storeEntity) throws Exception {
        StoreEntity store = storeRepository.findById(id).orElseThrow(() -> new Exception("STORE NOT FOUND"));
        GeneralUtil.getCopyOf(storeEntity, store);
        return storeRepository.save(store);
    }

    @Override
    public void delete(Long id) {
        storeRepository.deleteById(id);
    }

}
