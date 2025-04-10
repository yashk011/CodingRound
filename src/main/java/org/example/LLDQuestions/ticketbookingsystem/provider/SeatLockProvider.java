package org.example.LLDQuestions.ticketbookingsystem.provider;

import lombok.SneakyThrows;
import org.example.ticketbookingsystem.model.Seat;
import org.example.ticketbookingsystem.model.Show;

import java.util.List;

public interface SeatLockProvider {
    @SneakyThrows
    public void lockSeats(Show show , List<Seat> seatList);

    @SneakyThrows
    void unlockSeats(Show show, List<Seat> seats);

    @SneakyThrows
    List<Seat> getLockedSeats(Show show);
}
