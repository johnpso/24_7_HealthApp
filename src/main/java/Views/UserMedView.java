package Views;

import Models.MedicationInfo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class UserMedView {

    public VBox getView() {
        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.TOP_CENTER);

        // --- SECTION 1: USER HEADER ---
        VBox userSection = new VBox(10);
        userSection.setAlignment(Pos.CENTER_LEFT);
        userSection.setStyle("-fx-border-color: #ddd; -fx-border-width: 0 0 1 0; -fx-padding: 0 0 15 0;");

        Label userNameLabel = new Label("User: [First Name] [Last Name]");
        userNameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button editUserBtn = new Button("Edit User Info");

        // Placeholder for the "Expanded" edit menu
        VBox editUserContainer = new VBox(10);
        editUserContainer.setVisible(false); // Hidden by default
        editUserContainer.setManaged(false); // Doesn't take up space when hidden

        userSection.getChildren().addAll(userNameLabel, editUserBtn, editUserContainer);

        // --- SECTION 2: MEDICATION TABLE ---
        VBox medSection = new VBox(10);
        Label medTitle = new Label("Prescribed Medications");
        medTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        TableView<MedicationInfo> medTable = new TableView<>();

        // Table Columns
        TableColumn<MedicationInfo, String> nameCol = new TableColumn<>("Medication");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("medName"));

        TableColumn<MedicationInfo, String> dosageCol = new TableColumn<>("Dosage");
        dosageCol.setCellValueFactory(new PropertyValueFactory<>("dosage"));

        // Action Column for "View Details"
        TableColumn<MedicationInfo, Void> actionCol = new TableColumn<>("Actions");

        medTable.getColumns().addAll(nameCol, dosageCol, actionCol);
        medTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        medTable.setPrefHeight(200);

        // --- SECTION 3: MEDICATION DETAILS (Contextual) ---
        VBox detailsContainer = new VBox(10);
        detailsContainer.setPadding(new Insets(15));
        detailsContainer.setStyle("-fx-background-color: #f9f9f9; -fx-border-color: #ccc; -fx-border-radius: 5;");

        Label detailsTitle = new Label("Medication Details");
        detailsTitle.setStyle("-fx-font-weight: bold;");

        Label detailText = new Label("Select a medication to view details and schedule.");

        HBox detailActions = new HBox(10, new Button("Edit Med"), new Button("Delete Med"), new Button("View Schedule"));
        detailActions.setAlignment(Pos.CENTER_LEFT);

        detailsContainer.getChildren().addAll(detailsTitle, detailText, detailActions);

        // Add all sections to Main Layout
        mainLayout.getChildren().addAll(userSection, medSection, medTable, detailsContainer);

        return mainLayout;
    }
}