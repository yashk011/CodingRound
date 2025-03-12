package org.example.designPattern.ElevatorSystem;

import org.example.designPattern.ElevatorSystem.model.ElevatorCar;
import org.example.designPattern.ElevatorSystem.model.Floor;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    List<ElevatorCar> elevatorCars;
    List<Floor> floors;

    public ElevatorSystem() {
        elevatorCars = new ArrayList<>();
        floors = new ArrayList<>();
    }

    public Floor getFloor(int id) {
        return this.floors.get(id);
    }

    public void addElevatorCar(ElevatorCar elevatorCar) {
        this.elevatorCars.add(elevatorCar);
    }

    public void addFloor(Floor floor) {
        this.floors.add(floor);
    }
}
