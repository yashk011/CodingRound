package org.example.LLDQuestions.ParkingLot.manager;

import org.example.LLDQuestions.ParkingLot.model.ParkingSpot;
import org.example.LLDQuestions.ParkingLot.model.Vehicle;
import org.example.LLDQuestions.ParkingLot.strategy.ParkingStrategy;

import java.util.List;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager {
    static ParkingSpotManager parkingSpotManager;
    public ParkingStrategy parkingStrategy;

    public TwoWheelerParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        super(parkingSpotList);
    }

    public static ParkingSpotManager getParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        if(parkingSpotManager == null) {
            parkingSpotManager = new TwoWheelerParkingSpotManager(parkingSpotList);
        }
        return parkingSpotManager;
    }

    @Override
    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    @Override
    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        return parkingStrategy.findParkingSpot(this.parkingSpotList);
    }
}
