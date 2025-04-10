package org.example.LLDQuestions.ticketbookingsystem.service;

import org.example.ticketbookingsystem.model.Movie;

import java.util.HashMap;
import java.util.UUID;

public class MovieService {

    HashMap<String , Movie> movies;

    public MovieService() {
        movies = new HashMap<>();
    }
    public String addMovie(String movieName) {
        String id = UUID.randomUUID().toString();
        Movie movie = new Movie(id, movieName);
        movies.put(id, movie);
        return id;
    }

    public Movie getMovie(String id) {
        return movies.get(id);
    }
}
