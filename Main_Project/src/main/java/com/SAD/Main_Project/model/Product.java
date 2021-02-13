package com.SAD.Main_Project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    private String name;

    private double price;

    private String productDetail;

    private String picture;

    private Date startDate;

    private Date finishDate;

}
