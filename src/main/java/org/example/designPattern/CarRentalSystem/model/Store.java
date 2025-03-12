package org.example.designPattern.CarRentalSystem.model;

import org.example.designPattern.CarRentalSystem.enums.ReservationState;
import org.example.designPattern.CarRentalSystem.repository.CarRepository;
import org.example.designPattern.CarRentalSystem.repository.VehicleRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Store {
    int storeId;
    Location location;
    VehicleRepository vehicleRepository;
    List<Reservation> reservationList;

    public  Store() {
        vehicleRepository = new CarRepository();
        reservationList = new ArrayList<>();
    }

    // Send an ID and Store Map { id --> Reservation }
    // reserveVehicle(User user, Locations , Vehicle ,
    public Reservation reserveVehicle(User user, Vehicle vehicle, Location dropLocation) {
        System.out.println("Reserving Vehicle - " + vehicle.model);
        String id = UUID.randomUUID().toString();
        Reservation reservation = Reservation.builder()
                        .reservationState(ReservationState.PENDING)
                        .id(id).vehicle(vehicle).bookingDate(Instant.now())
                        .bookedTill(Instant.now().plusSeconds(3600))
                        .dropLocation(dropLocation)
                        .pickUpLocation(dropLocation)
                        .user(user)
                        .build();

        reservationList.add(reservation);
        return reservation;
    }

    public void confirmReservation(Reservation reservation) {
        reservation.setReservationState(ReservationState.CONFIRMED);
        // ALso set vehicle as Unavailable
    }

    public void addVehicle(Vehicle vehicle) {
        // Add Vehicle to Inventory
        vehicleRepository.addVehicle(vehicle);
    }

    public void updateReservation(Reservation reservation, ReservationState reservationState) {
        reservation.setReservationState(reservationState);
    }

    public Vehicle getVehicle(String carProperties) {
        return vehicleRepository.getVehicle(carProperties);
    }
}
