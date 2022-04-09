package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Button tile00;
    public Button tile01;
    public Button tile02;

    public Button tile10;
    public Button tile11;
    public Button tile12;

    public Button tile20;
    public Button tile21;
    public Button tile22;
    public Label currentPlayer;

    public TicTacToe ticTacToeGame = new TicTacToe();
    @FXML
    protected void buttonClick00() {
        String player = String.valueOf(ticTacToeGame.getCurrentPlayer());
        tile00.setText(player);
        tile00.setDisable(true);
        tile00.setStyle("-fx-opacity: 1");
        ticTacToeGame.placeTile(0,0);
        currentPlayer.setText("Current Player is: "+ticTacToeGame.getCurrentPlayer());
        if(ticTacToeGame.hasWon(ticTacToeGame.getOtherPlayer())){
            currentPlayer.setText("WINNER: "+ticTacToeGame.getOtherPlayer());
            lockBoard();
        }
        else if(ticTacToeGame.isTie()){
            currentPlayer.setText("TIE GAME");
            lockBoard();
        }
    }
    @FXML
    protected void buttonClick01() {
        String player = String.valueOf(ticTacToeGame.getCurrentPlayer());
        tile01.setText(player);
        tile01.setDisable(true);
        tile01.setStyle("-fx-opacity: 1");
        ticTacToeGame.placeTile(0,1);
        currentPlayer.setText("Current Player is: "+ticTacToeGame.getCurrentPlayer());
        if(ticTacToeGame.hasWon(ticTacToeGame.getOtherPlayer())){
            currentPlayer.setText("WINNER: "+ticTacToeGame.getOtherPlayer());
            lockBoard();
        }
        else if(ticTacToeGame.isTie()){
            currentPlayer.setText("TIE GAME");
            lockBoard();
        }
    }
    @FXML
    protected void buttonClick02() {
        String player = String.valueOf(ticTacToeGame.getCurrentPlayer());
        tile02.setText(player);
        tile02.setDisable(true);
        tile02.setStyle("-fx-opacity: 1");
        ticTacToeGame.placeTile(0,2);
        currentPlayer.setText("Current Player is: "+ticTacToeGame.getCurrentPlayer());
        if(ticTacToeGame.hasWon(ticTacToeGame.getOtherPlayer())){
            currentPlayer.setText("WINNER: "+ticTacToeGame.getOtherPlayer());
            lockBoard();
        }
        else if(ticTacToeGame.isTie()){
            currentPlayer.setText("TIE GAME");
            lockBoard();
        }
    }
    @FXML
    protected void buttonClick10() {
        String player = String.valueOf(ticTacToeGame.getCurrentPlayer());
        tile10.setText(player);
        tile10.setDisable(true);
        tile10.setStyle("-fx-opacity: 1");
        ticTacToeGame.placeTile(1,0);
        currentPlayer.setText("Current Player is: "+ticTacToeGame.getCurrentPlayer());
        if(ticTacToeGame.hasWon(ticTacToeGame.getOtherPlayer())){
            currentPlayer.setText("WINNER: "+ticTacToeGame.getOtherPlayer());
            lockBoard();
        }
        else if(ticTacToeGame.isTie()){
            currentPlayer.setText("TIE GAME");
            lockBoard();
        }
    }
    @FXML
    protected void buttonClick11() {
        String player = String.valueOf(ticTacToeGame.getCurrentPlayer());
        tile11.setText(player);
        tile11.setDisable(true);
        tile11.setStyle("-fx-opacity: 1");
        ticTacToeGame.placeTile(1,1);
        currentPlayer.setText("Current Player is: "+ticTacToeGame.getCurrentPlayer());
        if(ticTacToeGame.hasWon(ticTacToeGame.getOtherPlayer())){
            currentPlayer.setText("WINNER: "+ticTacToeGame.getOtherPlayer());
            lockBoard();
        }
        else if(ticTacToeGame.isTie()){
            currentPlayer.setText("TIE GAME");
            lockBoard();
        }
    }
    @FXML
    protected void buttonClick12() {
        String player = String.valueOf(ticTacToeGame.getCurrentPlayer());
        tile12.setText(player);
        tile12.setDisable(true);
        tile12.setStyle("-fx-opacity: 1");
        ticTacToeGame.placeTile(1,2);
        currentPlayer.setText("Current Player is: "+ticTacToeGame.getCurrentPlayer());
        if(ticTacToeGame.hasWon(ticTacToeGame.getOtherPlayer())){
            currentPlayer.setText("WINNER: "+ticTacToeGame.getOtherPlayer());
            lockBoard();
        }
        else if(ticTacToeGame.isTie()){
            currentPlayer.setText("TIE GAME");
            lockBoard();
        }
    }
    @FXML
    protected void buttonClick20() {
        String player = String.valueOf(ticTacToeGame.getCurrentPlayer());
        tile20.setText(player);
        tile20.setDisable(true);
        tile20.setStyle("-fx-opacity: 1");
        ticTacToeGame.placeTile(2,0);
        currentPlayer.setText("Current Player is: "+ticTacToeGame.getCurrentPlayer());
        if(ticTacToeGame.hasWon(ticTacToeGame.getOtherPlayer())){
            currentPlayer.setText("WINNER: "+ticTacToeGame.getOtherPlayer());
            lockBoard();
        }
        else if(ticTacToeGame.isTie()){
            currentPlayer.setText("TIE GAME");
            lockBoard();
        }
    }
    @FXML
    protected void buttonClick21() {
        String player = String.valueOf(ticTacToeGame.getCurrentPlayer());
        tile21.setText(player);
        tile21.setDisable(true);
        tile21.setStyle("-fx-opacity: 1");
        ticTacToeGame.placeTile(2,1);
        currentPlayer.setText("Current Player is: "+ticTacToeGame.getCurrentPlayer());
        if(ticTacToeGame.hasWon(ticTacToeGame.getOtherPlayer())){
            currentPlayer.setText("WINNER: "+ticTacToeGame.getOtherPlayer());
            lockBoard();
        }
        else if(ticTacToeGame.isTie()){
            currentPlayer.setText("TIE GAME");
            lockBoard();
        }
    }
    @FXML
    protected void buttonClick22() {
        String player = String.valueOf(ticTacToeGame.getCurrentPlayer());
        tile22.setText(player);
        tile22.setDisable(true);
        tile22.setStyle("-fx-opacity: 1");
        ticTacToeGame.placeTile(2,2);
        currentPlayer.setText("Current Player is: "+ticTacToeGame.getCurrentPlayer());
        if(ticTacToeGame.hasWon(ticTacToeGame.getOtherPlayer())){
            currentPlayer.setText("WINNER: "+ticTacToeGame.getOtherPlayer());
            lockBoard();
        }
        else if(ticTacToeGame.isTie()){
            currentPlayer.setText("TIE GAME");
            lockBoard();
        }
    }
    protected void lockBoard(){
        tile00.setDisable(true);
        tile01.setDisable(true);
        tile02.setDisable(true);
        tile10.setDisable(true);
        tile11.setDisable(true);
        tile12.setDisable(true);
        tile20.setDisable(true);
        tile21.setDisable(true);
        tile22.setDisable(true);
    }
    @FXML
    protected void restart(){
        ticTacToeGame.initialize();
        currentPlayer.setText("Current Player is: "+ticTacToeGame.getCurrentPlayer());
        tile00.setDisable(false);
        tile00.setText("[0,0]");
        tile01.setDisable(false);
        tile01.setText("[0,1]");
        tile02.setDisable(false);
        tile02.setText("[0,2]");
        tile10.setDisable(false);
        tile10.setText("[1,0]");
        tile11.setDisable(false);
        tile11.setText("[1,1]");
        tile12.setDisable(false);
        tile12.setText("[1,2]");
        tile20.setDisable(false);
        tile20.setText("[2,0]");
        tile21.setDisable(false);
        tile21.setText("[2,1]");
        tile22.setDisable(false);
        tile22.setText("[2,2]");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentPlayer.setText("Current Player is: "+ticTacToeGame.getCurrentPlayer());
    }
}