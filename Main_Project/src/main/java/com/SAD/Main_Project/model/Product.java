package com.SAD.Main_Project.model;

import java.time.LocalDateTime;
import java.util.Date;

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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

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
}
