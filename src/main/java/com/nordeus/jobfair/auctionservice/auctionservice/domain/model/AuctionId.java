package com.nordeus.jobfair.auctionservice.auctionservice.domain.model;

import java.util.Random;

import lombok.Getter;

public class AuctionId {
	@Getter
	private final int id;

	public AuctionId() {
		this.id = new Random().nextInt();
	}
	
	@Override
	public String toString() {
		return Integer.toString(id);
	}

	public int getId() {
		return id;
	}
	
	
}
