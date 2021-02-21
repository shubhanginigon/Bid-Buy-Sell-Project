package com.SAD.Main_Project.model;

import com.SAD.Main_Project.dao.RoleJPADao;
import com.SAD.Main_Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleFacade {

    @Autowired
    private RoleJPADao roleDao;

    public enum RoleType {
        ADMIN, USER
    }

    public Role createRole(RoleType type) {
        switch (type) {
            case ADMIN:
                return roleDao.findRoleById(1);

            case USER:
                return roleDao.findRoleById(2);

            default:
                throw new UnsupportedOperationException("Unsupported Role");
        }
    }
}
