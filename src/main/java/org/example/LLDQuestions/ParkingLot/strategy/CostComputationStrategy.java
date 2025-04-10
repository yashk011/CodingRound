package org.example.LLDQuestions.ParkingLot.strategy;

import org.example.LLDQuestions.ParkingLot.model.ParkingTicket;

public interface CostComputationStrategy {

    public int findCost(ParkingTicket parkingTicket);
}
