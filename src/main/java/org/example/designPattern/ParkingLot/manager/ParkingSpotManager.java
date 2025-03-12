package org.example.designPattern.ParkingLot.manager;

import org.example.designPattern.ParkingLot.model.ParkingSpot;
import org.example.designPattern.ParkingLot.model.Vehicle;
import org.example.designPattern.ParkingLot.strategy.ParkingStrategy;

import java.util.List;

public class ParkingSpotManager {
    List<ParkingSpot> parkingSpotList;
    ParkingStrategy parkingStrategy;

    public ParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotList.add(parkingSpot);
    }

    public void removeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotList.remove(parkingSpot);
    }

    public boolean parkVehicle(ParkingSpot parkingSpot, Vehicle vehicle) {
        parkingSpotList.remove(parkingSpot);
        parkingSpot.parkVehicle(vehicle);
        return true;
    }

    public boolean unParkVehicle(ParkingSpot parkingSpot) {
        parkingSpotList.add(parkingSpot);
        parkingSpot.unParkVehicle();
        return true;
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        return null;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
    }

}
