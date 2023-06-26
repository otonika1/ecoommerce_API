package com.example.practice.services;

import com.example.practice.entity.AddToCart;
import com.example.practice.entity.History;
import com.example.practice.repository.HistoryRepository;
import com.example.practice.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HistoryServiceImpl implements HistoryService{
    @Autowired
    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<History> getAll() {
        return historyRepository.findAll();
    }

    @Override
    public Optional<History> findById(Long id) {
        return historyRepository.findById(id);
    }

    @Override
    public List<History> findByClientId(Long clientId) {
        return historyRepository.findByClientId(clientId);
    }

    @Override
    public History create(History history) throws Exception {
        return historyRepository.save(history);
    }

    @Override
    public History update(Long id, History history) throws Exception {
        History a = historyRepository.findById(id).orElseThrow(() -> new Exception("HISTORY NOT FOUND"));
        GeneralUtil.getCopyOf(history, a);
        return historyRepository.save(a);
    }

    @Override
    public void delete(Long id) {
        historyRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        historyRepository.deleteAll();
    }
}
