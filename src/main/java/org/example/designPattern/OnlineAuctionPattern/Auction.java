package org.example.designPattern.OnlineAuctionPattern;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator{

    List<AuctionParticipant> bidders = new ArrayList<>();

    @Override
    public void addBidder(AuctionParticipant bidder) {
        bidders.add(bidder);
    }

    @Override
    public void placeBid(AuctionParticipant auctionParticipant, int amount) {

        for(AuctionParticipant ap : this.bidders) {
            if(!ap.getName().equals(auctionParticipant.getName()))
                ap.receiveNotification(amount);
        }
    }
}
