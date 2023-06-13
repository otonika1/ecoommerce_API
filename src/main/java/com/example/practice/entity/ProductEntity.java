package com.example.practice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pr_id")
    private Long id;
    @Column(name = "pr_name")
    private String name;
    @Column(name = "pr_name_geo")
    private String name_geo;
    @Column(name = "pr_description")
    private String description;
    @Column(name = "pr_description_geo")
    private String description_geo;
    @Column(name = "pr_img")
    private String img;
    @Column(name = "pr_price")
    private double price;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String name_geo, String description, String description_geo, String img, double price) {
        this.id = id;
        this.name = name;
        this.name_geo = name_geo;
        this.description = description;
        this.description_geo = description_geo;
        this.img = img;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription_geo() {
        return description_geo;
    }

    public void setDescription_geo(String description_geo) {
        this.description_geo = description_geo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
