package com.SAD.Main_Project.service;

import com.SAD.Main_Project.model.Bid;

public interface BidService {
	
	Bid findByBidId(int bid_id);
	
	void save(Bid bid);
}
