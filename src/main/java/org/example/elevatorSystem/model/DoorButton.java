package org.example.elevatorSystem.model;

import org.example.elevatorSystem.enums.DoorAction;
import org.example.elevatorSystem.interfaces.Button;

public class DoorButton implements Button {
    DoorAction doorAction;
    boolean status;

    public DoorButton(boolean status , DoorAction doorAction) {
        this.status = status;
        this.doorAction = doorAction;
    }

    @Override
    public void pressButton() {
        this.status = true;
    }

    @Override
    public boolean isPressed() {
        return status;
    }

    public void setDoorAction(DoorAction doorAction) {
        this.doorAction = doorAction;
    }

    public DoorAction getDoorAction() {
        return this.doorAction;
    }
}
