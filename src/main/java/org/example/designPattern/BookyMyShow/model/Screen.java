package org.example.designPattern.BookyMyShow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Screen {
    String screenId;
    List<Seat> seats;
}
