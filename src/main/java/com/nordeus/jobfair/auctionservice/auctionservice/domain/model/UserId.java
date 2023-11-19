package com.nordeus.jobfair.auctionservice.auctionservice.domain.model;

import java.util.Random;

import lombok.Getter;

public class UserId {
	@Getter
	public final int id;

	public UserId() {
		this.id = new Random().nextInt();
	}
}
