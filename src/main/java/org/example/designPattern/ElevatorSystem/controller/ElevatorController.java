package org.example.designPattern.ElevatorSystem.controller;

import org.example.designPattern.ElevatorSystem.enums.Direction;
import org.example.designPattern.ElevatorSystem.model.ElevatorCar;

import java.util.PriorityQueue;

public class ElevatorController {

    ElevatorCar elevatorCar;
    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;


    public ElevatorController() {
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a,b) -> b - a);
    }

    public void setElevatorCar(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    public void sendExternalRequest(int requestedFloor, Direction direction) {
        System.out.println("Added Req to Queue for external req");
    }

    public void sendInternalRequest(int floorNumber) {
        System.out.println("Added Req to Queue for internal req");
    }
}
