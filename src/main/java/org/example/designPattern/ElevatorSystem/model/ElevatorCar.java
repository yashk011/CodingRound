package org.example.designPattern.ElevatorSystem.model;

import org.example.designPattern.ElevatorSystem.enums.Direction;
import org.example.designPattern.ElevatorSystem.enums.State;

public class ElevatorCar {
    int id;
    Door door;
    Display display;
    int currentFloor;
    Direction currentDirection;
    State elevatorState;
    InternalPanel internalPanel;
    static int counter;

    public ElevatorCar() {
        id = counter++;
        door = new Door();
        display = new Display();
        currentFloor = 0;
        currentDirection = Direction.UP;
        elevatorState = State.IDLE;
    }

    public void moveToFloor(int floor, Direction direction) {
        System.out.println("Moving to Floor " + floor);
        this.currentFloor = currentFloor;
        this.currentDirection = direction;
    }
}
