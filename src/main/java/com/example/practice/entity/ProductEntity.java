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
    @Column(name = "pr_summery")
    private String summery;
    @Column(name = "pr_summery_geo")
    private String summery_geo;
    @Column(name = "pr_author")
    private String author;
    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String name_geo, String description, String description_geo, String img, double price, String summery, String summery_geo, String author) {
        this.id = id;
        this.name = name;
        this.name_geo = name_geo;
        this.description = description;
        this.description_geo = description_geo;
        this.img = img;
        this.price = price;
        this.summery = summery;
        this.summery_geo = summery_geo;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
