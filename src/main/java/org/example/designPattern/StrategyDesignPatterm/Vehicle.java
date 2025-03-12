package org.example.designPattern.StrategyDesignPatterm;

//Without strategy


//public class Vehicle {
//    public void drive() {
//        System.out.println("Driving in normal terrain with average speed");
//    }
//}

import org.example.designPattern.StrategyDesignPatterm.startegy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}


