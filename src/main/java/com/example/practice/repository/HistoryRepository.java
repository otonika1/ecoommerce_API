package com.example.practice.repository;

import com.example.practice.entity.AddToCart;
import com.example.practice.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HistoryRepository extends JpaRepository<History,Long> {
    List<History> findByClientId(Long clientId);
}
