package com.example.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Create two applications instead of 1
        // Should run the server and then create these two client applications
        
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game-view.fxml"));
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("game-view.fxml"));
        Parent root = (Parent) loader.load();
        HelloController controller = loader.getController();
        Scene scene = new Scene(root, 500, 600);
        stage.setTitle("Player 1");
        stage.setScene(scene);
        stage.show();

        //FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("game-view.fxml"));
        FXMLLoader loader2 = new FXMLLoader(this.getClass().getResource("game-view.fxml"));
        Parent root2 = (Parent) loader2.load();
        HelloController controller2 = loader2.getController();
        Scene scene2 = new Scene(root2, 500, 600);
        Stage stage2 = new Stage();
        stage2.setTitle("Player 2");
        stage2.setScene(scene2);
        stage2.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
