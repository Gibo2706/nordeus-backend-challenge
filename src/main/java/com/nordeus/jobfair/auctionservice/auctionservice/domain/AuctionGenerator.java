package com.nordeus.jobfair.auctionservice.auctionservice.domain;

import java.util.Collection;
import java.util.Random;
import java.util.TimerTask;

import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.Auction;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.service.AuctionNotifer;

public class AuctionGenerator extends TimerTask {
	private final Collection<Auction> auctions;
	private final AuctionNotifer notifer;
	private final String imena = "Petar,Jovan,Marko,Luka,Bogdan,Igor,Milan,Uros,Filip";

	public AuctionGenerator(Collection<Auction> auctions, AuctionNotifer not) {
		this.auctions = auctions;
		this.notifer = not;
	}

	@Override
	public void run() {
		synchronized (auctions) {
			for (int i = 0; i < 10; i++) {
				Auction a = new Auction(imena.split(",")[new Random().nextInt(9)]);
				auctions.add(a);
			}
		}
		notifer.activeAuctionsRefreshed(auctions);
	}

}
