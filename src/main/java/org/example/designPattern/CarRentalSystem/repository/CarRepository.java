package org.example.designPattern.CarRentalSystem.repository;


import org.example.designPattern.CarRentalSystem.model.Car;
import org.example.designPattern.CarRentalSystem.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements VehicleRepository{

    List<Vehicle> carStock;

//    public CarRepository(List<Vehicle> vehicles) {
//        this.carStock = vehicles;
//    }

    public CarRepository() {
        carStock = new ArrayList<>();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        carStock.add(vehicle);
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        carStock.remove(vehicle);
    }

    @Override
    public Vehicle getVehicle(String carProperties) {
        // get vehicle based on certain properties ... u can also send a list
        return carStock.get(0);
    }

}
