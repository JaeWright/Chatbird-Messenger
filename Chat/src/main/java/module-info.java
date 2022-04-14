module com.example.chat {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.chat to javafx.fxml;
    exports com.example.chat;
}