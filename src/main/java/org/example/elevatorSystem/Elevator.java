package org.example.elevatorSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.elevatorSystem.enums.Direction;
import org.example.elevatorSystem.enums.ElevatorNumber;
import org.example.elevatorSystem.enums.FloorNumber;
import org.example.elevatorSystem.model.Door;
import org.example.elevatorSystem.model.InsidePanel;

@AllArgsConstructor
public class Elevator {

    @Getter
    ElevatorNumber elevatorNumber;

    @Getter
    Door door;

    @Getter
    InsidePanel innerPanel;

    @Setter
    FloorNumber currentFloorNumber;

    @Setter
    Direction currentDirection;

    @Setter
    int weight;

    int capacity;

    public Elevator(ElevatorNumber elevatorNumber) {
        this.elevatorNumber = elevatorNumber;
        door = new Door();
        innerPanel = new InsidePanel();
        currentFloorNumber = FloorNumber.FLOOR1;
        currentDirection = Direction.IDLE;
        weight = 0;
        capacity = 400;
    }

}
