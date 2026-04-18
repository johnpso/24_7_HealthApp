package Main;

import Controllers.MenuController;
import DB.DatabaseHelper;
import Views.MainLayoutView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        DatabaseHelper.initializeDatabase();
        MainLayoutView mainLayout = new MainLayoutView();
        new MenuController(mainLayout);

        Image appIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/24_7_favicon.png")));
        stage.getIcons().add(appIcon);

        // Standard Scene Setup
        Scene scene = new Scene(mainLayout.getRoot(), 400, 600);
        stage.setTitle("Health Tracker");
        stage.setScene(scene);
        stage.show();
    }
}