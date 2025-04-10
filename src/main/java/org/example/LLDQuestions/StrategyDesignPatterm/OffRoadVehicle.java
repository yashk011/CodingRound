package org.example.LLDQuestions.StrategyDesignPatterm;

import org.example.LLDQuestions.StrategyDesignPatterm.startegy.OffRoadDriveStrategy;

public class OffRoadVehicle extends Vehicle{

    public OffRoadVehicle() {
        super(new OffRoadDriveStrategy());
    }
}
