package org.example.designPattern.ObserverDesignPattern.example1;

import jakarta.annotation.Nonnull;

import java.util.ArrayList;
import java.util.List;

public class Observable implements IObservable{

    List<Observer> observerList;
    int data;

    public Observable() {
        this.observerList = new ArrayList<>();
    }
    @Override
    public void addObserver(@Nonnull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@Nonnull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer: observerList) {
            observer.update(this.data);
        }
    }

    @Override
    public void setData(int data) {
        this.data = data;
        this.notifyObserver();
    }
}
