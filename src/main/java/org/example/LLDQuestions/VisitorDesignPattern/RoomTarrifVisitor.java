package org.example.LLDQuestions.VisitorDesignPattern;

public class RoomTarrifVisitor implements Visitor{
    @Override
    public void visit(SingleRoomElement element) {
        System.out.println("Getting Tarrif for Single Room ");
        element.price = 100;
    }

    @Override
    public void visit(DoubleRoomElement element) {
        System.out.println("Getting Tarrif for Double Room ");
        element.price = 300;
    }
}
