package com.SAD.Main_Project.service;

import com.SAD.Main_Project.repo.UserRepo;
import com.SAD.Main_Project.facade.EmailFacade;
import com.SAD.Main_Project.model.ConfirmationToken;
import com.SAD.Main_Project.facade.RoleFacade;
import com.SAD.Main_Project.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    RoleFacade roleFacade;

    @Autowired
    ConfirmationTokenService cTokenService;

    @Autowired
    EmailService emailService;


    @Transactional
    @Override
    public void save(User user) {
        // Encrypt Password
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setRole(roleFacade.createRole(RoleFacade.RoleType.USER));
        LOGGER.info("USER PASSWORD HASHED, ROLE CREATED");


        // Save User
        User savedUser = userRepo.save(user);


        // Save confirmation token for user
        ConfirmationToken cToken = cTokenService.generateConfirmationTokenFor(savedUser);
        savedUser.setToken(cToken);
        LOGGER.info("USER <{}> SAVED, CONFIRMATION TOKEN CREATED, NOT YET ACTIVATED", user.getName());

        // Send Email Confirmation Mail
        SimpleMailMessage msg = EmailFacade.generateEmailFor(EmailFacade.EmailType.REGISTER_CONFIRM, savedUser);
        emailService.sendEmail(msg);
        LOGGER.info("CONFIRMATION MAIL SENT to {}", savedUser.getEmail());
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Transactional
    @Override
    public boolean activateUserWithToken(String tokenString) {

        ConfirmationToken cToken = cTokenService.findByTokenString(tokenString);

        if (cToken != null && !cToken.isActivated()) {
            LOGGER.info("CTOKEN FOUND !!! NOT ACTIVE !!!");
            User user = cToken.getUser();
            if (!user.isActive()) {
                cToken.setActivated(true);
                user.setActive(true);
                LOGGER.info("CTOKEN USED ! USER ACTIVATED !!!");

                // Send Registration Success Mail
                SimpleMailMessage msg = EmailFacade.generateEmailFor(EmailFacade.EmailType.REGISTER_SUCCESS, user);
                emailService.sendEmail(msg);

                return true;
            }
        }
        LOGGER.error("CTOKEN NOT FOUND IN DATABASE !!!");
        return false;
    }
}
