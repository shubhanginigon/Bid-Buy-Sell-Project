package com.SAD.Main_Project.service;

import com.SAD.Main_Project.model.Bid;
import com.SAD.Main_Project.model.Product;
import com.SAD.Main_Project.model.User;

public interface BidService {
	
	Bid findByBidId(int bid_id);
	
	void save(Bid bid, Product product, User user);

	Bid getLatestBid(Product product);
}
