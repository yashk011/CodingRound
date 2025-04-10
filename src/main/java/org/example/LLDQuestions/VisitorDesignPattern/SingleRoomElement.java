package org.example.LLDQuestions.VisitorDesignPattern;

import lombok.Getter;

@Getter
public class SingleRoomElement implements Element{
    int price = 0;
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
