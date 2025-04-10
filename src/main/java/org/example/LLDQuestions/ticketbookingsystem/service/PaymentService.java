package org.example.LLDQuestions.ticketbookingsystem.service;

import lombok.SneakyThrows;
import org.example.ticketbookingsystem.model.Booking;
import org.example.ticketbookingsystem.provider.SeatLockProvider;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private static int ALLOWED_FAILURE_COUNT = 0;
    Map<Booking, Integer> bookingFailure;
    SeatLockProvider seatLockProvider;

    public PaymentService(SeatLockProvider seatLockProvider) {
        bookingFailure = new HashMap<>();
        this.seatLockProvider = seatLockProvider;
    }

    @SneakyThrows
    public void processPaymentFailed(Booking booking, String user) {
        if(booking.getUserId() != user) {
            throw new Exception("Bad Request");
        }

        if(!bookingFailure.containsKey(booking))
            bookingFailure.put(booking, 0);

        int current_count = bookingFailure.get(booking);
        int new_count = current_count+1;
        bookingFailure.put(booking,new_count);

        if(new_count > ALLOWED_FAILURE_COUNT)
            seatLockProvider.unlockSeats(booking.getShow(), booking.getSeats());

    }
}
