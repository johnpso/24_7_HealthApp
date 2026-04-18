module org.example._4_7_healthapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires org.slf4j;
    requires org.slf4j.simple;

    exports Main;
    exports Models;
    exports Controllers;
    exports Views;

    opens Main to javafx.fxml;
    opens Models to javafx.fxml;
    opens Controllers to javafx.fxml;
    opens Views to javafx.fxml;
    exports DB;
    opens DB to javafx.fxml;
}