package org.example.LLDQuestions.CarRentalSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.LLDQuestions.CarRentalSystem.enums.VehicleState;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Vehicle {
    String vehicleNumber;
    String vehicleColor;
    int numOfPassengers;

    @Setter
    VehicleState vehicleState;

    String model;
    int dailyRentalCost;
    int hourlyRentalCost;
    int average;
    Date dom;

    public void reserveVehicle() {
        this.vehicleState = VehicleState.RESERVED;
    }
}
