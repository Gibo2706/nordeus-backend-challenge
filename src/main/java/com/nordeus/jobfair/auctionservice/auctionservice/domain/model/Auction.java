package com.nordeus.jobfair.auctionservice.auctionservice.domain.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Auction {
	@Getter
	private String playerName;
	@Getter
	private final AuctionId auctionId;
	@Getter
	@Setter
	private Bid currBid;
	@Getter
	private List<User> users;
	@Getter
	@Setter
	private int price;
	@Getter
	private long time;
	

	public Auction(String pName) {
		this.auctionId = new AuctionId();
		this.users = new ArrayList<>();
		this.price = 1;
		this.playerName = pName;
		this.currBid = null;
		this.time = System.currentTimeMillis();
	}
	
	

	public Bid getCurrBid() {
		return currBid;
	}



	public void setCurrBid(Bid currBid) {
		this.currBid = currBid;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getPlayerName() {
		return playerName;
	}



	public AuctionId getAuctionId() {
		return auctionId;
	}



	public List<User> getUsers() {
		return users;
	}



	public long getTime() {
		return time;
	}



	@Override
	public String toString() {
		return auctionId + " Name: " + playerName + " Current bid: " + currBid + " Current price: " + price;
	}
}
