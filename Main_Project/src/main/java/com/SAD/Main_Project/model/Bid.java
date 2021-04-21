package com.SAD.Main_Project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;

    @OneToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid_id", referencedColumnName = "bid")
    private Set<User> user;

    @Column(nullable = false)
//    @NotBlank(message = "Enter the bid value.")
    private double price;

    private String status;

}
