package org.example.LLDQuestions.ticketbookingsystem.service;

import lombok.Getter;
import org.example.ticketbookingsystem.model.Screen;
import org.example.ticketbookingsystem.model.Seat;
import org.example.ticketbookingsystem.model.SeatType;
import org.example.ticketbookingsystem.model.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Getter
public class TheatreService {
    HashMap<String, Theatre> theatres;
    HashMap<String , Screen> screens;
    HashMap<String, Seat> seats;

    public TheatreService() {
        theatres = new HashMap<>();
        screens = new HashMap<>();
        seats = new HashMap<>();
    }

    public String addTheatre(String theatreName) {
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId, theatreName, new ArrayList<>());
        theatres.put(theatreId, theatre);
        return theatreId;
    }

    public String addScreenToTheatre(String screenName , String theatreId) {
        Theatre theatre = theatres.get(theatreId);
        String screenId = UUID.randomUUID().toString();
        Screen screen = new Screen(screenId,screenName, null , new ArrayList<>());
        screens.put(screenId, screen);
        return screenId;
    }

    public String addSeatToScreen(int row , int seatNo , String screenId) {
        Screen screen = screens.get(screenId);
        String seatId = UUID.randomUUID().toString();
        Seat seat = new Seat(seatId, row, seatNo , SeatType.SILVER);
        seats.put(seatId, seat);
        screen.getSeats().add(seat);
        return seatId;
    }

}

