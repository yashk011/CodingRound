package org.example.LLDQuestions.ObserverDesignPattern.example3;

import org.example.LLDQuestions.ObserverDesignPattern.example3.observer.EmailNotificationObserver;
import org.example.LLDQuestions.ObserverDesignPattern.example3.observer.NotificationObserver;
import org.example.LLDQuestions.ObserverDesignPattern.example3.observer.PhoneNotificationObserver;

public class Main {
    public static void main(String[] args) {

        StockObservable iPhoneStockObservable = new IPhoneObservable();

        NotificationObserver notificationObserver = new EmailNotificationObserver("yash@gmail.com", iPhoneStockObservable);
        NotificationObserver notificationObserver2 = new PhoneNotificationObserver("9122234455", iPhoneStockObservable);

        iPhoneStockObservable.addObserver(notificationObserver);
        iPhoneStockObservable.addObserver(notificationObserver2);
        iPhoneStockObservable.setStockCount(100);

        iPhoneStockObservable.setStockCount(0);

        iPhoneStockObservable.setStockCount(10);

    }
}
