package org.example.designPattern.ObserverDesignPattern.example2;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements IWeatherStation{
    int temperature;
    List<Display> displayList;

    public WeatherStation() {
        displayList = new ArrayList<>();
    }

    @Override
    public void addDisplay(Display display) {
        displayList.add(display);
    }

    @Override
    public void removeDisplay(Display display) {
        displayList.remove(display);
    }

    @Override
    public void setWeather(int temperature) {
        this.temperature = temperature;
        notifyClients();
    }

    @Override
    public int getWeather() {
        return this.temperature;
    }

    @Override
    public void notifyClients() {
        for(Display display : displayList) {
            display.updateTemperature();
        }
    }
}
