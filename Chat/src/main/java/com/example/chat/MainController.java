package com.example.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

import java.io.*;
import java.net.*;

/**
 * MainController class that binds all the gui components for main-view.fxml
 * @author Jackie Jiang, Jaelen Wright, Amanda Showler, Amit Sarvate
 * @version 1.0
 * Date: Apr 10
 */

public class MainController {
    public TextField login;

    private Stage stage;
    private Parent root;

    /**
     * enterChat method that will change to the chat-view.fxml scene
     * This method will also log the username
     * @param event
     * @throws IOException
     */
    public void enterChat(ActionEvent event) throws IOException {
        ChatController.username = login.getText();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
            "chat-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,525, 325);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * exit that will close the gui
     */
    @FXML
    protected void exit() {
        System.out.println("Connection terminated...");
        System.exit(0);
    }
}