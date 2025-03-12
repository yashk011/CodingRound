package org.example.designPattern.ParkingLot.strategy;

import org.example.designPattern.ParkingLot.model.ParkingTicket;

public class FixedParkingCostStrategy implements CostComputationStrategy {
    @Override
    public int findCost(ParkingTicket parkingTicket) {
        return parkingTicket.getParkingSpot().getPrice();
    }
}
