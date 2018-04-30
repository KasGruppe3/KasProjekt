package gui;



import application.FieldTrip;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CompanionTab extends KASBaseTab {
	private TextField tripName, tripTime, tripDescription, tripPrice, tripLunch;
	private ListView<FieldTrip> fieldTripList;

    public CompanionTab() {
        super("Vælg udflugt for ledsager");

        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        setContent(pane);
        
        Label fieldTripLabel = new Label("Udflugter:");
		pane.add(fieldTripLabel, 0, 0);
		
		ListView<FieldTrip> fieldTripList = new ListView<FieldTrip>();
		pane.add(fieldTripList, 0, 1);
		ChangeListener<FieldTrip> listener = (ov, oldFieldTrip, newFieldTrip) -> this.selectedFieldTrip();
		fieldTripList.getSelectionModel().selectedItemProperty().addListener(listener);
        
        tripName = addTextField(pane, 1, 0, "Navn");
        tripName.setEditable(false);
        tripTime = addTextField(pane, 1, 1, "Tidspunkt:");
        tripTime.setEditable(false);
        tripDescription = addTextField(pane, 1, 2, "Beskrivelse:");
        tripDescription.setEditable(false);
        tripPrice = addTextField(pane, 1, 3, "Pris:");
        tripPrice.setEditable(false);
        tripLunch = addTextField(pane, 1, 4, "Inklusiv mad:");
        tripLunch.setEditable(false);
        
        if (fieldTripList.getItems().size() > 0) {
        	fieldTripList.getSelectionModel().select(0);
        }
        
	}
	private void selectedFieldTrip() {
		this.updateControls();
	}
	public void updateControls() {
        FieldTrip fieldTrip = fieldTripList.getSelectionModel().getSelectedItem();
        if (fieldTrip != null) {
            tripName.setText(fieldTrip.getDescription());
            tripTime.setText("" + fieldTrip.getMeetingTime());
            tripPrice.setText("" + fieldTrip.getPrice());
            tripLunch.setText("" + fieldTrip.isHasLunch());
        } else {
        	tripName.clear();
        	tripTime.clear();
        	tripPrice.clear();
        	tripLunch.clear();
        }
    }
}
