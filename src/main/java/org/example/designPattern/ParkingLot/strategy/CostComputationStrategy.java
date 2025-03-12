package org.example.designPattern.ParkingLot.strategy;

import org.example.designPattern.ParkingLot.model.ParkingTicket;

public interface CostComputationStrategy {

    public int findCost(ParkingTicket parkingTicket);
}
