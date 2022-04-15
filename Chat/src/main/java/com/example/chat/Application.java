package com.example.chat;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Application class that starts the application
 * @author Jackie Jiang, Jaelen Wright, Amanda Showler, Amit Sarvate
 * @version 1.0
 * Date: Apr 10
 */
public class Application extends javafx.application.Application {
    /**
     * Start that will create the main javafx UI
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 525, 215);
        stage.setTitle("Chat");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * main method that will launch the application
     */
    public static void main(String[] args) {
        //launch the application
        launch();
    }
}