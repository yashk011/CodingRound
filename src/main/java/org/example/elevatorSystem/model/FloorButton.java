package org.example.elevatorSystem.model;

import org.example.elevatorSystem.enums.FloorNumber;
import org.example.elevatorSystem.interfaces.Button;

public class FloorButton implements Button {

    FloorNumber floorNumber;
    boolean status;

    public FloorButton(boolean status, FloorNumber floorNumber) {
        status = false;
        floorNumber = floorNumber;
    }
    @Override
    public void pressButton() {
        System.out.println("Button Pressed , Elevator is Moving");
        this.status = true;
    }

    @Override
    public boolean isPressed() {
        System.out.println("Button Pressed , Elevator is Moving");
        return this.status;
    }

    public FloorNumber getFloorNumber() {
        return this.floorNumber;
    }

    public void setFloorNumber(FloorNumber floorNumber) {
        this.floorNumber = floorNumber;
    }
}
