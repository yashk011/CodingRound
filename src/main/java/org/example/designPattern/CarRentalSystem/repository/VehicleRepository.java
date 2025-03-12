package org.example.designPattern.CarRentalSystem.repository;

import org.example.designPattern.CarRentalSystem.enums.VehicleState;
import org.example.designPattern.CarRentalSystem.model.Vehicle;

public interface VehicleRepository {

    public void addVehicle(Vehicle vehicle);
    public void removeVehicle(Vehicle vehicle);
    public Vehicle getVehicle(String carProperties);
}
