package org.example.LLDQuestions.ObserverDesignPattern.example3.observer;

import org.example.LLDQuestions.ObserverDesignPattern.example3.StockObservable;

public class PhoneNotificationObserver implements NotificationObserver{
    String phoneNumber;
    StockObservable observable;

    public PhoneNotificationObserver(String phoneNumber, StockObservable stockObservable) {
        this.phoneNumber = phoneNumber;
        this.observable = stockObservable;
    }
    @Override
    public void update() {
        System.out.println("Back in Stock - Hurry Up !!");
        sendMessage();
    }

    private void sendMessage() {
        System.out.println("Sending Message to " + this.phoneNumber);
    }

    public void setObservable(StockObservable observable) {
        this.observable = observable;
    }
}
