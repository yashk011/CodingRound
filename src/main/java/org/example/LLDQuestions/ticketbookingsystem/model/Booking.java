package org.example.LLDQuestions.ticketbookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Booking {
    String bookingId;
    boolean isConfirmed;
    String userId;
    List<Seat> seats;
    Show show;
}
