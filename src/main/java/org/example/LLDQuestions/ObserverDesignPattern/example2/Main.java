package org.example.LLDQuestions.ObserverDesignPattern.example2;

public class Main {
    public static void main(String[] args) {
        IWeatherStation weatherStation = new WeatherStation();
        Display display = new MobileDisplay(weatherStation);
        weatherStation.addDisplay(display);
        weatherStation.setWeather(100);
    }
}
