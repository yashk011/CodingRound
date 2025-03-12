package org.example.designPattern.StrategyDesignPatterm;

import org.example.designPattern.StrategyDesignPatterm.startegy.NormalDriveStrategy;

public class NormalVehicle extends Vehicle{
//    @Override
//    public void drive() {
//        super.drive();
//    }

    public NormalVehicle() {
        super(new NormalDriveStrategy());
    }
}
