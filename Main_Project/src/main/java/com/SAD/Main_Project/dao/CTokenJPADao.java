package com.SAD.Main_Project.dao;

import com.SAD.Main_Project.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTokenJPADao extends JpaRepository<ConfirmationToken, String> {
    ConfirmationToken findConfirmationTokenBy(String confirmationToken);
}
