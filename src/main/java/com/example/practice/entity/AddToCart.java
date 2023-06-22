package com.example.practice.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ADD_TO_CART")
public class AddToCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "client_id", unique = true)
    private Long clientId;
    @JoinColumn(name = "prod_id")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<ProductEntity> addedProducts = new HashSet<>();

    public AddToCart() {
    }

    public AddToCart(Long id, Long clientId, Set<ProductEntity> addedProducts) {
        this.id = id;
        this.clientId = clientId;
        this.addedProducts = addedProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Set<ProductEntity> getAddedProducts() {
        return addedProducts;
    }

    public void setAddedProducts(Set<ProductEntity> addedProducts) {
        this.addedProducts = addedProducts;
    }
}
