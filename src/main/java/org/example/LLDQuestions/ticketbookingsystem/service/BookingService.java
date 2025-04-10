package org.example.LLDQuestions.ticketbookingsystem.service;

import org.example.ticketbookingsystem.model.Booking;
import org.example.ticketbookingsystem.model.Seat;
import org.example.ticketbookingsystem.model.Show;
import org.example.ticketbookingsystem.provider.SeatLockProvider;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {
    HashMap<Show, List<Seat>> bookings;
    HashMap<String, Booking> bookingList;


    HashMap<String, Booking> allBookings;
    SeatLockProvider seatLockProvider;

    public BookingService(SeatLockProvider seatLockProvider) {
        bookings = new HashMap<>();
        bookingList = new HashMap<>();
        allBookings = new HashMap<>();
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getBookedSeats(Show show) {
        return allBookings.values().stream()
                .filter(b -> b.getShow().getId().equals(show.getId()))
                .filter(Booking::isConfirmed)
                .map(Booking::getSeats)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    // Old implementation
    public String bookSeats(Show show, List<Seat> seats, String userId) {
        String bookingId = UUID.randomUUID().toString();
        bookings.getOrDefault(show, new ArrayList<>()).addAll(seats);
        Booking booking = new Booking(bookingId, true, userId, seats, show);
        bookingList.put(bookingId, booking);
        return bookingId;
    }

    public String createBooking(Show show, List<Seat> seatList, String userId) {

        seatLockProvider.lockSeats(show, seatList);
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, false, userId, seatList, show);
        allBookings.put(bookingId, booking);
        return bookingId;
    }

    public void confirmBooking(String bookingId) {
        Booking booking = allBookings.get(bookingId);
        // Validate Lock before marking seats as confirmed
        booking.setConfirmed(true);
    }

    public Booking getBooking(String bookingId) {
        return allBookings.get(bookingId);
    }
}

