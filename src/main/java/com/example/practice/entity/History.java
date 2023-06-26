package com.example.practice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HISTORY")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "cl_id")
    private Long clientId;
    @Column(name = "produ_id")
    private Long productId;
    @Column(name = "history_name")
    private String name;
    @Column(name = "history_name_geo")
    private String name_geo;
    @Column(name = "history_img")
    private String img;
    @Column(name = "history_price")
    private double price;

    public History() {
    }

    public History(Long id, Long clientId, Long productId, String name, String name_geo, String img, double price) {
        this.id = id;
        this.clientId = clientId;
        this.productId = productId;
        this.name = name;
        this.name_geo = name_geo;
        this.img = img;
        this.price = price;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
