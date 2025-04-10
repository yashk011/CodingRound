package org.example.LLDQuestions.ParkingLot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParkingSpot {
    String id;
    Vehicle vehicle;
    boolean isEmpty;
    int price;

    public boolean parkVehicle(Vehicle vehicle) {
        this.setVehicle(vehicle);
        this.isEmpty = false;
        return true;
    }

    public boolean unParkVehicle() {
        this.setVehicle(null);
        this.isEmpty = true;
        return true;
    }

}
