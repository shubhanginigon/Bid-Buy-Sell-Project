package com.SAD.Main_Project.service;

import com.SAD.Main_Project.model.Product;
import com.SAD.Main_Project.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.SAD.Main_Project.model.Bid;
import com.SAD.Main_Project.repo.BidRepo;

import javax.persistence.OptimisticLockException;

@Service
public class BidServiceImpl implements BidService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BidServiceImpl.class);
	
	@Autowired
	BidRepo bidRepo;

	@Override
	public Bid findByBidId(int bid_id) {
		return bidRepo.findByBidId(bid_id);
	}

	@Override
	public void save(Bid bid, Product product, User user) {

		Bid newBid;

		if (product.getBid() == null) {
			// Build Bid and attach with product
			newBid = Bid.builder()
					.bidId(product.getProductId())
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

		LOGGER.info("BID DETAILS: {}", newBid);

		// Check for Optimistic Locking

		try {
			bidRepo.save(newBid);
			LOGGER.info("BID SUCCESSFUL: Amount: {}", newBid.getPrice());
		} catch (ObjectOptimisticLockingFailureException e) {
			LOGGER.error("Optimistic Lock Exception Occurred: {}", e.getLocalizedMessage());
			if (newBid.getPrice() > getLatestBid(product).getPrice()) {
				// If unsuccessful bid is greater than previously updated bid, then try again to save
				save(newBid, newBid.getProduct(), newBid.getUser());
			}
		}



	}

	@Override
	public Bid getLatestBid(Product product) {
		return product.getBid();
	}
}
