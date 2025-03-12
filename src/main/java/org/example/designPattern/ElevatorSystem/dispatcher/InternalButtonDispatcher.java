package org.example.designPattern.ElevatorSystem.dispatcher;

import org.example.designPattern.ElevatorSystem.controller.ElevatorController;

import java.util.HashMap;
import java.util.List;

public class InternalButtonDispatcher {
    List<ElevatorController> elevatorControllerList;

    public void submitRequest(int id, int floorNumber) {
        elevatorControllerList.get(id).sendInternalRequest(floorNumber);
    }

}
