package com.SAD.Main_Project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class UserRegisterLoginTests {

    @PersistenceContext
    private EntityManager em;

    @Test
    void registerNewUser() {

    }

}
