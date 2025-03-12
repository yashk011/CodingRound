package org.example.designPattern.ObserverDesignPattern.example3;

import org.example.designPattern.ObserverDesignPattern.example1.Observer;
import org.example.designPattern.ObserverDesignPattern.example3.observer.NotificationObserver;

public interface StockObservable {
    public void addObserver(NotificationObserver observer);
    public void removeObserver(NotificationObserver observer);
    public void notifyObserver();
    public void setStockCount(int data);
    public int getStockCount();
}
