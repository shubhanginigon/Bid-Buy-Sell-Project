package com.SAD.Main_Project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class User {

    public enum Gender {
        Male, Female
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @Column(nullable = false)
    @NotBlank(message = "This field is required.")
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank(message = "This field is required.")
    @Email(message = "Email should be valid.")
    private String email;

    @NotBlank(message = "This field is required.")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "This field is required.")
    @Transient
    private String confirmPassword;

    @NotBlank(message = "This field is required.")
    @Column(nullable = false)
    private String role;

    private boolean isActive;

}
