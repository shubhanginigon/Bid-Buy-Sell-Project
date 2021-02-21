package com.SAD.Main_Project.service;

import com.SAD.Main_Project.dao.CTokenJPADao;
import com.SAD.Main_Project.model.ConfirmationToken;
import com.SAD.Main_Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class
ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    private final CTokenJPADao ctokenDao;

    @Autowired
    public ConfirmationTokenServiceImpl(CTokenJPADao ctokenDao) {
        this.ctokenDao = ctokenDao;
    }

    @Override
    public ConfirmationToken generateConfirmationTokenFor(User user) {
        ConfirmationToken token = new ConfirmationToken(user);
        return ctokenDao.save(token);
    }

    @Override
    public ConfirmationToken findByToken(String token) {
        return ctokenDao.findConfirmationTokenBy(token);
    }
}
