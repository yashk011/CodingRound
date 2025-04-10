package org.example.LLDQuestions.ticketbookingsystem.controller;

import org.example.ticketbookingsystem.model.Seat;
import org.example.ticketbookingsystem.model.Show;
import org.example.ticketbookingsystem.service.BookingService;
import org.example.ticketbookingsystem.service.ShowService;
import org.example.ticketbookingsystem.service.TheatreService;

import java.util.ArrayList;
import java.util.List;

public class BookingController {

    BookingService bookingService;
    TheatreService theatreService;
    ShowService showService;

    public BookingController(BookingService bookingService, TheatreService theatreService, ShowService showService) {
        this.bookingService = bookingService;
        this.theatreService = theatreService;
        this.showService = showService;
    }

    public String bookTicket(List<String> seats, String showId, String userId) {

        Show show = showService.getShow(showId);
        List<Seat> seatList = new ArrayList<>();
        for(String seatId : seats) {
            seatList.add(theatreService.getSeats().get(seatId));
        }

        return bookingService.bookSeats(show, seatList, userId);
    }

    public String createBooking(List<String> seats, String showId, String userId) {

        Show show = showService.getShow(showId);
        List<Seat> seatList = new ArrayList<>();
        for(String seatId : seats) {
            seatList.add(theatreService.getSeats().get(seatId));
        }

        return bookingService.createBooking(show, seatList, userId);
    }

    public void confirmBooking(String bookingId) {
        bookingService.confirmBooking(bookingId);
    }
}
