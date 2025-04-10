package org.example.LLDQuestions.BookyMyShow.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@AllArgsConstructor
public class Booking {
    String bookingId;
    int bookedSeats;
    @Setter
    BookingStatus bookingStatus;
    Payment payment;
    Show show;
}
