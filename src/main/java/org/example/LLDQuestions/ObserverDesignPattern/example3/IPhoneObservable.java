package org.example.LLDQuestions.ObserverDesignPattern.example3;

import org.example.LLDQuestions.ObserverDesignPattern.example3.observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneObservable implements StockObservable{

    List<NotificationObserver> notificationObserverList;
    int stockCount;

    public IPhoneObservable() {
        notificationObserverList = new ArrayList<>();
        this.stockCount = 0;
    }

    @Override
    public void addObserver(NotificationObserver observer) {
        notificationObserverList.add(observer);
    }

    @Override
    public void removeObserver(NotificationObserver observer) {
        notificationObserverList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(NotificationObserver notificationObserver : this.notificationObserverList) {
            notificationObserver.update();
        }
    }

    @Override
    public void setStockCount(int data) {
        if(stockCount == 0) {
            this.stockCount = data;
            notifyObserver();
            return;
        }
        this.stockCount = data;
    }

    public int getStockCount() {
        return this.stockCount;
    }
}
