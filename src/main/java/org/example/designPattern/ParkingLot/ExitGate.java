package org.example.designPattern.ParkingLot;

import lombok.Setter;
import org.example.designPattern.ParkingLot.manager.ParkingSpotManager;
import org.example.designPattern.ParkingLot.manager.ParkingSpotManagerFactory;
import org.example.designPattern.ParkingLot.model.ParkingTicket;
import org.example.designPattern.ParkingLot.model.Vehicle;
import org.example.designPattern.ParkingLot.strategy.CostComputationStrategy;

public class ExitGate {
    ParkingSpotManagerFactory parkingSpotManagerFactory;
    ParkingSpotManager parkingSpotManager;

    @Setter
    CostComputationStrategy costComputation;

    public ExitGate() {
        parkingSpotManagerFactory = new ParkingSpotManagerFactory();
    }

    public void scanAndPayAndDeallocate(ParkingTicket parkingTicket) {
        parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(parkingTicket.getVehicle().getVehicleType());
        int totalAmount = costComputation.findCost(parkingTicket);
        parkingTicket.setTotalAmount(totalAmount);
        parkingTicket.setPaid(true);
        // Pay amount total amount
        parkingSpotManager.unParkVehicle(parkingTicket.getParkingSpot());
    }
}
