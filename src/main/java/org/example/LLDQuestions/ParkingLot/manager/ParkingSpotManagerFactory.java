package org.example.LLDQuestions.ParkingLot.manager;

import org.example.LLDQuestions.ParkingLot.model.VehicleType;

import java.util.ArrayList;

public class ParkingSpotManagerFactory {

    public ParkingSpotManager getParkingSpotManager(VehicleType vehicleType) {
        if(vehicleType.name().equalsIgnoreCase(VehicleType.TWO_WHEELER.name()))
            return TwoWheelerParkingSpotManager.getParkingSpotManager(new ArrayList<>());
        else
            return FourWheelerParkingSpotManager.getParkingSpotManager(new ArrayList<>());
    }
}
