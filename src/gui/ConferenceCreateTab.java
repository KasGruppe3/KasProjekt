package gui;

import java.time.LocalDate;

import application.Conference;
import application.Service;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ConferenceCreateTab extends KASBaseTab {

    private TextField fieldName;
    private TextField fieldLocation;
    private DatePicker fieldDatePicker;
    private TextField fieldDuration;
    private TextField fieldPrice;
    private Label fieldErrMsg;

    public ConferenceCreateTab() {
        super("Opret Konference");

        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(50);
        pane.setVgap(10);

        fieldName = addTextField(pane, 0, "Navn");
        fieldLocation = addTextField(pane, 1, "Lokation");
        fieldDatePicker = addDatePicker(pane, 2, "Dato");
        fieldDuration = addTextField(pane, 3, "Antal dage");
        fieldPrice = addTextField(pane, 4, "Pris");
        createMessageField(pane, 1, 5, 2);

        // Reset error message when values change
        fieldDuration.setOnKeyPressed(event -> hideMessage());
        fieldPrice.setOnKeyPressed(event -> hideMessage());

        // Ok knap
        Button btn = new Button("Ok");
        btn.setFont(Font.font("Arial", 16));
        btn.setOnAction(event -> buttonOk());
        pane.add(btn, 1, 6);

        setContent(pane);
    }

    private Object buttonOk() {
        String name = fieldName.getText();
        if (name.isEmpty()) {

        }

        String location = fieldLocation.getText();
        LocalDate date = fieldDatePicker.getValue();
        int timeSpan;
        double price;
        try {
            timeSpan = Integer.parseInt(fieldDuration.getText());
        } catch (NumberFormatException nfe) {
            // Ya done goofed
            showError("Ugyldigt værdi af antal dage");
            return null;
        }
        try {
            price = Double.parseDouble(fieldPrice.getText());
        } catch (NumberFormatException nfe) {
            // Ya done goofed
            showError("Ugyldig pris");
            return null;
        }

        Service.createConference(name, location, date, timeSpan, price);
        showInformation("Konference oprettet!");
        return null;
    }
}
