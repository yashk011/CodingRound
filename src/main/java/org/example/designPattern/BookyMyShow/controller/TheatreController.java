package org.example.designPattern.BookyMyShow.controller;

import org.example.designPattern.BookyMyShow.model.*;
import org.example.designPattern.BookyMyShow.service.TheatreService;

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
