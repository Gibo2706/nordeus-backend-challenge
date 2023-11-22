package com.nordeus.jobfair.auctionservice.auctionservice.domain;

import java.util.Collection;
import java.util.Iterator;
import java.util.TimerTask;

import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.Auction;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.service.AuctionNotifer;

public class RefreshAuction extends TimerTask {
	private final Collection<Auction> auctions;
	private final AuctionNotifer notifer;

	public RefreshAuction(Collection<Auction> auctions, AuctionNotifer not) {
		this.auctions = auctions;
		this.notifer = not;
	}

	@Override
	public void run() {
		synchronized (auctions) {
			long time = System.currentTimeMillis();
			Iterator<Auction> it = auctions.iterator();
			while (it.hasNext()) {
				Auction a = it.next();
				if (time - a.getTime() > 59_700) {
					if (a.getCurrBid() == null || time - a.getCurrBid().getTime() > 5_000) {
						notifer.auctionFinished(a);
						it.remove();
					}
				}
			}
			notifer.activeAuctionsRefreshed(auctions);
		}
	}

}
