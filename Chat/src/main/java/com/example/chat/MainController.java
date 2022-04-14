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

public class MainController {
    public TextField login;

    private Stage stage;
    private Parent root;

    public void enterChat(ActionEvent event) throws IOException {
        ChatController.username = login.getText();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
            "chat-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,526,323);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    protected void exit() {
        System.out.println("Connection terminated...");
        System.exit(0);
    }
}