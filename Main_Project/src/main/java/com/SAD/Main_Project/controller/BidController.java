package com.SAD.Main_Project.controller;

import com.SAD.Main_Project.helpers.Page;
import com.SAD.Main_Project.model.Bid;
import com.SAD.Main_Project.model.Product;
import com.SAD.Main_Project.model.User;
import com.SAD.Main_Project.service.BidService;
import com.SAD.Main_Project.service.ProductService;
import com.SAD.Main_Project.service.UserService;
import com.SAD.Main_Project.validation.BidValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

    @Autowired
    BidValidator bidValidator;

    /*************
     * Add Bid
     ************/

    @GetMapping("/{product_id}")
    public String showBidForm(@PathVariable("product_id") int product_id, ModelMap model, Principal principal) {

        Product product = productService.findById(product_id);
        User user = userService.findByEmail(principal.getName());

        model.addAttribute("product", product);
        model.addAttribute("user", user);

        Bid newBid = new Bid();
        newBid.setProduct(product);
        newBid.setUser(user);

        model.addAttribute("bid", newBid);

        return Page.BID;
    }

    @Transactional
    @PostMapping
    public String placeBid(@RequestParam("product_id") int productId,
                           @ModelAttribute("bid") Bid bid,
                           BindingResult bindingResult,
                           ModelMap model,
                           Principal principal) {


        Product product = productService.findById(productId);
        User user = userService.findByEmail(principal.getName());

        bid.setProduct(product);
        bidValidator.validate(bid, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("bid", model.containsKey("bid") ? model.get("bid") : bid);
            model.addAttribute("product", model.containsKey("product") ? model.get("product") : product);
            model.addAttribute("user", model.containsKey("user") ? model.get("user") : user);
            return "redirect:/bid/" + productId;
        } else {
            bidService.save(bid, product, user);
            return "redirect:/";
        }


    }

//    private String bidFormWith(ModelMap model) {
//        model.addAttribute("bid", model.containsKey("bid") ? model.get("bid") : new Bid());
//        return Page
//    }
}
