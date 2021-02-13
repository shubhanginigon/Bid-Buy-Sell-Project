package com.SAD.Main_Project.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data

public class User {
    @Id
    private int uid;
    private String name;
}
