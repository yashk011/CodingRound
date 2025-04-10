package org.example.LLDQuestions.VisitorDesignPattern;

public interface Visitor {
    public void visit(SingleRoomElement element);
    public void visit(DoubleRoomElement element);

}
