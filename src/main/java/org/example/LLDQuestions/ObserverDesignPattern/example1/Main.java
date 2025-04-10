package org.example.LLDQuestions.ObserverDesignPattern.example1;

public class Main {
    public static void main(String[] args) {
        IObservable subject = new Observable();
        Observer observer1 = new Observer();
        Observer observer2 = new Observer();
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.setData(2000);

    }
}
