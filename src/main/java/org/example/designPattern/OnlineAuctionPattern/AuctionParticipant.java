package org.example.designPattern.OnlineAuctionPattern;

public interface AuctionParticipant {
    public void bidAmount(int amount);
    public void receiveNotification(int amount);
    public String getName();
}
