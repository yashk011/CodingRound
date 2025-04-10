package org.example.LLDQuestions.ElevatorSystem;

import org.example.LLDQuestions.ElevatorSystem.controller.ElevatorController;
import org.example.LLDQuestions.ElevatorSystem.dispatcher.ExternalButtonDispatcher;
import org.example.LLDQuestions.ElevatorSystem.dispatcher.OddEvenDispatcher;
import org.example.LLDQuestions.ElevatorSystem.enums.Direction;
import org.example.LLDQuestions.ElevatorSystem.model.ElevatorCar;
import org.example.LLDQuestions.ElevatorSystem.model.ExternalPanel;
import org.example.LLDQuestions.ElevatorSystem.model.Floor;
import org.example.LLDQuestions.ElevatorSystem.model.FloorButton;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystemDemo {

    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem();
        ElevatorCar elevatorCar = new ElevatorCar();
        ExternalButtonDispatcher externalButtonDispatcher = new OddEvenDispatcher();
        externalButtonDispatcher.addElevatorController(new ElevatorController());

        FloorButton floorButton = new FloorButton(0, externalButtonDispatcher, Direction.UP);
        List<FloorButton> floorButtonList = new ArrayList<>();
        floorButtonList.add(floorButton);
        ExternalPanel externalPanel = new ExternalPanel(floorButtonList);
        Floor floor = new Floor(0, externalPanel);

        elevatorSystem.addElevatorCar(elevatorCar);
        elevatorSystem.addFloor(floor);

        Floor floor1 = elevatorSystem.getFloor(0);
        // 0 --> UP
        // 1 --> DOWN
        floor1.getExternalPanel().getFloorButton(0).pressButton();

    }
}
