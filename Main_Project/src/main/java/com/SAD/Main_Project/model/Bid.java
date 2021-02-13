package com.SAD.Main_Project.model;

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
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;

    private int productId;

    private int userId;

    @Column(nullable = false)
    @NotBlank(message = "Enter the bid value")
    private double bidPrice;

    private String Status;
}
