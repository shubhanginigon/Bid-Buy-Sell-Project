package com.SAD.Main_Project.validation;

import com.SAD.Main_Project.model.User;
import com.SAD.Main_Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserLoginValidator implements Validator {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (userService.findByEmail(user.getEmail()) == null) {
            errors.rejectValue("email", "user.email.notFound");
            return;
        }

        if (user.getEmail().isEmpty()) {
            errors.rejectValue("email", "input.empty");
        }
//        else if (userService.findByEmail(user.getEmail()) == null) {
//            errors.rejectValue("email", "user.email.notFound");
//        }
        else if (user.getToken() != null) {
            if (!user.getToken().isActivated()) {
                errors.rejectValue("email", "user.email.notConfirmed");
            }
        }

        if (user.getPassword().isEmpty()) {
            errors.rejectValue("password", "input.empty");
        } else if (!bCryptPasswordEncoder.matches(user.getPassword(), userService.findByEmail(user.getEmail()).getPassword())) {
            errors.rejectValue("password", "user.login.invalidCredentials");
        }

    }
}