package org.example.LLDQuestions.CarRentalSystem;

import org.example.LLDQuestions.CarRentalSystem.enums.VehicleState;
import org.example.LLDQuestions.CarRentalSystem.model.*;

public class VehicleRentalSystemDemo {

    public static void main(String[] args) {

        System.out.println("Setting Up System");
        VehicleRentalSystem vehicleRentalSystem = VehicleRentalSystem.getVehicleRentalSystem();

        Store store = new Store();
        Vehicle vehicle = new Car("KA-01-1967", "blue" , 4, VehicleState.AVAILABLE, "Maruti Swift");
        Vehicle vehicle2 = new Car("KA-01-9000", "red" , 4, VehicleState.AVAILABLE, "Maruti SX4");

        store.addVehicle(vehicle);
        store.addVehicle(vehicle2);

        User user1 = new User("Yash");
        User user2 = new User("Yashika");

        vehicleRentalSystem.addStore(store);
        vehicleRentalSystem.addUser(user1);
        vehicleRentalSystem.addUser(user2);

        // ===============================

//        #1. User Login based on Location
        User user = vehicleRentalSystem.users.get(0);
        Location location = new Location("HSR" , "Bangalore" , 560034);

//        #2. Get Stores based on Location
        System.out.println("Get Store Based on Location");
        Store store1 = vehicleRentalSystem.getStore(location);

//        #3. Get Vehicles from store selected
        Vehicle vehicle1 = store1.getVehicle("Swift"); // Can be List of Vehicles


//        #4. Select Vehicle and make reservation
        Reservation reservation = store1.reserveVehicle(user, vehicle1, location);
        System.out.println("Reservation ID - " + reservation.getId() + " Status " + reservation.getReservationState());

//        #5. Compute Bill
        Bill bill = new Bill(false, reservation);
        int amount = bill.computeBillAmount();

//        #6. User to make payment
        Payment payment = new Payment(bill);
        payment.payBill();

//        #2. Confirm Reservation
        store1.confirmReservation(reservation);
        System.out.println("Reservation ID - " + reservation.getId() + " Status " + reservation.getReservationState());


    }
}
