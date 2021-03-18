package com.SAD.Main_Project.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.SAD.Main_Project.model.User;
import com.SAD.Main_Project.service.UserService;

@Component
public class UserValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        // Add validation logic

        // Rejects if user email already exists
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "user.email.duplicate");
        }

        // Rejects if length of user name is less than 3 and more than 32
        if (user.getName().length() < 3 || user.getName().length() > 32) {
            errors.rejectValue("name", "user.name.size");
        }

        // Rejects if length of password is less than 8 and more than 32
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "user.password.size");
        }

        // Rejects if confirmPassword doesn't match with password
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "user.confirmPassword.diff");
        }
    }

}
