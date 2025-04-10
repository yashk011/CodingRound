package org.example.LLDQuestions.ParkingLot.strategy;

import org.example.LLDQuestions.ParkingLot.model.ParkingTicket;

public class FixedParkingCostStrategy implements CostComputationStrategy {
    @Override
    public int findCost(ParkingTicket parkingTicket) {
        return parkingTicket.getParkingSpot().getPrice();
    }
}
