module com.example.elephantfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.elephantfx to javafx.fxml;
    exports com.example.elephantfx;
}