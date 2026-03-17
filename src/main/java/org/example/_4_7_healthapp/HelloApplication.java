package org.example._4_7_healthapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;


public class HelloApplication extends Application {
    private TextArea CurrentDate = new TextArea("");
    private Button Report = new Button("Report");
    private Button UserInfo = new Button("UserInfo");
    private Button ModifyReport = new Button("+");
    @Override
    public void start(Stage stage) throws IOException {
        SetUp();
        CurrentDate.setText("Current date: " + LocalDate.now().toString());
        CurrentDate.setEditable(false);
        CurrentDate.maxHeight(10);
        //Other stuff

        // Layout
        VBox Root = new VBox(5);
        HBox TopBar = new HBox(5);
        TopBar.getChildren().addAll(CurrentDate);
        HBox BottomBar = new HBox(5);
        BottomBar.getChildren().addAll(Report, ModifyReport, UserInfo);
        BottomBar.setPadding(new Insets(10, 60, 10, 60));
        HBox Center = new HBox(5);
        Center.setMinHeight(150);
        Root.setPadding(new Insets(10));
        Root.getChildren().addAll(TopBar, Center, BottomBar);

        // Scene
        Scene scene = new Scene(Root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public void SetUp(){


    }
}
