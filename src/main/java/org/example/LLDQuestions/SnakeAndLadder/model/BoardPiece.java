package org.example.LLDQuestions.SnakeAndLadder.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class BoardPiece {
    PieceType pieceType;
    @Setter
    @Getter
    int currentPosition;
}
