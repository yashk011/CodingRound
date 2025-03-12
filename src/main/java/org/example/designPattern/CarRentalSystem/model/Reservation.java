package org.example.designPattern.CarRentalSystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.designPattern.CarRentalSystem.enums.ReservationState;

import java.time.Instant;

@Setter
@Getter
@Builder
public class Reservation {
    String id;
    Vehicle vehicle;
    ReservationState reservationState;
    Instant bookingDate;
    Instant bookedTill;
    Location dropLocation;
    Location pickUpLocation;
    User user;

}
