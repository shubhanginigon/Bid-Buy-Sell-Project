package com.SAD.Main_Project.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.SAD.Main_Project.helpers.Page;
import com.SAD.Main_Project.model.Product;
import com.SAD.Main_Project.model.User;
import com.SAD.Main_Project.service.ProductService;
import com.SAD.Main_Project.service.UserService;

@Controller
public class ProductController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
    private UserService userService;
	
	 /*************
     * Product List
     ************/
	
	@RequestMapping(path = {"/bid"})
    public ModelAndView productList(Principal principal) {
        LOGGER.info("Showing product list...");
        ModelAndView mv = new ModelAndView(Page.PRODUCT);

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
                mv = new ModelAndView(Page.PRODUCT);
                LOGGER.info("Showing Registered User Home Page");
            }

            mv.addObject("user", user);
        }
        return mv;
    }
	
	private String addProductFormWith(ModelMap model) {
        model.addAttribute("product", model.containsKey("product") ? model.get("product") : new Product());
        //model.addAttribute("genders", Gender.values());
        return Page.ADD_PRODUCT;
    }

    @RequestMapping(path = "/addProduct", method = RequestMethod.GET)
    public String showAddProductForm(ModelMap model) {
        return addProductFormWith(model);
    }
    
    @RequestMapping(path = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, ModelMap model) {
        if(bindingResult.hasErrors()) {
            LOGGER.error("The form has some errors");
            return addProductFormWith(model);
        } else {
            LOGGER.info("Saving product with product name {}", product.getName());
            productService.save(product);
            return Page.PRODUCT;
        }
    }
	
	
}
