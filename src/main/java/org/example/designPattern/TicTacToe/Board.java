package org.example.designPattern.TicTacToe;

import lombok.SneakyThrows;

public class Board {
    int size;
    BoardPiece[][] board;
    public Board(int size) {
        this.size = size;
        board = new BoardPiece[size][size];
    }

    @SneakyThrows
    public boolean addPiece(BoardPiece boardPiece, int x , int y) {
        if(board[x][y] != null)
            return false;
        if(x<0 || y<0 || x >= size || y> size)
            return false;

        board[x][y] = boardPiece;
        return true;
    }

    public boolean checkVertical(int x , int y, PieceType pieceType) {
        int count = 0;
        for(int i=0;i<size;i++) {
            if(board[i][y] == null)
                continue;

            if(board[i][y].pieceType == pieceType) {
                count++;
            }
            else {
                return false;
            }
        }
        return count == size ? true : false;
    }

    public boolean checkHorizontal(int x , int y, PieceType pieceType) {
        int count = 0;
        for(int i=0;i<size;i++) {
            if(board[x][i] == null)
                continue;

            if(board[x][i].pieceType == pieceType) {
                count++;
            }
            else {
                return false;
            }
        }
        return count == size ? true : false;
    }

    public boolean checkDiagonal(PieceType pieceType) {
        int count = 0;

        for(int i =0;i<size;i++) {
            if(board[i][i] == null)
                continue;
            if (board[i][i].pieceType == pieceType) {
                count++;
            }
        }

        return count == size ? true : false;
    }

    public boolean isGameOver(int x, int y, BoardPiece boardPiece) {
        if(checkDiagonal(boardPiece.pieceType) || checkVertical(x,y,boardPiece.pieceType)
            || checkHorizontal(x,y,boardPiece.pieceType)) {
            return true;
        }
        return false;
    }

    public boolean isAllCellsFilled() {
        int count = 0;
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(board[i][j] != null)
                    count++;
                else
                    return false;
            }
        }

        return count == size*size ? true : false;
    }

    public void printBoard() {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(board[i][j] == null)
                    System.out.print(" - ");
                else
                    System.out.print(" " + board[i][j].pieceType.toString() + " ");
            }
            System.out.println();
        }
    }
}
