package com.example.practice.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CITYS_TB")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;
    @Column(name = "city_name")
    private String name;

    @JoinColumn(name = "st_id")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<StoreEntity> Store = new HashSet<>();

    public CityEntity() {
    }


    public CityEntity(Long id, String name, Set<StoreEntity> store) {
        this.id = id;
        this.name = name;
        Store = store;
    }

    public Set<StoreEntity> getStore() {
        return Store;
    }

    public void setStore(Set<StoreEntity> store) {
        Store = store;
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

}
