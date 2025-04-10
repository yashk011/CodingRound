package org.example.LLDQuestions.ticketbookingsystem.controller;

import org.example.ticketbookingsystem.service.MovieService;
import org.example.ticketbookingsystem.service.SeatAvailabilityService;
import org.example.ticketbookingsystem.service.ShowService;
import org.example.ticketbookingsystem.service.TheatreService;

public class MovieController {
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    public String addMovie(String movieName) {
        return movieService.addMovie(movieName);
    }
}
