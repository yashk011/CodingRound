package org.example.designPattern.BookyMyShow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Seat {
    int seatNumber;
    boolean isBooked;
}
