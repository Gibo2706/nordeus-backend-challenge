package com.nordeus.jobfair.auctionservice.auctionservice.api;

import com.nordeus.jobfair.auctionservice.auctionservice.domain.AuctionService;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.Auction;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.AuctionId;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.User;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.UserId;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/auctions")
public class HttpController {

	@Autowired
    private AuctionService auctionService;

    @GetMapping("/active")
    public Collection<Auction> getAllActive() {
        return auctionService.getAllActive();
    }
    
    @PostMapping(path = "/join/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void joinNewUser(@RequestBody AuctionId auctionId, @RequestBody User user) {    	
    	auctionService.join(auctionId, user);

    }
    
    @PostMapping("/bid/")
    public void bidAuction(@RequestBody AuctionId auctionId,@RequestBody UserId userId) {
    	auctionService.bid(auctionId, userId);
    }
}
