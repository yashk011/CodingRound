package org.example.LLDQuestions.BookyMyShow.service;

import org.example.LLDQuestions.BookyMyShow.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheatreService {
    Map<String, List<Theatre>> theatres;
    List<Theatre> allTheatres;

    public TheatreService() {
        theatres = new HashMap<>();
        allTheatres = new ArrayList<>();
    }
    public void addTheatre(String location, Theatre theatre) {
        if(!theatres.containsKey(location))
            theatres.put(location, new ArrayList<>());

        theatres.get(location).add(theatre);
        allTheatres.add(theatre);
    }

    public List<Show> getAllShowsForAMovie(String location, Movie movie) {
        List<Show> runningShows = new ArrayList<>();
        for(Theatre theatre: theatres.get(location)) {
            System.out.println("Theatre " + theatre.getTheatreId());
            List<Show> shows = theatre.getShows().stream().filter(show -> show.getMovie().getMovieName().equalsIgnoreCase(movie.getMovieName())).collect(Collectors.toList());
            shows.stream().forEach(show -> runningShows.add(show));
        }
        return runningShows;
    }

    public List<Integer> getFreeSeatsForShow(Show show) {
        List<Integer> bookedSeat = show.getBookedSeats();
        List<Seat> allSeats = show.getAssociatedScreen().getSeats();

        return bookedSeat;
    }
}
