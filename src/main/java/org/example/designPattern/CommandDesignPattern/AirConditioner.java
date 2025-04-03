package org.example.designPattern.CommandDesignPattern;

public class AirConditioner {
    int temperature;
    boolean isOn;

    public void turnOn() {
        System.out.println("AC Turned on");
        this.isOn = true;
    }

    public void turnOff() {
        System.out.println("AC Turned Off");
        this.isOn = false;
    }

    public void setTemperature(int temperature) {
        System.out.println("AC temperature set to " + temperature);
        this.temperature = temperature;
    }
}
