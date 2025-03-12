package org.example.designPattern.StrategyDesignPatterm;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new OffRoadVehicle();
        vehicle.drive();
    }
}
