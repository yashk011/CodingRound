package org.example.LLDQuestions.BookyMyShow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class Show {
    Date startTime;
    Screen associatedScreen;
    List<Booking> bookings;
    List<Integer> bookedSeats;
    Movie movie;
}
