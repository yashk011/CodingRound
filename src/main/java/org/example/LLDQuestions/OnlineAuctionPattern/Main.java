package org.example.LLDQuestions.OnlineAuctionPattern;

public class Main {
    public static void main(String[] args) {
        AuctionMediator IPLMediator = new Auction();
        AuctionParticipant KXI_PJB = new Bidder("Preeti", IPLMediator );
        AuctionParticipant RajashanRoyals = new Bidder("Shilpa", IPLMediator );
        AuctionParticipant KolkataKnightRiders = new Bidder("Shahrukh", IPLMediator );

        KXI_PJB.bidAmount(1000);
        RajashanRoyals.bidAmount(1010);
        KolkataKnightRiders.bidAmount(2000);
    }
}
