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

import javax.transaction.Transactional;
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

    @Transactional
    @PostMapping
    public String placeBid(@RequestParam("product_id") int productId,
                           @ModelAttribute("bid") Bid bid,
                           ModelMap model,
                           Principal principal) {
//        System.out.println(bid.toString());
//        LOGGER.info(bid.toString());;
//        LOGGER.info(bid.getStatus());

        Product product = productService.findById(productId);
        User user = userService.findByEmail(principal.getName());

        Bid newBid;

        if (product.getBid() == null) {
            // Build Bid and attach with product
            newBid = Bid.builder()
                    .bidId(productId)
                    .product(product)
                    .user(user)
                    .price(bid.getPrice())
                    .status(bid.getStatus())
                    .build();


        } else {
            // Build Bid
            newBid = product.getBid();
            newBid.setPrice(bid.getPrice());
            newBid.setUser(user);
        }
        bidService.save(newBid);


        return "redirect:/";
    }
}
