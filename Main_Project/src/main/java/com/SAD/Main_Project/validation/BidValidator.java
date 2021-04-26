package com.SAD.Main_Project.validation;

import com.SAD.Main_Project.model.Bid;
import com.SAD.Main_Project.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class BidValidator implements Validator {

    @Autowired
    BidService bidService;


    @Override
    public boolean supports(Class<?> aClass) {
        return Bid.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Bid bid = (Bid) o;

        //Add validation logics
        double latestBidPrice = bidService.getLatestBid(bid.getProduct()).getPrice();

        // Reject if Bid amount is less than latest bid amount
        if (bid.getPrice() <= latestBidPrice) {
            errors.rejectValue("price", "bid.price.invalid");
        }
    }
}
