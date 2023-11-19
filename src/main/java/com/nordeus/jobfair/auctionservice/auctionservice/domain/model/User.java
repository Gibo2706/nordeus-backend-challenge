package com.nordeus.jobfair.auctionservice.auctionservice.domain.model;

import lombok.Getter;


public class User {
	@Getter
	private final UserId userId;
	@Getter
	private final String name;
	
	public User(String name) {
		this.userId = new UserId();
		this.name = name;
	}

	public UserId getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}
	
}
