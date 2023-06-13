package com.example.practice.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "carousel")
public class CarouselEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "src")
    private String src;

    @Column(name = "alt")
    private String alt;


    public CarouselEntity() {
    }

    public CarouselEntity(Long id, String src, String alt) {
        this.id = id;
        this.src = src;
        this.alt = alt;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
