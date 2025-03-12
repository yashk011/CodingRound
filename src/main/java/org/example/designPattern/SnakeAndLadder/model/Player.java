package org.example.designPattern.SnakeAndLadder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Player {
    @Getter
    String playerName;
    @Getter
    BoardPiece boardPiece;
}
