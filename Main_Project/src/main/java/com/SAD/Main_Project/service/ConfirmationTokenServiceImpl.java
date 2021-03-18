package com.SAD.Main_Project.service;

import com.SAD.Main_Project.repo.ConfirmationTokenRepo;
import com.SAD.Main_Project.model.ConfirmationToken;
import com.SAD.Main_Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    @Autowired
    ConfirmationTokenRepo cTokenRepo;

    @Override
    public ConfirmationToken generateConfirmationTokenFor(User user) {
        ConfirmationToken cToken = new ConfirmationToken(user);
        return cTokenRepo.save(cToken);
    }

    @Override
    public ConfirmationToken findByTokenString(String tokenString) {
        return cTokenRepo.findTokenByTokenString(tokenString);
    }

}
