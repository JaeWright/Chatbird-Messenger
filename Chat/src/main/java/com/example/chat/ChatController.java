package com.example.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    public Label name;
    private Client client;
    public static String username;
    @FXML
    public TextArea textBox;
    public TextField sendText;

    @FXML
    protected void exit() {
        System.out.println("Connection terminated...");
        System.exit(0);
    }

    public void send() {
        String message = username + ": " + sendText.getText();
        System.out.println(message);
        //textBox.appendText(message+ "\n");
        client.sendMessage(message+ "\n");
        sendText.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(username);
        name.setText(username);
        Socket socket = null;
        try {
            socket = new Socket("localhost", 2222);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert socket != null;
        client = new Client(socket, username,textBox);
        client.listenForMessage();
    }
}