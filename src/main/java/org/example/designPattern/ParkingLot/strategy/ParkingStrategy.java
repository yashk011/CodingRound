package org.example.designPattern.ParkingLot.strategy;

import org.example.designPattern.ParkingLot.model.ParkingSpot;
import org.example.designPattern.ParkingLot.model.Vehicle;

import java.util.List;

public interface ParkingStrategy {

    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpotList);
}
