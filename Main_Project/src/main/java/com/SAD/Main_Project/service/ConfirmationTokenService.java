package com.SAD.Main_Project.service;

import com.SAD.Main_Project.model.ConfirmationToken;
import com.SAD.Main_Project.model.User;

public interface ConfirmationTokenService {
    ConfirmationToken generateConfirmationTokenFor(User user);
    ConfirmationToken findByToken(String token);
}
