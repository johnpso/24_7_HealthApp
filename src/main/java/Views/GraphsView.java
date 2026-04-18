package Views;

import Models.DailyReport;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class GraphsView {

    public VBox getView() {
        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.TOP_CENTER);

        // --- SECTION 1: TOP NAVIGATION BUTTONS ---
        HBox graphNav = new HBox(15, new Button("Last Week"), new Button("Last 4 Weeks"));
        graphNav.setAlignment(Pos.CENTER);

        // --- SECTION 2: BAR GRAPH ---
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Value");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Health Progress");
        barChart.setPrefHeight(300);

        // Message Label under the graph
        Label graphMessage = new Label("Showing data for the selected period.");
        graphMessage.setStyle("-fx-font-style: italic; -fx-text-fill: gray;");

        // --- SECTION 3: WEEKLY TABLE (Mon - Sun) ---
        VBox weeklySection = new VBox(10);
        Label weeklyTitle = new Label("This Week's Summary (Mon - Sun)");
        weeklyTitle.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        TableView<DailyReport> weeklyTable = createReportTable();
        weeklyTable.setPrefHeight(180);

        // --- SECTION 4: SEARCH HISTORY (Hidden by default) ---
        Button showHistoryBtn = new Button("Show More History");

        VBox searchContainer = new VBox(15);
        searchContainer.setVisible(false);
        searchContainer.setManaged(false);
        searchContainer.setStyle("-fx-border-color: #ccc; -fx-padding: 15; -fx-background-color: #f4f4f4;");

        // Search Controls
        HBox searchControls = new HBox(10);
        searchControls.setAlignment(Pos.CENTER_LEFT);
        DatePicker startPicker = new DatePicker();
        DatePicker endPicker = new DatePicker();
        Button searchBtn = new Button("Search");
        searchControls.getChildren().addAll(new Label("From:"), startPicker, new Label("To:"), endPicker, searchBtn);

        TableView<DailyReport> searchResultsTable = createReportTable();

        // Journal Column for Search Results (Special Button)
        TableColumn<DailyReport, Void> journalCol = new TableColumn<>("Journal");
        // CellFactory logic would go in Controller
        searchResultsTable.getColumns().add(journalCol);

        searchContainer.getChildren().addAll(new Label("Search History"), searchControls, searchResultsTable);

        // Logic to show search container (to be moved to Controller eventually)
        showHistoryBtn.setOnAction(e -> {
            searchContainer.setVisible(true);
            searchContainer.setManaged(true);
            showHistoryBtn.setVisible(false);
        });

        // Add everything to main layout
        mainLayout.getChildren().addAll(
                graphNav,
                barChart,
                graphMessage,
                weeklySection,
                weeklyTable,
                showHistoryBtn,
                searchContainer
        );

        return mainLayout;
    }

    // Helper method to keep code clean since we use two similar tables
    private TableView<DailyReport> createReportTable() {
        TableView<DailyReport> table = new TableView<>();

        TableColumn<DailyReport, String> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<DailyReport, Integer> moodCol = new TableColumn<>("Mood");
        moodCol.setCellValueFactory(new PropertyValueFactory<>("moodScore"));

        TableColumn<DailyReport, Double> bmiCol = new TableColumn<>("BMI");
        bmiCol.setCellValueFactory(new PropertyValueFactory<>("bmi"));

        TableColumn<DailyReport, Double> bmrCol = new TableColumn<>("BMR");
        bmrCol.setCellValueFactory(new PropertyValueFactory<>("bmr"));

        TableColumn<DailyReport, Double> calCol = new TableColumn<>("Calories");
        calCol.setCellValueFactory(new PropertyValueFactory<>("caloricIntake"));

        table.getColumns().addAll(dateCol, moodCol, bmiCol, bmrCol, calCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        return table;
    }
}