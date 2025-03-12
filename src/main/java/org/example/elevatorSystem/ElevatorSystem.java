package org.example.elevatorSystem;

import lombok.Getter;
import org.example.elevatorSystem.enums.Direction;
import org.example.elevatorSystem.enums.ElevatorNumber;
import org.example.elevatorSystem.enums.FloorNumber;
import org.example.elevatorSystem.model.DirectionButton;
import org.example.elevatorSystem.model.Floor;

import javax.swing.*;
import java.util.List;

@Getter
public class ElevatorSystem {
    List<Floor> floors;
    List<Elevator> elevators;
    public static ElevatorSystem instance;

    public static ElevatorSystem getInstance() {
        if(instance == null) {
            instance = new ElevatorSystem();
        }
        return instance;
    }

    private ElevatorSystem() {
    }

    public void setElevators(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    //requested floor and where to move
    public Elevator requestElevator(Direction direction, Floor currentFloor) {
        return this.elevators.get(0); // Logic to find the elevator
    }

    public void openDoor(Elevator elevator) {
        elevator.getDoor().openDoor();
    }

    public void closeDoor(Elevator elevator) {
        elevator.getDoor().closeDoor();
    }

    public void selectFloor(FloorNumber floor, Elevator elevator) {
        System.out.println("Request to move Elevator to requested floor " + floor.ordinal());
        elevator.getInnerPanel().moveToFloor(floor.ordinal()); // Logic to Move Elevator
    }
}
