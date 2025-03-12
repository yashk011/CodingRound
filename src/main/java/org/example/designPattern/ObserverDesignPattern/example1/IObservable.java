package org.example.designPattern.ObserverDesignPattern.example1;

public interface IObservable {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
    public void setData(int data);
}
