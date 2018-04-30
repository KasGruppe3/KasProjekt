package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class ConferenceCreateTab extends Tab {

    public ConferenceCreateTab() {
        super("Opret Konference");

        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        setContent(pane);
    }
}
