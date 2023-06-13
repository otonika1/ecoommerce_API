package com.example.practice.dto;

import jakarta.persistence.Column;

public class SearchClient {
    private Long id;

    private String name;

    public Long getClientId() {
        return id;
    }

    public void setClientId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
