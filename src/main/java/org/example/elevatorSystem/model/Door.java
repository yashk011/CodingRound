package org.example.elevatorSystem.model;

import org.example.elevatorSystem.enums.DoorAction;


public class Door {

    DoorAction doorAction;

    public Door() {
        this.doorAction = DoorAction.CLOSE;
    }
    public void openDoor() {
        doorAction = DoorAction.OPEN;
    }

    public void closeDoor() {
        doorAction = DoorAction.CLOSE;
    }
}
