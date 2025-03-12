package org.example.designPattern.ParkingLot.strategy;

import lombok.SneakyThrows;
import org.example.designPattern.ParkingLot.model.ParkingSpot;
import org.example.designPattern.ParkingLot.model.Vehicle;

import java.util.List;

public class DefaultParkingStrategy implements ParkingStrategy{
    @Override
    @SneakyThrows
    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpotList) {
        if(parkingSpotList.isEmpty())
            throw new Exception("Parking Lot is full");

        return parkingSpotList.get(0);
    }
}
