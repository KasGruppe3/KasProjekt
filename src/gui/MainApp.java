package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainApp extends Application {
    private Button btnAttending;
    private Button btnAdmin;
    private Button btnCancel;
    private Button btnHelp;
    private Alert alarm;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("KAS");
        GridPane pane = new GridPane();
        initContent(pane, stage);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void initContent(GridPane pane, Stage stage) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        GridPane frontPage = new GridPane();
        pane.add(frontPage, 0, 0);
        frontPage.setGridLinesVisible(false);
        frontPage.setPadding(new Insets(10));
        frontPage.setHgap(10);
        frontPage.setVgap(10);

        btnAttending = new Button("Deltag i konferrence");
        frontPage.add(btnAttending, 1, 1);
        btnAttending.setPrefHeight(100);
        btnAttending.setPrefWidth(400);
        btnAttending.setFont(Font.font(null, FontWeight.BOLD, 25));
        btnAttending.setOnAction(event -> attendantAction(stage));

        btnAdmin = new Button("Administator");
        frontPage.add(btnAdmin, 1, 2);
        btnAdmin.setPrefHeight(100);
        btnAdmin.setPrefWidth(400);
        btnAdmin.setFont(Font.font(null, FontWeight.BOLD, 25));
        btnAdmin.setOnAction(event -> adminAction(stage));

        btnCancel = new Button("Afbryd");
        pane.add(btnCancel, 1, 3);
        btnCancel.setOnAction(event -> closeWindow());

        btnHelp = new Button("Hjælp");
        pane.add(btnHelp, 0, 3);
        btnHelp.setOnAction(event -> helpWindow());
    }

    // -----------------------------------------------------
    // Button actions

    private void attendantAction(Stage stage) {
        AttendantWindow attendantWindow = new AttendantWindow("Attendants", stage);
        attendantWindow.show();
    }

    private void adminAction(Stage stage) {
        AdminWindow adminWindow = new AdminWindow("Admin", stage);
        adminWindow.show();
    }

    public void closeWindow() {
        System.exit(0);
    }

    public void helpWindow() {
        alarm = new Alert(AlertType.INFORMATION);

        alarm.setTitle("Hjælp");
        alarm.setHeaderText("Tryk på en knap.");
        alarm.setContentText(
                "Tryk \"Deltag i konferrence\" hvis du vil deltage i en konference \nEller tryk Administrator hvis du er en del af konferrence teamet.");

        alarm.showAndWait();

    }
}