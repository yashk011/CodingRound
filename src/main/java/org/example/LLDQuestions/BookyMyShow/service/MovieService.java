package org.example.LLDQuestions.BookyMyShow.service;

import org.example.LLDQuestions.BookyMyShow.model.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Controller Class to handle Movies based on Location
 */
public class MovieService {
    HashMap<String, List<Movie>> movies;
    List<Movie> allMovies;

    public MovieService() {
        movies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public List<Movie> getMoviesForLocation(String location) {
        List<Movie> movie = movies.get(location);
        return movie;
    }

    public void addMovie(String location, Movie movie) {
        if(!movies.containsKey(location))
            movies.put(location, new ArrayList<>());

        movies.get(location).add(movie);
        allMovies.add(movie);
    }
}
