package com.SAD.Main_Project.validation;

import com.SAD.Main_Project.model.User;
import com.SAD.Main_Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    // Add validation logics
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        // Rejects if user email already exists
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "duplicate.user.email'");
        }

        // Rejects if length of password is less than 8 and more than 32
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "size.user.password");
        }

        // Rejects if confirmPassword doesn't match with password
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "diff.user.confirmPassword");
        }

    }
}
