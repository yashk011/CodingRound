package org.example.designPattern.VisitorDesignPattern;

public interface Element {
    public void accept(Visitor visitor);
    public int getPrice();
}
