package org.example.LLDQuestions.VisitorDesignPattern;

import lombok.Getter;

@Getter
public class DoubleRoomElement implements Element{
    int price;
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
