package com.example.practice.services;

import com.example.practice.entity.CityEntity;
import com.example.practice.entity.ClientEntity;
import com.example.practice.repository.CityRepository;
import com.example.practice.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityEntity> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<CityEntity> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public CityEntity create(CityEntity cityEntity) {
        return cityRepository.save(cityEntity);
    }

    @Override
    public CityEntity update(Long id, CityEntity cityEntity) throws Exception {
        CityEntity city = cityRepository.findById(id).orElseThrow(() -> new Exception("CLIENT NOT FOUND"));
        GeneralUtil.getCopyOf(cityEntity, city);
        return cityRepository.save(city);
    }

    @Override
    public void delete(Long id) {

    }
}
