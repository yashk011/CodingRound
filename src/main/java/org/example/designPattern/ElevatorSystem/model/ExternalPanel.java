package org.example.designPattern.ElevatorSystem.model;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
public class ExternalPanel {
    List<FloorButton> floorButtonList;

    public FloorButton  getFloorButton(int floor) {
        return floorButtonList.get(floor);
    }
}
