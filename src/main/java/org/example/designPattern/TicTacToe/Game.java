package org.example.designPattern.TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Board board;
    Deque<Player> players;

    public void initializeGame(Player player1 , Player player2) {
        players.add(player1);
        players.add(player2);
    }

    public Game(Player player1, Player player2) {
        board = new Board(3);
        players = new LinkedList<>();
        initializeGame(player1, player2);
    }

    public String startGame() {
        boolean winnerFound = false;
        Scanner scanner = new Scanner(System.in);

        while(!winnerFound) {
            Player currentPlayer = players.getFirst();
            System.out.println("Player turn - " + currentPlayer.name);
            board.printBoard();
            System.out.println("Please give the value of x and y");

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            boolean isAdded = board.addPiece(currentPlayer.getBoardPiece() , x, y);
            if(!isAdded) {
                System.out.println("Item is not added ... You have not placed the pieces correctly");
                continue;
            }

            boolean isGameOver = board.isGameOver( x, y, currentPlayer.getBoardPiece());

            if(isGameOver)
                return currentPlayer.getName();

            if(board.isAllCellsFilled()) {
                break;
            }
            players.addLast(players.removeFirst());
        }

        return "It's a draw";
    }


    public boolean fillSpace(BoardPiece boardPiece, int x, int y) {
        boolean isAdded = board.addPiece(boardPiece, x,y);

        if(board.isGameOver(x,y,boardPiece)) {
            System.out.println(boardPiece.pieceType.toString() + "won!!");
        }
        return false;
    }
}
