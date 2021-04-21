package com.SAD.Main_Project.service;

import com.SAD.Main_Project.model.User;

public interface UserService {
    void save(User user);

    // used by validation to check email
    User findByEmail(String email);

    boolean activateUserWithToken(String tokenString);
}
