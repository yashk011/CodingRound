package org.example.LLDQuestions.ticketbookingsystem.controller;

import org.example.ticketbookingsystem.model.Movie;
import org.example.ticketbookingsystem.model.Screen;
import org.example.ticketbookingsystem.model.Seat;
import org.example.ticketbookingsystem.model.Show;
import org.example.ticketbookingsystem.service.MovieService;
import org.example.ticketbookingsystem.service.SeatAvailabilityService;
import org.example.ticketbookingsystem.service.ShowService;
import org.example.ticketbookingsystem.service.TheatreService;

import java.util.Date;
import java.util.List;

public class ShowController {
    SeatAvailabilityService seatAvailabilityService;
    ShowService showService;
    TheatreService theatreService;
    MovieService movieService;

    public ShowController(ShowService showService, TheatreService theatreService ,
                          MovieService movieService,
                          SeatAvailabilityService seatAvailabilityService) {
        this.showService = showService;
        this.movieService = movieService;
        this.theatreService = theatreService;
        this.seatAvailabilityService = seatAvailabilityService;
    }

    public String createShow(String movieId, String screenId,String showName,  Date start, Date end) {
        Screen screen = theatreService.getScreens().get(screenId);
        Movie movie = movieService.getMovie(movieId);
        return showService.createShowInScreen(showName, screen, movie, start, end);
    }

    public List<Show> getShowsRunningOnScreen(String screenId) {
        Screen screen = theatreService.getScreens().get(screenId);
        List<Show> shows = showService.getShowsInScreen(screen);
        return shows;
    }

    public List<Seat> getSeatAvailability(String showId) {
        Show show = showService.getShow(showId);
        List<Seat> seatList = seatAvailabilityService.getAvailableSeats(show);
        return seatList;
    }

}
