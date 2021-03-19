package com.SAD.Main_Project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "token_id")
    private int id;

    private String tokenString;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "is_activated")
    private boolean activated;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    @MapsId
    private User user;

    public ConfirmationToken(User user) {
        this.user = user;
        createdDate = new Date();
        tokenString = UUID.randomUUID().toString();
        activated = false;
        System.out.println("Confirmation Token Created for user: " + user.getName());
    }

}
