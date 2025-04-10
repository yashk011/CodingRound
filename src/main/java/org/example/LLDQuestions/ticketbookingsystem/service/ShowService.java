package org.example.LLDQuestions.ticketbookingsystem.service;

import lombok.SneakyThrows;
import org.example.ticketbookingsystem.model.Movie;
import org.example.ticketbookingsystem.model.Screen;
import org.example.ticketbookingsystem.model.Show;
import org.example.ticketbookingsystem.model.Theatre;

import java.util.*;
import java.util.stream.Collectors;

public class ShowService {
    TheatreService theatreService;
    Map<String, Show> shows;

    public ShowService() {
        shows = new HashMap<>();
    }

    public Show getShow(final String showId) {
        if (!shows.containsKey(showId)) {
            return null;
        }
        return shows.get(showId);
    }

    @SneakyThrows
    public String createShowInScreen(String showName ,Screen screen, Movie movie, Date startTime, Date endTime) {
        if(!isAllowedToCreateMovie()) {
            throw new Exception("Cannot create movie");
        }
        String id = UUID.randomUUID().toString();
        Show show = new Show(id, showName, screen, movie, startTime, endTime);
        shows.put(id, show);
        return id;
    }

    private boolean isAllowedToCreateMovie() {
        return true;
    }

    public List<Show> getShowsInScreen(Screen screen) {
        List<Show> showList = shows.values().stream()
                .filter(show -> show.getScreen().getId() == screen.getId())
                .collect(Collectors.toUnmodifiableList());
        return showList;
    }
}
