package org.example.LLDQuestions.ElevatorSystem.model;

import org.example.LLDQuestions.ElevatorSystem.dispatcher.InternalButtonDispatcher;

public class ElevatorButton implements Button{
    int floor;
    boolean isPressed;
    InternalButtonDispatcher internalButtonDispatcher;

    @Override
    public void pressButton() {
        isPressed = true;
        internalButtonDispatcher = new InternalButtonDispatcher();
    }

    public boolean isPressed() {
        return this.isPressed;
    }
}
