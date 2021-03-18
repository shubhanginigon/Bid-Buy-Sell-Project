package com.SAD.Main_Project.repo;

import com.SAD.Main_Project.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "confirmationTokens", path = "confirmationTokens")
public interface ConfirmationTokenRepo extends JpaRepository<ConfirmationToken, Integer> {

    @Query("FROM ConfirmationToken c WHERE c.tokenString = ?1")
    ConfirmationToken findTokenByTokenString(String confirmationToken);

//    @Query("FROM ConfirmationToken c WHERE c.user.uid = ?1")
//    ConfirmationToken findConfirmationTokenBy(int uid);

}
