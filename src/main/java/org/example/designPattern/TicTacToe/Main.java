package org.example.designPattern.TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player(new BoardPieceX(), "Yash");
        Player player2 = new Player(new BoardPieceO(), "Yashika");
        Game game = new Game(player1, player2);

        System.out.println("Game winner - " +game.startGame());

//        Scanner scanner = new Scanner(System.in);
//        Player currentPlayer = player1;
//
//        while(true) {
//            System.out.println("Give x and y - ");
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//
//            boolean isCompleted = game.fillSpace(currentPlayer.getBoardPiece(), x,y);
//            if(isCompleted)
//                break;
//
//            if(currentPlayer == player1)
//                currentPlayer = player2;
//            else
//                currentPlayer = player1;
//        }


    }
}
