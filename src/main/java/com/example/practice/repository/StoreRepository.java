package com.example.practice.repository;

import com.example.practice.entity.EmployeeEntity;
import com.example.practice.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity,Long> {

}
