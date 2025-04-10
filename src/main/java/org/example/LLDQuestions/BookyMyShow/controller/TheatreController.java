package org.example.LLDQuestions.BookyMyShow.controller;

import org.example.LLDQuestions.BookyMyShow.model.*;
import org.example.LLDQuestions.BookyMyShow.service.TheatreService;

import java.util.List;

public class TheatreController {
    TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public void addTheatre(String location,Theatre theatre) {
        theatreService.addTheatre(location, theatre);
    }

    public List<Show> getAllShows(String location , Movie movie) {
        return theatreService.getAllShowsForAMovie(location, movie);
    }

    public List<Integer> getFreeSeatsForShow(Show show) {
        return theatreService.getFreeSeatsForShow(show);
    }
}
