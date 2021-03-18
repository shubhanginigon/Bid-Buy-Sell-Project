package com.SAD.Main_Project.repo;

import com.SAD.Main_Project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findRoleById(int roleId);
}
