package org.example.LLDQuestions.ParkingLot.manager;

import org.example.LLDQuestions.ParkingLot.model.ParkingSpot;
import org.example.LLDQuestions.ParkingLot.model.Vehicle;
import org.example.LLDQuestions.ParkingLot.strategy.ParkingStrategy;

import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager{

    static ParkingSpotManager parkingSpotManager;

    public FourWheelerParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        super(parkingSpotList);
    }

    public static ParkingSpotManager getParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        if(parkingSpotManager == null) {
            parkingSpotManager = new FourWheelerParkingSpotManager(parkingSpotList);
        }
        return parkingSpotManager;
    }


    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    @Override
    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        return parkingStrategy.findParkingSpot(this.parkingSpotList);
    }

}
