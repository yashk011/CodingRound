package org.example.designPattern.ObserverDesignPattern.example3.observer;

import org.example.designPattern.ObserverDesignPattern.example1.Observable;
import org.example.designPattern.ObserverDesignPattern.example3.StockObservable;

public class EmailNotificationObserver implements NotificationObserver{
    String emailId;
    StockObservable observable;

    public EmailNotificationObserver(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.observable = stockObservable;
    }
    @Override
    public void update() {
        System.out.println("Back in Stock - Hurry Up !!");
        sendMail();
    }

    private void sendMail() {
        System.out.println("Sending Mail to " + this.emailId);
    }

    public void setObservable(StockObservable observable) {
        this.observable = observable;
    }
}
