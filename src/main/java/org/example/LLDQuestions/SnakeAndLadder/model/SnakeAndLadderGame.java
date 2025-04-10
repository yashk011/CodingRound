package org.example.LLDQuestions.SnakeAndLadder.model;

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.initializeGame();
        System.out.println("Player Won - " + game.startGame());
    }
}
