package com.SAD.Main_Project.service;

import com.SAD.Main_Project.model.User;

public interface UserService {
    public void save(User user);

    // used by validation to check email
    public User findByEmail(String email);
}
