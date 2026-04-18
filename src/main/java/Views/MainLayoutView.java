package Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import java.time.LocalDate;

public class MainLayoutView {
    private BorderPane root;
    private StackPane centerContent;
    private ScrollPane scrollPane;

    // Renamed Buttons
    public Button userInfoBtn = new Button("User Info");
    public Button reportInfoBtn = new Button("Report Info");
    public Button editReportBtn = new Button("Edit Report");
    public Button returnBtn = new Button("Return");

    public MainLayoutView() {
        root = new BorderPane();
        centerContent = new StackPane();
        scrollPane = new ScrollPane();

        setupLayout();
    }

    private void setupLayout() {
        // --- Color Palette ---
        String softYellow = "#FFF9C4"; // Light yellow background
        String borderGray = "#E0E0E0"; // Soft border color

        // Top Bar
        Label dateLabel = new Label("Date: " + LocalDate.now());
        dateLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #5D4037;"); // Darker brown text for contrast

        HBox topBar = new HBox(dateLabel);
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setStyle("-fx-background-color: " + softYellow + "; " +
                "-fx-border-color: " + borderGray + "; " +
                "-fx-border-width: 0 0 1 0;");

        // Bottom Bar (Nav)
        // Includes the new button names and the Return button
        HBox bottomBar = new HBox(15, userInfoBtn, reportInfoBtn, editReportBtn, returnBtn);
        bottomBar.setAlignment(Pos.CENTER);
        bottomBar.setPadding(new Insets(15));
        bottomBar.setStyle("-fx-background-color: " + softYellow + "; " +
                "-fx-border-color: " + borderGray + "; " +
                "-fx-border-width: 1 0 0 0;");

        // Center Content Area (Making the StackPane itself yellow so the background matches)
        centerContent.setStyle("-fx-background-color: " + softYellow + ";");
        centerContent.setPadding(new Insets(10));

        // --- ScrollPane Configuration ---
        scrollPane.setContent(centerContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        // Making the ScrollPane "Invisible" so the yellow shows through
        scrollPane.setStyle("-fx-background-color: transparent; " +
                "-fx-background: " + softYellow + "; " +
                "-fx-border-color: transparent;");

        root.setTop(topBar);
        root.setCenter(scrollPane);
        root.setBottom(bottomBar);

        // Optional: Simple styling for the buttons to make them look cohesive
        applyButtonStyle(userInfoBtn);
        applyButtonStyle(reportInfoBtn);
        applyButtonStyle(editReportBtn);
        applyButtonStyle(returnBtn);
    }

    // Helper method to style buttons consistently
    private void applyButtonStyle(Button btn) {
        btn.setStyle("-fx-background-color: #FFFFFF; " +
                "-fx-border-color: #D4E157; " +
                "-fx-border-radius: 5; " +
                "-fx-background-radius: 5;");
    }

    public void setCenterView(Node view) {
        centerContent.getChildren().setAll(view);
    }

    public Parent getRoot() {
        return root;
    }
}