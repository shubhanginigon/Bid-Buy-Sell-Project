package com.SAD.Main_Project.service;

import com.SAD.Main_Project.dao.UserJPADao;
import com.SAD.Main_Project.facade.EmailFacade;
import com.SAD.Main_Project.model.RoleFacade;
import com.SAD.Main_Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
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

//    //@Autowired
//    ConfirmationTokenService cTokenService;

    @Autowired
    EmailService emailService;


    @Override
    public void save(User user) {
        // Encrypt Password
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        //user.setActive(true); // DO THIS LATER AFTER EMAIL CONFIRMATION
        user.setRole(roleFacade.createRole(RoleFacade.RoleType.USER));

        /*
        // Save confirmation token for user
        ConfirmationToken cToken = cTokenService.generateConfirmationTokenFor(user);
        user.setToken(cToken);
        */

        // Save User
        userDao.save(user);


        // Send Registration Success Mail
        SimpleMailMessage msg = EmailFacade.generateEmailFor(EmailFacade.EmailType.REGISTER_CONFIRM, user);
        emailService.sendEmail(msg);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
