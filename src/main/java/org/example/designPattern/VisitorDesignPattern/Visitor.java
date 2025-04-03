package org.example.designPattern.VisitorDesignPattern;

public interface Visitor {
    public void visit(SingleRoomElement element);
    public void visit(DoubleRoomElement element);

}
