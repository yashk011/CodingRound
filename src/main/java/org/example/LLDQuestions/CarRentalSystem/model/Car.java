package org.example.LLDQuestions.CarRentalSystem.model;

import org.example.LLDQuestions.CarRentalSystem.enums.VehicleState;

import java.time.Instant;
import java.util.Date;

public class Car extends Vehicle {
    public Car(String vehicleNumber, String vehicleColor, int numOfPassenger, VehicleState vehicleState, String model) {
        super(vehicleNumber, vehicleColor, numOfPassenger, vehicleState, model, 2000,100, 15, Date.from(Instant.now()));
    }

}
