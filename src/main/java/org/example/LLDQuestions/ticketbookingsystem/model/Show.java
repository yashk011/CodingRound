package org.example.LLDQuestions.ticketbookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;


@Getter
@AllArgsConstructor
public class Show {
    String id;
    String name;
    Screen screen;
    Movie movie;
    Date startTime;
    Date endTime;
}
