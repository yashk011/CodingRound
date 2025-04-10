package org.example.LLDQuestions.SnakeAndLadder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Player {
    @Getter
    String playerName;
    @Getter
    BoardPiece boardPiece;
}
