module org.example._4_7_healthapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example._4_7_healthapp to javafx.fxml;
    exports org.example._4_7_healthapp;
}