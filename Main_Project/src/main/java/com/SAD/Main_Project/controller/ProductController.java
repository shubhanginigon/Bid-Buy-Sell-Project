package com.SAD.Main_Project.controller;

import java.security.Principal;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.SAD.Main_Project.validation.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.SAD.Main_Project.helpers.Page;
import com.SAD.Main_Project.model.Product;
import com.SAD.Main_Project.model.User;
import com.SAD.Main_Project.service.ProductService;
import com.SAD.Main_Project.service.UserService;

@Controller
@RequestMapping("product")
public class ProductController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
    private UserService userService;

	@Autowired
	ProductValidator productValidator;

	User user;
	
	 /*************
     * Add Product
     ************/

     private String addProductFormWith(ModelMap model, User user) {
         model.addAttribute("user", user);
         model.addAttribute("product", model.containsKey("product") ? model.get("product") : new Product());
         return Page.ADD_PRODUCT;
     }

    @GetMapping("add")
    public String showAddProductForm(ModelMap model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        this.user = user;

        return addProductFormWith(model, user);
    }

    @Transactional
    @PostMapping("add")
    public String addProduct(@Valid @ModelAttribute("product") Product product,
                             BindingResult bindingResult,
                             ModelMap model) {
        productValidator.validate(product, bindingResult);

        if (bindingResult.hasErrors()) {
            LOGGER.error("The form has some errors.");
            return addProductFormWith(model, null);
        } else {
//            product.setStartDate(startLocalDateTime);
//            product.setFinishDate(finishLocalDateTime);
            product.setUser(user);
            productService.save(product);
            LOGGER.info("PRODUCT SAVED WITH NAME: {}", product.getName());
            LOGGER.info("START TIME: {}", product.getStartDate_());
        }

        return (bindingResult.hasErrors() ? addProductFormWith(model, null) : "redirect:/product/list");
    }
}

