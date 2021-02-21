package com.SAD.Main_Project.service;

import com.SAD.Main_Project.dao.ConfirmationTokenJPADao;
import com.SAD.Main_Project.model.ConfirmationToken;
import com.SAD.Main_Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    @Autowired
    ConfirmationTokenJPADao cTokenJPADao;

    @Override
    public ConfirmationToken generateConfirmationTokenFor(User user) {
        ConfirmationToken cToken = new ConfirmationToken(user);
        return cTokenJPADao.save(cToken);
    }

    @Override
    public ConfirmationToken findByTokenString(String token) {
        return cTokenJPADao.findTokenByTokenString(token);
    }
}
