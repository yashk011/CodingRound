package org.example.LLDQuestions.BookyMyShow.controller;

import org.example.LLDQuestions.BookyMyShow.model.Movie;
import org.example.LLDQuestions.BookyMyShow.service.MovieService;

import java.util.List;

public class MovieController {

    MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> getMovieBasedOnLocation(String location) {
        return movieService.getMoviesForLocation(location);
    }

    public void addMovies(String location , Movie movie) {
        movieService.addMovie(location, movie);
    }
}
