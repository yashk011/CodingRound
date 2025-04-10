package org.example.LLDQuestions.OnlineAuctionPattern;

import lombok.Getter;

public class Bidder implements AuctionParticipant{
    @Getter
    String name;
    AuctionMediator auctionMediator;

    public Bidder(String name, AuctionMediator auctionMediator) {
        this.auctionMediator = auctionMediator;
        this.name = name;
        auctionMediator.addBidder(this);
    }

    @Override
    public void bidAmount(int amount) {
        System.out.println(this.name + " Bids for " + amount);
        auctionMediator.placeBid(this, amount);
    }

    @Override
    public void receiveNotification(int amount) {
        System.out.println("Someone bid for amount " + amount);
    }
}
