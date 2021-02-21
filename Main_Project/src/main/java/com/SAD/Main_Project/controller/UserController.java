package com.SAD.Main_Project.controller;

import com.SAD.Main_Project.helpers.Log;
import com.SAD.Main_Project.model.ConfirmationToken;
import com.SAD.Main_Project.model.User;
import com.SAD.Main_Project.service.ConfirmationTokenService;
import com.SAD.Main_Project.service.UserService;
import com.SAD.Main_Project.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private ConfirmationTokenService cTokenService;

    @RequestMapping(path = {"/home", "/"})
    public ModelAndView homePage(Principal principal) {
        ModelAndView mv = new ModelAndView("home.jsp");

        // Initially principal doesn't know which user is logged in or which is not
        if (principal == null) {
            return mv;
        }

        User user = userService.findByEmail(principal.getName());

        // Using Roles based on user types
        if (user != null) { // This check can be discarded as principal is already checked
            String userRoleName = user.getRole().getName();

            if (userRoleName.equalsIgnoreCase("ROLE_ADMIN")) {
                mv = new ModelAndView("dashboard.jsp");
            }
            else if (userRoleName.equalsIgnoreCase("ROLE_USER")){
                // Show view with registered users privileges
                mv = new ModelAndView("user_home.jsp");
            }
            else {
                // Show view with unregistered users privileges
                mv = new ModelAndView("home.jsp");
            }

            mv.addObject("user", user);
        }
        return mv;
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register.jsp";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors()) {
            return "register.jsp";
        }

        userService.save(user);

        return "confirm_account.jsp";
    }

    @Transactional
    @RequestMapping(path = "/confirm-account", method = RequestMethod.GET)
    public ModelAndView confirmUserAccount(@RequestParam("token") String token) {

        ModelAndView mv = null;

        // Check if token received exists in the database
        ConfirmationToken cToken = cTokenService.findByTokenString(token);

        if (cToken != null) { // Exists
            // Success
            User confirmedUser = cToken.getUser();
            if (!confirmedUser.isActive()) {
                confirmedUser.setActive(true);
                confirmedUser.setConfirmPassword(confirmedUser.getPassword());
            }
            mv = new ModelAndView("account_verified.jsp");
        } else {
            // Fail
            mv = new ModelAndView("error.jsp");
            mv.addObject("message", "The link is invalid or broken.");
        }

        return mv;
    }

    @RequestMapping(path="/login", method=RequestMethod.POST)
    public ModelAndView loginUser(ModelAndView mv, User user) {

        return mv;
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String displayLogin() {
        return "login.jsp";
    }
    
    @RequestMapping(path = "/logout-success")
	public String logout() {
		return "logout.jsp";
    }
}
