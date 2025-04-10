package org.example.LLDQuestions.StrategyDesignPatterm.startegy;

public class OffRoadDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Driving on OffRoad");
    }
}
