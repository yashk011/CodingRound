package org.example.designPattern.ElevatorSystem.model;

import org.example.designPattern.ElevatorSystem.dispatcher.ExternalButtonDispatcher;
import org.example.designPattern.ElevatorSystem.dispatcher.OddEvenDispatcher;
import org.example.designPattern.ElevatorSystem.enums.Direction;

public class FloorButton implements Button{
    int floor;
    boolean isPressed;
    Direction direction;

    ExternalButtonDispatcher externalButtonDispatcher;

    public FloorButton(int floor , ExternalButtonDispatcher externalButtonDispatcher, Direction direction) {
        this.floor = floor;
        this.externalButtonDispatcher = externalButtonDispatcher;
        this.direction = direction;
    }
    @Override
    public void pressButton() {
        this.isPressed = true;
        this.externalButtonDispatcher.submitRequest(this.floor, this.direction);
    }

    public boolean isPressed() {
        return this.isPressed;
    }
}