package org.example.LLDQuestions.ParkingLot.strategy;

import lombok.SneakyThrows;
import org.example.LLDQuestions.ParkingLot.model.ParkingSpot;

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
