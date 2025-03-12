package org.example.elevatorSystem.model;

import lombok.Getter;
import org.example.elevatorSystem.enums.DoorAction;
import org.example.elevatorSystem.enums.FloorNumber;
import org.example.elevatorSystem.interfaces.Panel;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InsidePanel implements Panel {
    List<FloorButton> floorButtons;
    List<DoorButton> doorButtons;

    public InsidePanel() {
        floorButtons = new ArrayList<>();
        doorButtons = new ArrayList<>();

        for(int i=0;i<3;i++) {
            floorButtons.add(new FloorButton(false, FloorNumber.values()[i]));
        }

        for(int i=0;i<2;i++) {
            doorButtons.add(new DoorButton(false, DoorAction.values()[i]));
        }
    }

    public void closeDoor() {
        doorButtons.get(0).pressButton();
    }

    public void openDoor() {
        doorButtons.get(1).pressButton();
    }

    public void moveToFloor(int floor) {
        floorButtons.get(floor).pressButton();
    }

}
