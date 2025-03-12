package org.example.designPattern.ElevatorSystem.dispatcher;

import org.example.designPattern.ElevatorSystem.controller.ElevatorController;
import org.example.designPattern.ElevatorSystem.enums.Direction;

import java.util.ArrayList;
import java.util.List;

public class ExternalButtonDispatcher {

    List<ElevatorController> elevatorControllerList;

    public ExternalButtonDispatcher() {
        elevatorControllerList = new ArrayList<>();
    }

    public void submitRequest(int requestedFloor, Direction direction) {
        System.out.println("Submitting Req to Controller - " +  requestedFloor + " for " + direction.name());
        elevatorControllerList.get(0).sendExternalRequest(requestedFloor, direction);
    }

    public void addElevatorController(ElevatorController elevatorController) {
        elevatorControllerList.add(elevatorController);
    }


}
