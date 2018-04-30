package gui;

import java.time.LocalDate;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class KASBaseTab extends Tab {

    private Label fieldMessage;

    public KASBaseTab() {
        super();
        setClosable(false);
    }

    public KASBaseTab(String text) {
        super(text);
        setClosable(false);
    }

    public KASBaseTab(String text, Node content) {
        super(text, content);
        setClosable(false);
    }

    protected TextField addTextField(GridPane pane, int columnStart, int row, String text) {
        // Set up the label
        Label label = createLabel(text);
        pane.add(label, columnStart, row);

        // Set up the editable field
        TextField txf = new TextField();
        txf = new TextField();
        txf.setEditable(true);
        txf.setFocusTraversable(true);
        // txf.setFont(font);
        pane.add(txf, columnStart + 1, row);

        return txf;
    }

    protected DatePicker addDatePicker(GridPane pane, int columnStart, int row, String text) {
        // Set up the label
        Label label = createLabel(text);
        pane.add(label, columnStart, row);

        DatePicker dp = new DatePicker(LocalDate.now());
        pane.add(dp, columnStart + 1, row);

        return dp;
    }

    protected CheckBox addCheckBox(GridPane pane, int columnStart, int row, String text) {
        // Set up the label
        Label label = createLabel(text);
        pane.add(label, columnStart, row);

        // Create the checkbox
        CheckBox cb = new CheckBox();
        pane.add(cb, columnStart + 1, row);

        return cb;
    }

    protected Label addErrorMessageLabel(GridPane pane, int row, int columnSpan) {
        Label label = createLabel("hidden error msg");
        pane.add(label, 0, row, columnSpan, 1);
        return label;
    }

    private Label createLabel(String text) {
        Label label = new Label();
        label.setText(text);
        // label.setMaxWidth(300);
        label.setMinWidth(150);
        return label;
    }

    protected void createMessageField(GridPane pane, int column, int row, int columnSpan) {
        fieldMessage = createLabel("hidden error msg");
        pane.add(fieldMessage, column, row, columnSpan, 1);
        fieldMessage.setVisible(false);
    }

    protected void hideMessage() {
        fieldMessage.setVisible(false);
    }

    protected void showMessage(String text, Color color) {
        fieldMessage.setTextFill(color);
        fieldMessage.setText(text);
        fieldMessage.setVisible(true);
    }

    protected void showError(String text) {
        showMessage(text, Color.RED);
    }

    protected void showInformation(String text) {
        showMessage(text, Color.GREEN);
    }
}