package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController{

    private Stage stage;
    private Parent root;

    public void startGameX(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
            "game-view.fxml"));
        root = loader.load();
        GameController main = loader.getController();
        main.setPlayer('X');

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();
    }
    public void startGameO(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
            "game-view.fxml"));
        root = loader.load();
        GameController main = loader.getController();
        main.setPlayer('O');

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();
    }
}