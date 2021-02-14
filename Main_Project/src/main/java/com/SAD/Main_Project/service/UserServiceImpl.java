package com.SAD.Main_Project.service;

import com.SAD.Main_Project.dao.UserJPADao;
import com.SAD.Main_Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    UserJPADao userDao;

    @Override
    public void save(User user) {
        // Encrypt Password

        // Save User

        // Send Registration Success Mail

    }
}
