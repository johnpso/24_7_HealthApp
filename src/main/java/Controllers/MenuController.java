package Controllers;

import Views.*;
import javafx.scene.Node;

public class MenuController {
    private final MainLayoutView mainLayout;

    // Partial Views
    private final DefaultView defaultView;
    private final UserMedView userMedView;
    private final ReportView reportsView;
    private final GraphsView historyView;

    public MenuController(MainLayoutView mainLayout) {
        this.mainLayout = mainLayout;

        // Initialize partial views
        this.defaultView = new DefaultView();
        this.userMedView = new UserMedView();
        this.reportsView = new ReportView();
        this.historyView = new GraphsView();

        // Attach listeners to the renamed buttons
        setupNavigation();

        // Set the initial screen
        switchMenu(MenuState.DEFAULT);
    }

    private void setupNavigation() {
        // Connect UserInfo to UserMedView
        mainLayout.userInfoBtn.setOnAction(e -> switchMenu(MenuState.USER_MEDICATION));

        // Connect ReportInfo to GraphsView (History)
        mainLayout.reportInfoBtn.setOnAction(e -> switchMenu(MenuState.GRAPHS_HISTORY));

        // Connect EditReport to ReportsView (The Form)
        mainLayout.editReportBtn.setOnAction(e -> switchMenu(MenuState.REPORTS));

        // Connect Return to DefaultView
        mainLayout.returnBtn.setOnAction(e -> switchMenu(MenuState.DEFAULT));
    }

    public void switchMenu(MenuState newState) {
        Node nextView;

        // Routing logic based on your new requirements
        switch (newState) {
            case USER_MEDICATION -> nextView = userMedView.getView(); // User info & Med table
            case GRAPHS_HISTORY -> nextView = historyView.getView();  // Report Info (Graphs)
            case REPORTS -> nextView = reportsView.getView();         // Edit Report (The Form)
            case DEFAULT -> nextView = defaultView.getView();         // Home screen
            default -> nextView = defaultView.getView();
        }

        // Inject the chosen view into the center of the scrollable main layout
        mainLayout.setCenterView(nextView);
    }
}