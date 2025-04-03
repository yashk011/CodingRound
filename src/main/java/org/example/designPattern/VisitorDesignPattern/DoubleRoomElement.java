package org.example.designPattern.VisitorDesignPattern;

import lombok.Getter;

@Getter
public class DoubleRoomElement implements Element{
    int price;
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
