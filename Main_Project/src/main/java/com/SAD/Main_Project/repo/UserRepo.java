package com.SAD.Main_Project.repo;

import com.SAD.Main_Project.model.Product;
import com.SAD.Main_Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    //User findByConfirmationToken(String token);

}
