package gui;

import application.FieldTrip;
import application.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

public class CompanionTab extends KASBaseTab {
    private CheckBox cbxAttendant;
    private TextField tripCompanionName, tripDescription, tripTime, tripPrice, tripLunch;
    private ListView<FieldTrip> fieldTripList = new ListView<>();

    public CompanionTab() {
        super("Ledsagerinfo");

        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        setContent(pane);

        Label fieldTripLabel = new Label("Udflugter:");
        pane.add(fieldTripLabel, 0, 1);

        pane.add(fieldTripList, 0, 2);

        GridPane attPane = new GridPane();
        pane.add(attPane, 0, 0);

        GridPane fieldTripPane = new GridPane();
        pane.add(fieldTripPane, 1, 2);
        pane.setHgap(20);
        pane.setVgap(20);

        GridPane navnPane = new GridPane();
        pane.add(navnPane, 1, 0);

        cbxAttendant = addCheckBox(attPane, 0, 0, "Har du en deltager med?");
        cbxAttendant.setOnAction(event -> tripCompanionName.setEditable(true));
        tripCompanionName = addTextField(navnPane, 0, 0, "Deltagernavn:");
        tripCompanionName.setEditable(false);
        tripDescription = addTextField(fieldTripPane, 1, 1, "Beskrivelse:");
        tripDescription.setEditable(false);
        tripTime = addTextField(fieldTripPane, 1, 2, "Tidspunkt:");
        tripTime.setEditable(false);
        tripPrice = addTextField(fieldTripPane, 1, 3, "Pris:");
        tripPrice.setEditable(false);
        tripLunch = addTextField(fieldTripPane, 1, 4, "Inklusiv mad:");
        tripLunch.setEditable(false);

        fieldTripList.getItems().setAll(Service.getFieldTrips());
        fieldTripList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        ChangeListener<FieldTrip> listener = (ov, oldFieldTrip, newFieldTrip) -> selectedFieldTrip();
        fieldTripList.getSelectionModel().selectedItemProperty().addListener(listener);

    }

    private void selectedFieldTrip() {
        FieldTrip fieldTrip = fieldTripList.getSelectionModel().getSelectedItem();
        if (fieldTrip != null) {
            tripDescription.setText(fieldTrip.getDescription());
            tripTime.setText("" + fieldTrip.getMeetingTime());
            tripPrice.setText("" + fieldTrip.getPrice());
            tripLunch.setText("" + fieldTrip.isHasLunch());
        }
    }

    public String getCompanionInfo() {
        if (!cbxAttendant.isSelected()) {
            return "Ingen ledsager";
        }

        String info = "Navn: " + tripCompanionName.getText() + "\n";

        info += "Meldt til udflugter:\n";
        for (FieldTrip ft : fieldTripList.getSelectionModel().getSelectedItems()) {
            info += "\t" + ft.getDescription() + ", tid: " + ft.getMeetingTime() + ", pris: " + ft.getPrice();
            if (ft.isHasLunch()) {
                info += " (inkl. mad)";
            }
            info += "\n";
        }

        return info;
    }
}
