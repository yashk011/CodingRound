package org.example.LLDQuestions.ticketbookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Seat {
    String id;
    int row;
    int seatNo;
    SeatType seatType;
}
