package com.SAD.Main_Project.service;

import com.SAD.Main_Project.dao.UserJPADao;
import com.SAD.Main_Project.model.RoleFacade;
import com.SAD.Main_Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserJPADao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    RoleFacade roleFacade;

    @Override
    public void save(User user) {
        // Encrypt Password
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setActive(true);
        user.setRole(roleFacade.createRole(RoleFacade.RoleType.USER));

        // Save User
        userDao.save(user);

        // Send Registration Success Mail

    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
