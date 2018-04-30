package gui;

import java.time.LocalDate;

import application.Conference;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TextField;

public class ConferenceCreateTab extends Tab {

    public ConferenceCreateTab() {
        super("Opret Konference");

        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(50);
        pane.setVgap(10);

        addInfo(pane, 0, "Navn");
        addInfo(pane, 1, "Lokation");
        addInfoDate(pane, 2, "Dato");
        addInfo(pane, 3, "Antal dage");
        addInfo(pane, 5, "Pris");

        // Ok knap
        Button btn = new Button("Ok");
        btn.setFont(Font.font("Arial", 18));
        btn.setOnAction(event -> buttonOk());
        pane.add(btn, 1, 6);

        setContent(pane);
    }

    private Object buttonOk() {
        // TODO Auto-generated method stub
        return null;
    }

    private void addInfo(GridPane pane, int row, String text) {
        // Set up the label
        Label label = createLabel(text);
        pane.add(label, 0, row);

        // Set up the editable field
        TextField txf = new TextField();
        txf = new TextField();
        // txf.setMaxWidth(300);
        txf.setEditable(true);
        txf.setFocusTraversable(true);
        // txf.setFont(font);
        pane.add(txf, 1, row);
    }

    private void addInfoDate(GridPane pane, int row, String text) {
        // Set up the label
        Label label = createLabel(text);
        pane.add(label, 0, row);

        DatePicker dp = new DatePicker();
        pane.add(dp, 1, row);
    }

    private Label createLabel(String text) {
        Label label = new Label();
        label.setText(text);
        // label.setMaxWidth(300);
        label.setMinWidth(150);
        return label;
    }

    // A larger font used for drawing the dies values
    Font font = Font.font("Arial", FontWeight.BOLD, 16);
}
