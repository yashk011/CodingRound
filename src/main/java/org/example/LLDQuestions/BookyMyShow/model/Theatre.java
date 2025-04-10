package org.example.LLDQuestions.BookyMyShow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Theatre {
    String theatreId;
    @Setter
    List<Screen> screens;
    @Setter
    List<Show> shows;
}

