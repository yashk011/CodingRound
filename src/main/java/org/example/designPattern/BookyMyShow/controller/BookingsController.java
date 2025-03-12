package org.example.designPattern.BookyMyShow.controller;

import lombok.SneakyThrows;
import org.example.designPattern.BookyMyShow.model.*;
import org.example.designPattern.BookyMyShow.service.BookingService;
import org.example.designPattern.BookyMyShow.service.PaymentService;

public class BookingsController {
    BookingService bookingService;
    PaymentService paymentService;

    public BookingsController(BookingService bookingService) {
        this.bookingService = bookingService;
        this.paymentService = new PaymentService();
    }

    @SneakyThrows
    public String bookTickets(Show show, int seats) {

        if(show.getBookedSeats().contains(seats))
            throw new Exception("Seat is already booked !!");

        String bookingId =  bookingService.createBooking(show, seats);
        boolean isPaid = paymentService.pay(1000);
        return bookingId;
    }

    public boolean confirmBooking(String id) {
        Booking booking = bookingService.getBooking(id);
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        return true;
    }

    public Booking getBooking(String id) {
        return bookingService.getBooking(id);
    }
}
