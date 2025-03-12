package org.example.designPattern.ElevatorSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Floor {
    int floorNumber;
    ExternalPanel externalPanel;

}
