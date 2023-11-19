package com.nordeus.jobfair.auctionservice.auctionservice.domain.model;

import lombok.Getter;

@Getter
public class Bid {
	@Getter
	private UserId user;
	@Getter
	private AuctionId auctionId;
	@Getter
	private final long time;

	public Bid(UserId uID, AuctionId aID) {
		this.user = uID;
		this.auctionId = aID;
		this.time = System.currentTimeMillis();
	}

	public UserId getUser() {
		return user;
	}

	public AuctionId getAuctionId() {
		return auctionId;
	}

	public long getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "Bid [user=" + user + ", auctionId=" + auctionId + "]";
	}

	
}
