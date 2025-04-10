package org.example.LLDQuestions.ticketbookingsystem.service;

import org.example.ticketbookingsystem.model.Seat;
import org.example.ticketbookingsystem.model.Show;
import org.example.ticketbookingsystem.provider.SeatLockProvider;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityService {
    TheatreService theatreService;
    BookingService bookingService;
    SeatLockProvider seatLockProvider;

    public SeatAvailabilityService(TheatreService theatreService ,
                                   BookingService bookingService,
                                    SeatLockProvider seatLockProvider) {
        this.bookingService = bookingService;
        this.theatreService = theatreService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(Show show) {
        List<Seat> allSeats = show.getScreen().getSeats();
//        List<Seat> bookedSeats = getUnAvailableSeats(show);
        List<Seat> lockedSeats = getUnAvailableSeats(show);

        List<Seat> newAllSeats = new ArrayList<>(allSeats);
        newAllSeats.removeAll(lockedSeats);
        return newAllSeats;
    }

    public List<Seat> getUnAvailableSeats(Show show) {
        List<Seat> bookedSeats = bookingService.getBookedSeats(show);
        List<Seat> lockedSeats = seatLockProvider.getLockedSeats(show);
        lockedSeats.addAll(bookedSeats);
        return lockedSeats;
    }
}
