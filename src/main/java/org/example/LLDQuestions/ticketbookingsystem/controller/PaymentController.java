package org.example.LLDQuestions.ticketbookingsystem.controller;

import org.example.ticketbookingsystem.service.BookingService;
import org.example.ticketbookingsystem.service.PaymentService;

public class PaymentController {
    PaymentService paymentService;
    BookingService bookingService;


    public PaymentController(PaymentService paymentsService, BookingService bookingService) {
        this.paymentService = paymentsService;
        this.bookingService = bookingService;
    }

    public void paymentFailed(final String bookingId, final String user) {
        paymentService.processPaymentFailed(bookingService.getBooking(bookingId), user);
    }

    public void paymentSuccess(final  String bookingId) {
        bookingService.confirmBooking(bookingService.getBooking(bookingId).getBookingId());
    }

}
