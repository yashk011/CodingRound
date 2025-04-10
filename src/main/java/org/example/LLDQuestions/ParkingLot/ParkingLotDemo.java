package org.example.LLDQuestions.ParkingLot;

import org.example.LLDQuestions.ParkingLot.model.*;
import org.example.LLDQuestions.ParkingLot.strategy.FixedParkingCostStrategy;

public class ParkingLotDemo {

    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        Vehicle vehicle = new Vehicle(VehicleType.TWO_WHEELER, "KA-01-1969");
        Vehicle vehicle2 = new Vehicle(VehicleType.TWO_WHEELER, "KA-01-1970");
        Vehicle vehicle3 = new Vehicle(VehicleType.TWO_WHEELER, "KA-01-1971");
        Vehicle vehicle4 = new Vehicle(VehicleType.FOUR_WHEELER, "KA-01-1111");

        ParkingSpot parkingSpot = new TwoWheelerParkingSpot();
        ParkingSpot parkingSpot1 = new TwoWheelerParkingSpot();
        ParkingSpot parkingSpot2 = new FourWheelerParkingSpot();

        parkingLot.addParkingSpot(parkingSpot, VehicleType.TWO_WHEELER);
        parkingLot.addParkingSpot(parkingSpot1, VehicleType.TWO_WHEELER);
        parkingLot.addParkingSpot(parkingSpot2, VehicleType.FOUR_WHEELER);

        ParkingTicket parkingTicket = parkingLot.entranceGate.findParkingSpaceAndAllocateVehicle(vehicle);
        System.out.println("Parking Ticket allocated with Parking Spot");
        System.out.println("Ticket Details");
        System.out.println(parkingTicket.toString());

        System.out.println("============= \n");

        ParkingTicket parkingTicket2 = parkingLot.entranceGate.findParkingSpaceAndAllocateVehicle(vehicle2);
        System.out.println("Parking Ticket allocated with Parking Spot");
        System.out.println("Ticket Details");
        System.out.println(parkingTicket2.toString());

        System.out.println("============= \n");

        parkingLot.exitGate.setCostComputation(new FixedParkingCostStrategy());
        parkingLot.exitGate.scanAndPayAndDeallocate(parkingTicket);
        System.out.println("Ticket Details");
        System.out.println(parkingTicket.toString());


        System.out.println("============= \n");
        ParkingTicket parkingTicket3 = parkingLot.entranceGate.findParkingSpaceAndAllocateVehicle(vehicle3);
        System.out.println("Parking Ticket allocated with Parking Spot");
        System.out.println("Ticket Details");
        System.out.println(parkingTicket3.toString());

        System.out.println("=================");

        ParkingTicket parkingTicket4 = parkingLot.entranceGate.findParkingSpaceAndAllocateVehicle(vehicle4);
        System.out.println("Parking Ticket allocated with Parking Spot");
        System.out.println("Ticket Details");
        System.out.println(parkingTicket4.toString());

    }
}
