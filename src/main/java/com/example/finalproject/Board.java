package com.example.finalproject;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class Board {

    private Header header;
    private StackPane pane;
    private GridPane grid;
    private ArrayList<Button> boardButtons;


    public Board() {
        this.header = header;
        pane = new StackPane();
        pane.setMinSize(Constants.GAME_WIDTH, Constants.BOARD_HEIGHT);

        // setting the location of the pane on scene
        pane.setTranslateX(Constants.GAME_WIDTH / 2);
        pane.setTranslateY(Constants.BOARD_HEIGHT / 2);

        grid = new GridPane();
        grid.setTranslateY(200);

        boardButtons = new ArrayList<Button>();

        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                Button button = new Button();

                button.setMinSize(Constants.TILE_SIZE, Constants.TILE_SIZE);

                boardButtons.add(button);
                grid.add(button, i, j);
            }
        }

        pane.getChildren().add(grid);
    }

    public StackPane getStackPane() {
        return this.pane;
    }



}
