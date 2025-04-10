package org.example.LLDQuestions.ticketbookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Screen {
    String id;
    String name;
    Show runningShow;
    List<Seat> seats;
}
