package org.example.LLDQuestions.ParkingLot.model;

import java.util.UUID;

public class TwoWheelerParkingSpot extends ParkingSpot{

    public TwoWheelerParkingSpot() {
        super(UUID.randomUUID().toString(),null, false , 20);
    }

    public int getPrice() {
        return this.price;
    }

}
