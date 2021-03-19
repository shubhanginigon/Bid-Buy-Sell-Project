package com.SAD.Main_Project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "This field is required.")
    private String name;

    @Column(nullable = false)
    //@NotBlank(message = "This field is required.")
    private double price;

    //@NotBlank(message = "This field is required.")
    private String description;

    @Column(nullable = false)
    private String imageUrl;

    private LocalDate startDate;

    @Transient
    private String startDate_;

    private LocalDate finishDate;

    @Transient
    private String finishDate_;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;

}
