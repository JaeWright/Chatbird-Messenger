package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class Header {

    private StackPane pane;
    private Label message;
    private Button newGameOption;

    public Header() {

        // creating pane for the header section
        pane = new StackPane();
        pane.setMinSize(Constants.GAME_WIDTH, Constants.HEADER_HEIGHT);

        // setting the location of the pane on scene
        pane.setTranslateX(Constants.GAME_WIDTH / 2);
        pane.setTranslateY(Constants.HEADER_HEIGHT / 2);

        message = new Label("TIC TAC TOE");
        message.setMinSize(Constants.GAME_WIDTH, Constants.HEADER_HEIGHT);
        message.setFont(Font.font(Constants.FONT_FAMILY, Constants.MESSAGE_FONT_SIZE));
        message.setAlignment(Pos.CENTER);
        message.setTranslateY(-20);

        pane.getChildren().add(message);

        newGameOption = new Button("Start");
        newGameOption.setFont(Font.font(Constants.FONT_FAMILY, Constants.BUTTON_FONT_SIZE));
        newGameOption.setMinSize(135, 30);
        newGameOption.setTranslateY(20);
        pane.getChildren().add(newGameOption);

    }

    public StackPane getStackPane() {
        return this.pane;
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }

    public void startButtonClicked(EventHandler<ActionEvent> onAction) {
        this.newGameOption.setOnAction(onAction);
    }

    // setting the visibility of the message button depending on the state of the game
    public void showNewGameButton() {
        this.newGameOption.setVisible(true);
    }

    public void hideNewGameButton() {
        this.newGameOption.setVisible(false);
    }

}
