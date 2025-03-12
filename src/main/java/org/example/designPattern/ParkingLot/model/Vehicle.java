package org.example.designPattern.ParkingLot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Vehicle {
    VehicleType vehicleType;
    String vehicleNumber;
}
