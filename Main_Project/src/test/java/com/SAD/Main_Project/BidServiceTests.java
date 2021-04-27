package com.SAD.Main_Project;

import com.SAD.Main_Project.model.*;
import com.SAD.Main_Project.repo.BidRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootTest
public class BidServiceTests {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    BidRepo bidRepo;

    @Transactional
    @Test
    int updateBidWithoutConcurrency() {
        createScenario();

        Product product = em.find(Product.class, 1);
        User bidder3 = em.find(User.class, 3);
        Assertions.assertEquals("test1@gmail.com", bidder3.getEmail());

        Bid latestBid = bidRepo.findByBidId(product.getProductId());
        int previousVersion = latestBid.getVersion();
        double previousPrice = latestBid.getPrice();

        latestBid.setPrice(latestBid.getPrice() + 5.0);
        latestBid.setUser(bidder3);

        bidRepo.save(latestBid);

        Assertions.assertEquals(previousVersion, latestBid.getVersion());

        // Test if bid is valid bid
        Assertions.assertTrue(latestBid.getPrice() > previousPrice);

        // Test that it is new bidder has bid on product
        //Assertions.assertEquals(latestBid.getUser(), product.getBid().getUser());
        return previousVersion;
    }

    @Transactional
    @Test
    void updateBidWithConcurrency() {
        // Similar flow but, another bidder tries to update with same version
        // In this, 'bidder3' has made a update
        // Version gets increase in there
        int previousBidVersion = updateBidWithoutConcurrency();

        // Now we create 'bidder2' which is a concurrent user, and holds
        // the same version number while bidding
        Product product = em.find(Product.class, 1);
        User bidder2 = em.find(User.class, 2);
        Assertions.assertEquals("st121334@ait.asia", bidder2.getEmail());

        Bid latestBid = bidRepo.findByBidId(product.getProductId());
        double previousPrice = latestBid.getPrice();

        latestBid.setPrice(latestBid.getPrice() + 5.0);
        latestBid.setUser(bidder2);
        latestBid.setVersion(previousBidVersion - 1); // Setting previous version explicitly

        try {
            bidRepo.save(latestBid);
            System.out.println("Saved Successfully");
        } catch (ObjectOptimisticLockingFailureException e){
            System.out.println("Exception occurred: " + e.getMessage());
            // This should throw optimistic locking exception
            // Its still the previous version
            Assertions.assertNotEquals(latestBid.getVersion(), previousBidVersion);
            // For handling this exception, we try to save again in code.
        }
        // Test that it is new bidder could not bid on product
        Assertions.assertNotEquals(latestBid.getUser(), product.getBid().getUser());
    }

    @Transactional
    @Test
    void createScenario() {

        // st121334@ait.asia must be the latest Bidder, if not change in DB. or through UI
        Product product = em.find(Product.class, 1);
        User bidder2 = em.find(User.class, 2);
        Assertions.assertEquals("st121334@ait.asia", bidder2.getEmail());

        Bid latestBid = bidRepo.findByBidId(product.getProductId());
        latestBid.setPrice(latestBid.getPrice() + 5.0);
        latestBid.setUser(bidder2);

        bidRepo.save(latestBid);

        Role role = em.find(Role.class, 2);
        Assertions.assertEquals("ROLE_USER", role.getName());

        User seller = em.find(User.class, 1);
        Assertions.assertEquals("Default User", seller.getName());

        User bidder1 = em.find(User.class, 2);
        Assertions.assertEquals("st121334@ait.asia", bidder1.getEmail());


        Assertions.assertEquals("iPhone 11 pro", product.getName());
        Assertions.assertEquals(seller.getEmail(), product.getUser().getEmail());

        // Bidder 1 has the latest bid
        Assertions.assertEquals(bidder1.getName(), product.getBid().getUser().getName());



    }

}
