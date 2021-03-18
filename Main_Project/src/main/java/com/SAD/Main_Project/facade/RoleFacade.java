package com.SAD.Main_Project.facade;

import com.SAD.Main_Project.model.Role;
import com.SAD.Main_Project.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleFacade {

    @Autowired
    private RoleRepo roleRepo;

    public enum RoleType {
        ADMIN, USER
    }

    public Role createRole(RoleType type) {
        switch (type) {
            case ADMIN:
                return roleRepo.findRoleById(1);

            case USER:
                return roleRepo.findRoleById(2);

            default:
                throw new UnsupportedOperationException("Unsupported Role");
        }
    }
}
