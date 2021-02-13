package com.SAD.Main_Project.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    private String password;

    private String confirmPassword;

    private String role;

    private boolean isActive;

}
