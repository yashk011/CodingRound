package org.example.elevatorSystem.model;

import org.example.elevatorSystem.enums.Direction;
import org.example.elevatorSystem.interfaces.Button;

public class DirectionButton implements Button {

    Direction direction;
    boolean status;

    public DirectionButton(boolean status , Direction direction) {
        this.status = status;
        this.direction = direction;
    }

    @Override
    public void pressButton() {
        this.status = true;
    }

    @Override
    public boolean isPressed() {
        return this.status;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
