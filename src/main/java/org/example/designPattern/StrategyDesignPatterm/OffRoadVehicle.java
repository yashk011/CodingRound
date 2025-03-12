package org.example.designPattern.StrategyDesignPatterm;

import org.example.designPattern.StrategyDesignPatterm.startegy.OffRoadDriveStrategy;

public class OffRoadVehicle extends Vehicle{

    public OffRoadVehicle() {
        super(new OffRoadDriveStrategy());
    }
}
