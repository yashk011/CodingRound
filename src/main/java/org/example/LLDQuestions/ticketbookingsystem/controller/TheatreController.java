package org.example.LLDQuestions.ticketbookingsystem.controller;

import org.example.ticketbookingsystem.service.TheatreService;

public class TheatreController {
    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }
    public String addTheatre(String theatreName) {
        return theatreService.addTheatre(theatreName);
    }

    public String addScreenToTheatre(String theaterId, String screenName) {
        return theatreService.addScreenToTheatre(screenName, theaterId);
    }

    public String addSeatToScreen(String screenId, Integer rowNo, Integer seatNo) {
        return theatreService.addSeatToScreen(rowNo,seatNo, screenId);
    }
}
