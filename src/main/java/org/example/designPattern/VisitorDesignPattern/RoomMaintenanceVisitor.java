package org.example.designPattern.VisitorDesignPattern;

public class RoomMaintenanceVisitor implements Visitor{
    @Override
    public void visit(SingleRoomElement element) {
        System.out.println("Maintenance started for single room");
        System.out.println("Please allow us 30 minutes");
    }

    @Override
    public void visit(DoubleRoomElement element) {
        System.out.println("Maintenance started for double room");
        System.out.println("Please allow us 60 minutes");
    }
}
