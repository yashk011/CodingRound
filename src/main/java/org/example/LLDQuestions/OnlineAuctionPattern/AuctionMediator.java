package org.example.LLDQuestions.OnlineAuctionPattern;

public interface AuctionMediator {
    public void addBidder(AuctionParticipant bidder);
    public void placeBid(AuctionParticipant auctionParticipant, int amount);
}
