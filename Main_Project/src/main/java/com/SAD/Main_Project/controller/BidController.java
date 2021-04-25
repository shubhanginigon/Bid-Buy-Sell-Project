package com.SAD.Main_Project.controller;

import com.SAD.Main_Project.helpers.Page;
import com.SAD.Main_Project.model.Bid;
import com.SAD.Main_Project.model.Product;
import com.SAD.Main_Project.model.User;
import com.SAD.Main_Project.service.BidService;
import com.SAD.Main_Project.service.ProductService;
import com.SAD.Main_Project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("bid")
public class BidController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BidController.class);

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    BidService bidService;

    /*************
     * Add Bid
     ************/

    @GetMapping("/{product_id}")
    public String showBidForm(@PathVariable("product_id") int product_id, ModelMap model, Principal principal) {

        Product product = productService.findById(product_id);
        User user = userService.findByEmail(principal.getName());

        model.addAttribute("product", product);
        model.addAttribute("user", user);

        return Page.BID;
    }

    @PostMapping("/")
    public String placeBid(@ModelAttribute("bid") Bid bid, ModelMap model) {
        System.out.println(bid.toString());
        LOGGER.info(bid.toString());;
        LOGGER.info(bid.getStatus());

        bidService.save(bid);

        return "redirect:/";
    }
}
