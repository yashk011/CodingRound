package org.example.designPattern.ParkingLot.model;

import java.util.UUID;

public class FourWheelerParkingSpot extends ParkingSpot{
    int price;

    public FourWheelerParkingSpot() {
        super(UUID.randomUUID().toString(),null, false , 40);
    }

    public int getPrice() {
        return this.price;
    }

}
