package gui;

import application.FieldTrip;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class CompanionTab extends KASBaseTab {
	private CheckBox cbxAttendant;
	private TextField tripCompanionName, tripDescription, tripTime, tripPrice, tripLunch;
	private ListView<FieldTrip> fieldTripList;

    public CompanionTab() {
        super("V�lg udflugt for ledsager");

        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        setContent(pane);
        
        Label fieldTripLabel = new Label("Udflugter:");
		pane.add(fieldTripLabel, 0, 1);
		
		ListView<FieldTrip> fieldTripList = new ListView<FieldTrip>();
		pane.add(fieldTripList, 0, 2);
		ChangeListener<FieldTrip> listener = (ov, oldFieldTrip, newFieldTrip) -> this.selectedFieldTrip();
		fieldTripList.getSelectionModel().selectedItemProperty().addListener(listener);
        
		GridPane attPane = new GridPane();
		pane.add(attPane, 0, 0);
		
		GridPane fieldTripPane = new GridPane();
		pane.add(fieldTripPane, 1, 2);
		pane.setHgap(50);
        pane.setVgap(20);
		
		cbxAttendant = addCheckBox(attPane, 0, 0, "Har du en deltager med?");
		cbxAttendant.setOnAction(event -> tripCompanionName.setEditable(true));
		tripCompanionName = addTextField(pane, 1, 0, "Deltagernavn:");
		tripCompanionName.setEditable(false);
        tripDescription = addTextField(fieldTripPane, 1, 1, "Beskrivelse:");
        tripDescription.setEditable(false);
        tripTime = addTextField(fieldTripPane, 1, 2, "Tidspunkt:");
        tripTime.setEditable(false);
        tripPrice = addTextField(fieldTripPane, 1, 3, "Pris:");
        tripPrice.setEditable(false);
        tripLunch = addTextField(fieldTripPane, 1, 4, "Inklusiv mad:");
        tripLunch.setEditable(false);
        
        if (fieldTripList.getItems().size() > 0) {
        	fieldTripList.getSelectionModel().select(0);
        }
        
        Button btn = new Button("Ok");
        btn.setFont(Font.font("Arial", 16));
        btn.setOnAction(event -> buttonOk());
        pane.add(btn, 1, 5);
        
	}
	private Object buttonOk() {
		// TODO Auto-generated method stub
		return null;
	}
	private void selectedFieldTrip() {
		this.updateControls();
	}
	public void updateControls() {
        FieldTrip fieldTrip = fieldTripList.getSelectionModel().getSelectedItem();
        if (fieldTrip != null) {
            tripDescription.setText(fieldTrip.getDescription());
            tripTime.setText("" + fieldTrip.getMeetingTime());
            tripPrice.setText("" + fieldTrip.getPrice());
            tripLunch.setText("" + fieldTrip.isHasLunch());
        } else {
        	tripDescription.clear();
        	tripTime.clear();
        	tripPrice.clear();
        	tripLunch.clear();
        }
    }
}
