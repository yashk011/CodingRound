package org.example.LLDQuestions.ElevatorSystem.dispatcher;

import org.example.LLDQuestions.ElevatorSystem.controller.ElevatorController;

import java.util.List;

public class InternalButtonDispatcher {
    List<ElevatorController> elevatorControllerList;

    public void submitRequest(int id, int floorNumber) {
        elevatorControllerList.get(id).sendInternalRequest(floorNumber);
    }

}
