package com.SAD.Main_Project.dao;

import com.SAD.Main_Project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleJPADao extends JpaRepository<Role, Integer> {
    Role findRoleById(int roleId);
}
