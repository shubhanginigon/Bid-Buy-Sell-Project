package com.SAD.Main_Project.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int bidId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id", referencedColumnName = "bid_id")
    @JsonIgnore
    @MapsId
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "bid_id", referencedColumnName = "bid")
    private User user;

    @Column(nullable = false)
//    @NotBlank(message = "Enter the bid value.")
    private double price;

    private String status;

}
