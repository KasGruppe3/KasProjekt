package gui;

import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class KASBaseTab extends Tab {

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

    protected void addTextField(GridPane pane, int row, String text) {
        // Set up the label
        Label label = createLabel(text);
        pane.add(label, 0, row);

        // Set up the editable field
        TextField txf = new TextField();
        txf = new TextField();
        txf.setEditable(true);
        txf.setFocusTraversable(true);
        // txf.setFont(font);
        pane.add(txf, 1, row);
    }

    protected void addDatePicker(GridPane pane, int row, String text) {
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

}