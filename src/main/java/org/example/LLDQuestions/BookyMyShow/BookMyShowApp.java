package org.example.LLDQuestions.BookyMyShow;

import org.example.LLDQuestions.BookyMyShow.controller.BookingsController;
import org.example.LLDQuestions.BookyMyShow.controller.MovieController;
import org.example.LLDQuestions.BookyMyShow.controller.TheatreController;
import org.example.LLDQuestions.BookyMyShow.model.*;

import java.util.List;

public class BookMyShowApp {
    TheatreController theatreController;
    MovieController movieController;
    BookingsController bookingsController;

    public BookMyShowApp(TheatreController theatreController, MovieController movieController, BookingsController bookingsController) {
        this.movieController = movieController;
        this.theatreController = theatreController;
        this.bookingsController = bookingsController;
    }

    public void addMovies(String location, Movie movie) {
        this.movieController.addMovies(location, movie);
    }

    public void addTheatre(String location, Theatre theatre) {
        this.theatreController.addTheatre(location, theatre);
    }

    public List<Movie> getMoviesForLocation(String location) {
        return this.movieController.getMovieBasedOnLocation(location);
    }

    public List<Show> getAllShowsForAMovie(String location, Movie movie) {
        return this.theatreController.getAllShows(location, movie);
    }

    public List<Integer> getFreeSeats(Show show) {
        return theatreController.getFreeSeatsForShow(show);
    }

    public String bookTickets(Show show , int seatNumber) {
        return bookingsController.bookTickets(show , seatNumber);
    }

    public boolean confirmBooking(String bookingId) {
        return bookingsController.confirmBooking(bookingId);
    }
}
