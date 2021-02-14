package com.SAD.Main_Project.dao;

import com.SAD.Main_Project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJPADao extends JpaRepository<Role, Integer> {
    public Role findRoleById(int roleId);
}
