package org.example.LLDQuestions.SnakeAndLadder.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    @Getter
    Cell[] cells;
    List<Snake> snakeList;
    List<Ladder> ladderList;
    Dice dice;

    Map<Integer, Snake> snakeMap;
    Map<Integer, Ladder> ladderMap;

    public Board() {
        cells = new Cell[101];
        for(int i =1;i<=100;i++) {
            cells[i] = new Cell(i);
        }
        snakeList = new ArrayList<>();
        ladderList = new ArrayList<>();
        dice = new Dice();

        snakeMap = new HashMap<>();
        ladderMap = new HashMap<>();
    }

    public void addSnake(Snake snake) {
        snakeMap.put(snake.getHead().getPosition(), snake);
    }

    public void addLadder(Ladder ladder) {
        ladderList.add(ladder);
        ladderMap.put(ladder.getBottom().getPosition(), ladder);
    }


    public boolean isGameOver(Player player) {
        if(player.getBoardPiece().getCurrentPosition() == 100)
            return true;
        return false;
    }

    public int rollDice() {
        return dice.rollDice();
    }

    public boolean isLadderPosition(int position) {
        if(ladderMap.containsKey(position))
            return true;
        return false;
    }

    public boolean isSnakePosition(int position) {
        if(snakeMap.containsKey(position))
            return true;
        return false;
    }

    public void printBoard() {
        for(int i = 1;i>=1;i--) {
            for(int j =1;j<=10;j++) {
                int a = i*j;
                System.out.print(a);
                if(this.snakeMap.containsKey(a))
                    System.out.print("S");
                if(this.ladderMap.containsKey(a))
                    System.out.print("L");

                System.out.print(" ");
            }

            System.out.println(" ");
        }
    }

    public void movePlayer(Player player, int position) {
        int currentPosition = player.getBoardPiece().getCurrentPosition();
        player.getBoardPiece().setCurrentPosition(currentPosition + position);

        if(isSnakePosition(player.getBoardPiece().currentPosition)) {
            Snake snake = snakeMap.get(player.getBoardPiece().currentPosition);
            player.getBoardPiece().setCurrentPosition(snake.getTail().getPosition());
        }

        if(isLadderPosition(player.getBoardPiece().getCurrentPosition())) {
            Ladder ladder = ladderMap.get(player.getBoardPiece().currentPosition);
            player.getBoardPiece().setCurrentPosition(ladder.getTop().getPosition());
        }

    }
}
