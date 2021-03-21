package com.SAD.Main_Project.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @Transient
    private String confirmPassword;

    private boolean active = false;

    @ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private ConfirmationToken token;

}
