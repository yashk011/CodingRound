package org.example.LLDQuestions.ParkingLot;

import org.example.LLDQuestions.ParkingLot.manager.ParkingSpotManager;
import org.example.LLDQuestions.ParkingLot.manager.ParkingSpotManagerFactory;
import org.example.LLDQuestions.ParkingLot.model.ParkingSpot;
import org.example.LLDQuestions.ParkingLot.model.VehicleType;
import org.example.LLDQuestions.ParkingLot.strategy.DefaultParkingStrategy;

public class ParkingLot {
    ExitGate exitGate;
    EntranceGate entranceGate;
    ParkingSpotManagerFactory parkingSpotManagerFactory;
    ParkingSpotManager parkingSpotManager;

    static ParkingLot parkingLot;

    private ParkingLot() {
        this.exitGate = new ExitGate();
        this.entranceGate = new EntranceGate();
        this.parkingSpotManagerFactory = new ParkingSpotManagerFactory();
    }

    public static ParkingLot getInstance() {
        if(parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void addParkingSpot(ParkingSpot parkingSpot, VehicleType vehicleType) {
        parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(vehicleType);
        parkingSpotManager.addParkingSpot(parkingSpot);
        parkingSpotManager.setParkingStrategy(new DefaultParkingStrategy());
    }

}
