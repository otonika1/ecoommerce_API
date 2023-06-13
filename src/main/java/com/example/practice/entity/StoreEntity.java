package com.example.practice.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "STORE")
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;
    @Column(name = "store_name")
    private String name;
    @Column(name = "store_name_geo")
    private String name_geo;
    @Column(name = "store_category")
    private String category;
    @Column(name = "store_summerry")
    private String summery;
    @Column(name = "store_summery_geo")
    private String summery_geo;
    @JoinColumn(name = "product_id")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<ProductEntity> Products = new HashSet<>();

    public StoreEntity() {
    }

    public StoreEntity(Long id, String name, String name_geo, String category, String summery, String summery_geo, Set<ProductEntity> products) {
        this.id = id;
        this.name = name;
        this.name_geo = name_geo;
        this.category = category;
        this.summery = summery;
        this.summery_geo = summery_geo;
        Products = products;
    }

    public Set<ProductEntity> getProducts() {
        return Products;
    }

    public void setProducts(Set<ProductEntity> products) {
        Products = products;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_geo() {
        return name_geo;
    }

    public void setName_geo(String name_geo) {
        this.name_geo = name_geo;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String summery) {
        this.summery = summery;
    }

    public String getSummery_geo() {
        return summery_geo;
    }

    public void setSummery_geo(String summery_geo) {
        this.summery_geo = summery_geo;
    }
}
