package com.example.finalproject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    //test variable
    //run once with true to create a server, the rest can be false
    private boolean isServer = true;
    private Connection connection = isServer ? createServer() : createClient();

    @Override
    //start connection
    public void init() throws Exception{
        connection.startConnection();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 600);
        stage.setTitle("Tic-Tac-Toe Game");
        stage.setScene(scene);
        stage.show();
    }
    @Override
    //stop connection
    public void stop() throws Exception{
        connection.closeConnection();
    }
    //create user as server if set to be
    public Server createServer(){
        return new Server(55555,data ->{
            Platform.runLater(() -> {
                //data to share later, whether it be the scene or the input for next move
            });
        });
    }
    //create user as client if set to be
    public Client createClient(){
        return new Client("127.0.0.1",55555,data ->{
            Platform.runLater(() -> {
                //data to share later, whether it be the scene or the input for next move
            });
        });
    }

    public static void main(String[] args) {
        launch();
    }
}