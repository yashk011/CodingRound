package org.example.designPattern.StrategyDesignPatterm.startegy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Driving Normally");
    }
}
