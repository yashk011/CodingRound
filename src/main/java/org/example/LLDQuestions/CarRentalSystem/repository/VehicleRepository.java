package org.example.LLDQuestions.CarRentalSystem.repository;

import org.example.LLDQuestions.CarRentalSystem.model.Vehicle;

public interface VehicleRepository {

    public void addVehicle(Vehicle vehicle);
    public void removeVehicle(Vehicle vehicle);
    public Vehicle getVehicle(String carProperties);
}
