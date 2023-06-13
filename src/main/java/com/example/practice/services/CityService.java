package com.example.practice.services;

import com.example.practice.entity.CityEntity;
import com.example.practice.entity.ClientEntity;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<CityEntity> getAll();

    Optional<CityEntity> findById(Long id);

    CityEntity create(CityEntity cityEntity);

    CityEntity update(Long id, CityEntity cityEntity) throws Exception;

    void delete(Long id);
}
