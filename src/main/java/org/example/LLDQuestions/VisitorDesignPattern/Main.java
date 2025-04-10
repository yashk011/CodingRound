package org.example.LLDQuestions.VisitorDesignPattern;

public class Main {
    public static void main(String[] args) {
         Element singleRoom = new SingleRoomElement();
         Element doubleRoom = new DoubleRoomElement();

         singleRoom.accept(new RoomMaintenanceVisitor());
         doubleRoom.accept(new RoomTarrifVisitor());

        System.out.println("Price = " + doubleRoom.getPrice());
    }
}
