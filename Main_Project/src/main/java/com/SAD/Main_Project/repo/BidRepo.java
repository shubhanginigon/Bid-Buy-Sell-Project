package com.SAD.Main_Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.SAD.Main_Project.model.Bid;

@RepositoryRestResource(collectionResourceRel ="bids", path = "bids")
public interface BidRepo  extends JpaRepository<Bid, Integer> {

	Bid findByBid(int bid_id);
}
