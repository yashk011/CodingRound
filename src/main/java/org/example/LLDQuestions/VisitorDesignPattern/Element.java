package org.example.LLDQuestions.VisitorDesignPattern;

public interface Element {
    public void accept(Visitor visitor);
    public int getPrice();
}
