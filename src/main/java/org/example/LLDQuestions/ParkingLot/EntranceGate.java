package org.example.LLDQuestions.ParkingLot;

import org.example.LLDQuestions.ParkingLot.manager.ParkingSpotManager;
import org.example.LLDQuestions.ParkingLot.manager.ParkingSpotManagerFactory;
import org.example.LLDQuestions.ParkingLot.model.ParkingSpot;
import org.example.LLDQuestions.ParkingLot.model.ParkingTicket;
import org.example.LLDQuestions.ParkingLot.model.Vehicle;

import java.time.Instant;
import java.util.UUID;

public class EntranceGate {
    ParkingSpotManagerFactory parkingSpotManagerFactory;
    ParkingSpotManager parkingSpotManager;

    public EntranceGate() {
        parkingSpotManagerFactory = new ParkingSpotManagerFactory();
    }

    public ParkingTicket findParkingSpaceAndAllocateVehicle(Vehicle vehicle) {
        parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(vehicle.getVehicleType());
        ParkingSpot parkingSpot = findParkingSpot(vehicle);
        parkingSpotManager.parkVehicle(parkingSpot, vehicle);
        ParkingTicket parkingTicket = createParkingTicket(parkingSpot, vehicle);
        System.out.println("Parking Ticket Created ");
        // Save Parking Ticket to DB
        return parkingTicket;
    }

    private ParkingTicket createParkingTicket(ParkingSpot parkingSpot, Vehicle vehicle) {
        ParkingTicket parkingTicket = new ParkingTicket(Instant.now() , Instant.now().plusSeconds(3600), UUID.randomUUID().toString(), parkingSpot, vehicle, false, 0);
        return parkingTicket;
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        return parkingSpotManager.findParkingSpot(vehicle);
    }

}
