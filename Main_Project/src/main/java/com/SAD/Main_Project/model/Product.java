package com.SAD.Main_Project.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(nullable = false)
    //@NotBlank(message = "This field is required.")
    private String name;

    @Column(nullable = false)
    //@NotBlank(message = "This field is required.")
    private double price;

    private String description;

    @Column(nullable = false)
    //@NotBlank(message = "This field is required.")
    private byte[] picture;

    private LocalDateTime startDate;

    @Transient
    private String startDate_;

    private LocalDateTime finishDate;

    @Transient
    private String finishDate_;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;
    
    @OneToOne(mappedBy="product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Bid bid;
}
