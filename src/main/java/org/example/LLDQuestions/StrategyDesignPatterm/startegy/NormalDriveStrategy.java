package org.example.LLDQuestions.StrategyDesignPatterm.startegy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Driving Normally");
    }
}
