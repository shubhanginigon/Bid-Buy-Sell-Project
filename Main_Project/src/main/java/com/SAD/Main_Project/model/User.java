package com.SAD.Main_Project.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

    @ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
    private Role role;

    private boolean isActive;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private ConfirmationToken token;

}
