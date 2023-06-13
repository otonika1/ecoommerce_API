package com.example.practice.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "emp_gender")
    private String gender;
    @Column(name = "emp_address")
    private String Address;
//    @JoinColumn(name = "carousel_id")
//    //@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @ManyToOne(fetch = FetchType.LAZY)
//    //private Set<CarouselEntity> carouselEntity = new HashSet<>();
//    private  CarouselEntity carouselEntity;
//    public CarouselEntity getCarouselEntity() {
//        return (CarouselEntity) carouselEntity;
//    }
//
//    public void setCarouselEntity(CarouselEntity carouselEntity) {
//        this.carouselEntity = (CarouselEntity) carouselEntity;
//    }
//

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id, String name, Date dateOfBirth, String gender, String address, Set<CarouselEntity> carouselEntity) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        Address = address;
        //this.carouselEntity = carouselEntity;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
