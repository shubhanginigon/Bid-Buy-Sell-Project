package com.SAD.Main_Project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    @Column(nullable = false)
    @NotBlank(message = "This field is required.")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "This field is required.")
    private double price;

    private String productDetail;

    @Column(nullable = false)
    @NotBlank(message = "This field is required.")
    private String picture;

    private Date startDate;

    private Date finishDate;

}
