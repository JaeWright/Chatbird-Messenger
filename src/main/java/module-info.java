module com.example.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
}