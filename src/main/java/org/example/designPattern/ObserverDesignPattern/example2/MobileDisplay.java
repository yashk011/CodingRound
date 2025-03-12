package org.example.designPattern.ObserverDesignPattern.example2;

import org.example.designPattern.ObserverDesignPattern.example1.Observable;

public class MobileDisplay implements Display{

    IWeatherStation weatherStation;

    public MobileDisplay(IWeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void updateTemperature() {
        System.out.println("Temperature updated " +  weatherStation.getWeather());
    }

    @Override
    public void displayTemperature() {
    }
}
