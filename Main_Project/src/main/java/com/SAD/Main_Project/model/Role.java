package com.SAD.Main_Project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "This field is required.")
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users;

}
