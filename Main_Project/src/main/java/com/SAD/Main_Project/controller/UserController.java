package com.SAD.Main_Project.controller;

import com.SAD.Main_Project.helpers.Page;
import com.SAD.Main_Project.model.Gender;
import com.SAD.Main_Project.model.User;
import com.SAD.Main_Project.service.ProductService;
import com.SAD.Main_Project.service.UserService;
import com.SAD.Main_Project.validation.UserLoginValidator;
import com.SAD.Main_Project.validation.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserLoginValidator userLoginValidator;


    /*************
     * HOME PAGE
     ************/
    @RequestMapping(path = {"/home", "/"})
    public ModelAndView homePage(Principal principal) {
    	ModelAndView mv;
        LOGGER.info("Showing Home Page...");
        // Initially principal doesn't know which user is logged in or which is not
        if (principal == null) {
            LOGGER.info("Principal is null, showing home for unregistered users.");
            mv = new ModelAndView(Page.HOME);
            mv.addObject("products", productService.findAll()); 
            return mv;
        }

        User user = userService.findByEmail(principal.getName());

        // Using Roles based on user types
        if (user.isActive()) {
            String userRoleName = user.getRole().getName();

            if (userRoleName.equalsIgnoreCase("ROLE_ADMIN")) {
                mv = new ModelAndView(Page.DASHBOARD);
                LOGGER.info("Showing Dashboard for Admin.");
            }
            else if (userRoleName.equalsIgnoreCase("ROLE_USER")){
                // Show view with registered users privileges
                mv = new ModelAndView(Page.USER_HOME);
                LOGGER.info("Showing Registered User Home Page");
                mv.addObject("products", productService.findAll()); 
            } else {
            	mv = new ModelAndView();
            	LOGGER.error("UNKNOWN USER ROLE");
            }

            mv.addObject("user", user);
        } else {
            LOGGER.info("User is not active !!!");
            mv = showErrorPageWithMessage("Your email is not confirmed yet.");
        }
        return mv;
    }

    /********************
    * USER REGISTRATION
    ********************/
    private String registerFormWith(ModelMap model) {
        model.addAttribute("user", model.containsKey("user") ? model.get("user") : new User());
        model.addAttribute("genders", Gender.values());
        return Page.REGISTER;
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String showRegisterForm(ModelMap model) {
        return registerFormWith(model);
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, ModelMap model) {
        userValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors()) {
            LOGGER.error("The form has some errors");
            return registerFormWith(model);
        } else {
            LOGGER.info("Saving user with username {}", user.getName());
            userService.save(user);
            return Page.CONFIRM_ACCOUNT;
        }
    }

    private ModelAndView showErrorPageWithMessage(String message) {
        ModelAndView mv = new ModelAndView(Page.ERROR);
        mv.addObject("message", message);
        return mv;
    }

    @Transactional
    @RequestMapping(path = "/confirm-account", method = RequestMethod.GET)
    public ModelAndView confirmUserAccount(@RequestParam("token") String token) {
        boolean userActivated = userService.activateUserWithToken(token);
        if (userActivated) {
            return new ModelAndView(Page.ACCOUNT_VERIFIED);
        } else {
            return showErrorPageWithMessage("The link is invalid or broken.");
        }
    }

    /**************
     * USER LOGIN
     *************/
    private String loginFormWith(ModelMap model) {
        model.addAttribute("user", model.containsKey("user") ? model.get("user") : new User());
        return Page.LOGIN;
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String showLoginForm(ModelMap model) {
        return loginFormWith(model);
    }

    @RequestMapping(path="/login", method=RequestMethod.POST)
    public String loginUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, ModelMap model) {
        userLoginValidator.validate(user, bindingResult);
        return (bindingResult.hasErrors() ? loginFormWith(model) : "redirect:/");
    }
}
