package org.example.elevatorSystem;

import org.example.elevatorSystem.enums.Direction;
import org.example.elevatorSystem.enums.ElevatorNumber;
import org.example.elevatorSystem.enums.FloorNumber;
import org.example.elevatorSystem.model.DirectionButton;
import org.example.elevatorSystem.model.Floor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance();
        List<Elevator> elevators = new ArrayList<>();
        List<Floor> floors = new ArrayList<>();
        Floor floor1 = new Floor(FloorNumber.FLOOR1);

        for(int i =0;i<3;i++) {
            elevators.add(new Elevator(ElevatorNumber.values()[i]));
            floors.add(new Floor(FloorNumber.values()[i]));
        }

        elevatorSystem.setElevators(elevators);
        elevatorSystem.setFloors(floors);

        Direction requestedDirection = floor1.getOutsidePanel().moveUp();
        FloorNumber requestedFloor = FloorNumber.FLOOR3;


        Elevator elevator = elevatorSystem.requestElevator(requestedDirection, floor1);
        System.out.println("Elevator System Arrived - " + elevator.getElevatorNumber());

        elevatorSystem.selectFloor(requestedFloor , elevator);


    }
}
