package org.example.designPattern.ParkingLot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class ParkingTicket {
    Instant issueTime;
    Instant endTime;
    String id;
    ParkingSpot parkingSpot;
    Vehicle vehicle;
    boolean isPaid;
    int totalAmount;

    @Override
    public String toString() {
        return "\n Ticket Issue Date - " + issueTime.toString() + "\n Ticket End Time - " + endTime.toString() +
                "\n Ticket id - " + id + "\n Ticket parking Spot - " + parkingSpot.getId() +
                "\n Vehicle - " + vehicle.getVehicleNumber() +
                "\n amount - " + this.getTotalAmount() +
                "\n Vehicle - " + this.isPaid();


    }
}
