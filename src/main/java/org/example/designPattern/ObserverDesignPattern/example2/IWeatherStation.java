package org.example.designPattern.ObserverDesignPattern.example2;

public interface IWeatherStation {
    public void addDisplay(Display display);
    public void removeDisplay(Display display);
    public void setWeather(int temperature);
    public int getWeather();
    public void notifyClients();
}
