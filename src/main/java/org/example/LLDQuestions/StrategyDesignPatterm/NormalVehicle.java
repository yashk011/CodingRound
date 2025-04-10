package org.example.LLDQuestions.StrategyDesignPatterm;

import org.example.LLDQuestions.StrategyDesignPatterm.startegy.NormalDriveStrategy;

public class NormalVehicle extends Vehicle{
//    @Override
//    public void drive() {
//        super.drive();
//    }

    public NormalVehicle() {
        super(new NormalDriveStrategy());
    }
}
