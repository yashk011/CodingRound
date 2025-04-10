package org.example.LLDQuestions.ticketbookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@Setter
public class Theatre {
    String id;
    String name;
    List<Screen> screens;
}
