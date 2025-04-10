package org.example.LLDQuestions.ticketbookingsystem.model;

import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
public class SeatLock {
    String user;
    Seat seat;
    int lockTimeout;
    Date lockTime;
    Show show;

    public boolean isLocked() {
        final Instant lockInstant = lockTime.toInstant().plusSeconds(lockTimeout);
        final Instant currentInstant = new Date().toInstant();
        return lockInstant.isBefore(currentInstant);

    }
}
