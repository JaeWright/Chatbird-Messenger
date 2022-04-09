package com.example.finalproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Header header;
    private Board board;

    @Override
    public void start(Stage stage) {
        try {

            // setting up the root pane and dimensions of scene
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);

            // called to create the game layout
            createGame(root);

            // setting scene of stage and showing stage to user
            stage.setScene(scene);
            stage.setTitle("Tic Tac Toe - Final Project");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void createGame(BorderPane root) {

        // creates board and header (displays player turn, option for new game) of the game
        createHeader(root);
        createBoard(root);
    }

    private void createBoard(BorderPane root) {
        board = new Board();
        root.getChildren().add(board.getStackPane());

    }

    private void createHeader(BorderPane root) {
        header = new Header();
        header.startButtonClicked(startNewGame());
        root.getChildren().add(header.getStackPane());
    }

    private EventHandler<ActionEvent> startNewGame() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                header.hideNewGameButton();
                header.setMessage("PLAYER X's TURN");
                System.out.println("STARTING GAME");
            }
        };
    }

    public static void main(String[] args) {
        launch();
    }
}