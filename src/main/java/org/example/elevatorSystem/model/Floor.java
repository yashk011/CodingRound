package org.example.elevatorSystem.model;

import lombok.Getter;
import lombok.Setter;
import org.example.elevatorSystem.enums.FloorNumber;

@Setter
@Getter
public class Floor {
    FloorNumber floorNumber;
    OutsidePanel outsidePanel;

    public Floor(FloorNumber floorNumber) {
        this.floorNumber = floorNumber;
        this.outsidePanel = new OutsidePanel();
    }
}
