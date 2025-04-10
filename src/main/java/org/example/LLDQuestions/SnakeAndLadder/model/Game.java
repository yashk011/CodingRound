package org.example.LLDQuestions.SnakeAndLadder.model;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board board;

    public Game() {
        players = new LinkedList<>();
        board = new Board();
    }

    public void initializeGame() {
        Snake snake = new Snake(board.getCells()[30], board.getCells()[5]);
        Snake snake1 = new Snake(board.getCells()[99], board.getCells()[1]);
        Snake snake2 = new Snake(board.getCells()[30], board.getCells()[5]);

        board.addSnake(snake);
        board.addSnake(snake1);
        board.addSnake(snake2);

        Ladder ladder = new Ladder(board.getCells()[8],board.getCells()[49]);
        Ladder ladder1 = new Ladder(board.getCells()[2],board.getCells()[100]);
        Ladder ladder2 = new Ladder(board.getCells()[4],board.getCells()[89]);

        board.addLadder(ladder);
        board.addLadder(ladder1);
        board.addLadder(ladder2);

        Player player = new Player("Yash" , new BoardPiece(PieceType.BLUE, 0));
        Player player2 = new Player("Rudra" , new BoardPiece(PieceType.GREEN, 0));

        this.players.add(player);
        this.players.add(player2);
    }

    public String startGame() {

        Player player;
        Scanner scanner = new Scanner(System.in);
        while(true) {


            player = players.removeFirst();
//            int position = board.rollDice();
//            System.out.println("Player " + player.getPlayerName() + " position " + player.getBoardPiece().getCurrentPosition());
            System.out.println("Give ur Dice Number - " + player.getPlayerName());
            int position = (int) scanner.nextInt();
            board.movePlayer(player, position);
            if(board.isGameOver(player)) {
                System.out.println("Player " + player.getPlayerName() + " position " + player.getBoardPiece().getCurrentPosition());
                break;
            }
            players.addLast(player);
        }
        return player.getPlayerName();
    }


}
