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

/**
 * ChatController class that binds all the gui components for chat-view.fxml
 * @author Jackie Jiang, Jaelen Wright, Amanda Showler, Amit Sarvate
 * @version 1.0
 * Date: Apr 10
 */

public class ChatController implements Initializable {

    public Label name;
    private Client client;
    public static String username;
    @FXML
    public TextArea textBox;
    public TextField sendText;

    /**
     * exit that will close the gui
     */
    @FXML
    protected void exit() {
        System.out.println("Connection terminated...");
        System.exit(0);
    }

    /**
     * send that will send a message to the server
     * @throws IOException
     */
    public void send() throws IOException {
        String message = username + ": " + sendText.getText();
        //System.out.println(message);
        client.sendMessage(message);
        sendText.clear();
    }
    
    /**
     * initialize object that will initialize the controller
     * This method will also create a new client class that will
     * connect with the server 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //System.out.println(username);
        name.setText(username);
        Socket socket = null;
        try {
            socket = new Socket("localhost", 2222);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert socket != null;
        client = new Client(socket, username,textBox);
        try {
            client.listenForMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}