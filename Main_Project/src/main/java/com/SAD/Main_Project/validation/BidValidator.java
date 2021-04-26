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

        Bid latestBid = bidService.getLatestBid(bid.getProduct());

        if (latestBid == null) {
            if (bid.getPrice() <= bid.getProduct().getPrice()) {
                errors.rejectValue("price", "bid.price.invalid");
            }
        } else {
            // Reject if Bid amount is less than latest bid amount
            if (bid.getPrice() <= latestBid.getPrice())  {
                errors.rejectValue("price", "bid.price.invalid");
            }
        }
    }
}
