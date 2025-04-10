package org.example.LLDQuestions.ParkingLot.strategy;

import org.example.LLDQuestions.ParkingLot.model.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {

    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpotList);
}
