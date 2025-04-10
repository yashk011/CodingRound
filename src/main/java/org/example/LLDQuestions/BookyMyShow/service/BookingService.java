package org.example.LLDQuestions.BookyMyShow.service;

import org.example.LLDQuestions.BookyMyShow.model.*;

import java.util.HashMap;
import java.util.UUID;

public class BookingService {
    HashMap<String, Booking>  bookings;

    public BookingService() {
        bookings = new HashMap<>();
    }

    public String createBooking(Show show, int seats) {
        String id = UUID.randomUUID().toString();

        Payment payment = new Payment(UUID.randomUUID().toString(), false);
        Booking booking = new Booking(id, seats, BookingStatus.PENDING, payment, show);
        bookings.put(id,booking);
        // Show Service - Book Tickets and mark ticket
        show.getBookedSeats().add(seats);
        return booking.getBookingId();
    }

    public Booking getBooking(String id) {
        return bookings.get(id);
    }
}
