package com.SAD.Main_Project.dao;

import com.SAD.Main_Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserJPADao extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    //User findByConfirmationToken(String token);

}
