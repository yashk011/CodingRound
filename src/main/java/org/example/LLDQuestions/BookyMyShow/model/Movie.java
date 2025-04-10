package org.example.LLDQuestions.BookyMyShow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Movie {
    String id;
    String movieName;
    int movieDurationInMinutes;

    public String getMovieDetails() {
        return "Movie - " +  movieName +  " Duration " + movieDurationInMinutes + " minutes";
    }
}
