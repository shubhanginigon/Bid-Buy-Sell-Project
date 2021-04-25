package com.SAD.Main_Project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SAD.Main_Project.model.Bid;
import com.SAD.Main_Project.repo.BidRepo;

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
	public void save(Bid bid) {
		LOGGER.info("BID DETAILS: {}", bid);
		bidRepo.save(bid);		
	}
	
}
