package com.nordeus.jobfair.auctionservice.auctionservice.domain;

import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.*;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.service.AuctionNotifer;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.service.AuctionNotifierLogger;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Timer;

@Service
public class AuctionServiceImpl implements AuctionService {

	private final AuctionNotifer auctionNotifer;
	private final Collection<Auction> auctions;
	private Timer schedulerTimer;

	public AuctionServiceImpl() {
		this.auctionNotifer = new AuctionNotifierLogger();
		this.auctions = new LinkedList<>();
		this.schedulerTimer = new Timer();
		System.err.println("Pokrenut je!");
		schedulerTimer.schedule(new AuctionGenerator(auctions, auctionNotifer), 0, 60_000);
		schedulerTimer.schedule(new RefreshAuction(auctions, auctionNotifer), 2000, 2000);
	}

	@Override
	public Collection<Auction> getAllActive() {
		return auctions;
	}

	@Override
	public Auction getAuction(AuctionId auctionId) {
		return findAuction(auctionId);
	}

	@Override
	public void join(AuctionId auctionId, User user) {
		Auction a = findAuction(auctionId);
		System.err.println(user.getUserId().id);
		a.getUsers().add(user);
	}

	@Override
	public void bid(AuctionId auctionId, UserId userId) {
		Bid bid = new Bid(userId, auctionId);
		Auction a = findAuction(auctionId);
		a.setCurrBid(bid);
		a.setPrice(a.getPrice() + 1);
		auctionNotifer.bidPlaced(bid);
	}

	private Auction findAuction(AuctionId auctionId) {
		synchronized (auctions) {
			for (Auction a : auctions) {
				if (a.getAuctionId() == auctionId)
					return a;

			}
		}

		return null;
	}
}
