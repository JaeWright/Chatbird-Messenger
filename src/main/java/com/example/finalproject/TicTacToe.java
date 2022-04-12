package com.example.finalproject;

import java.util.Arrays;

public class TicTacToe {
    private char[][] board = new char[3][3];
    private char currentPlayer;
    private char otherPlayer;

    public TicTacToe(char player) {
        if ('X' == player){
            currentPlayer = 'X';
            otherPlayer = 'O';
        }else {
            currentPlayer = 'O';
            otherPlayer = 'X';
        }

        System.out.println("Tic Tac Toe");
        initialize();
        printBoard();
        System.out.println("Board Initialized");
    }
    public void initialize(){
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '-');
        }
    }

    private void printBoard() {
        System.out.println("Board\n");
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(String.valueOf(board[row][col]) + "\t");
            }
            System.out.println("\n");
        }
    }

    public boolean hasWon(char player){
        for (int i = 0;i < 3;i++){
            //row
            if (player == board[i][0] &&
                player == board[i][1] &&
                player == board[i][2]){
                return true;
            }
            //col
            else if (player == board[0][i] &&
                player == board[1][i] &&
                player == board[2][i]){
                return true;
            }
        }
        //Diagonal
        if (player == board[0][0] &&
            player == board[1][1] &&
            player == board[2][2]){
            return true;
        }
        else if (player == board[2][0] &&
            player == board[1][1] &&
            player == board[0][2]){
            return true;
        }
        return false;
    }

    public boolean isTie(){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if ('-' == board[row][col]){
                    return false;
                }
            }
        }
        return true;
    }

    public void placeTile(int row,int col){
        board[row][col] = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = board[row][col];
        printBoard();
        System.out.println(hasWon(otherPlayer));
    }

    public char getCurrentPlayer(){
        return currentPlayer;
    }
    public char getOtherPlayer(){
        return otherPlayer;
    }
}
