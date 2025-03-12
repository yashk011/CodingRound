package org.example.designPattern.ElevatorSystem.dispatcher;

import org.example.designPattern.ElevatorSystem.enums.Direction;

public class OddEvenDispatcher extends ExternalButtonDispatcher {

    @Override
    public void submitRequest(int requestedFloor, Direction direction) {
        // #1 Algorithm to find the correct elevator suppose if floor is odd, we have config of
        //    those elevators which serve odd request
        // #2 Call acceptRequest on elevator controller corresponding to the found elevator
        System.out.println("Submitted Req to Controller - " +  requestedFloor + " for " + direction.name());
        elevatorControllerList.get(0).sendExternalRequest(requestedFloor, direction);
    }

}
