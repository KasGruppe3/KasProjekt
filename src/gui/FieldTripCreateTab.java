package gui;

import java.time.LocalDate;
import java.time.LocalTime;

import application.FieldTrip;
import application.Service;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class FieldTripCreateTab extends KASBaseTab {

	private TextField fieldDescription;
	private DatePicker fieldDatePicker;
	private TextField fieldTime;
	private TextField fieldPrice;
	private CheckBox fieldLunch;
	private ConferenceCreateTab cct;

	public FieldTripCreateTab(ConferenceCreateTab cct) {
		super("Opret Udflugt");
		this.cct = cct;

		GridPane pane = new GridPane();
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(50);
		pane.setVgap(10);
		setContent(pane);

		fieldDescription = addTextField(pane, 0, 0, "Beskrivelse");
		fieldDatePicker = addDatePicker(pane, 0, 1, "Dato");
		fieldTime = addTextField(pane, 0, 2, "Mødetid");
		fieldPrice = addTextField(pane, 0, 3, "Pris");
		fieldLunch = addCheckBox(pane, 0, 4, "Frokost inkuderet?");

		// Ok knap
		Button btn = new Button("Ok");
		btn.setFont(Font.font("Arial", 16));
		btn.setOnAction(event -> buttonOk());
		pane.add(btn, 1, 5);

		createMessageField(pane, 1, 6, 2);
	}

	private void buttonOk() {
		if (cct.getConference() == null) {
			showError("Opret en konference først!");
			return;
		}

		LocalDate date = fieldDatePicker.getValue();
		if (date.isBefore(LocalDate.now())) {
			showError("Ugyldig dato!");
			return;
		}

		int meetingTime;
		try {
			meetingTime = Integer.parseInt(fieldTime.getText());
			if (meetingTime < 0 || meetingTime > 24) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException nfe) {
			showError("Ugyldigt mødetidspunkt! Angiv timetal mellem 0-23");
			return;
		}

		String description = fieldDescription.getText();
		if (description.isEmpty()) {
			showError("Angiv en beskrivelse!");
			return;
		}

		double price;
		try {
			price = Double.parseDouble(fieldPrice.getText());
			if (price < 0) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException nfe) {
			showError("Din pris er ugyldige");
			return;
		}

		boolean hasLunch = fieldLunch.isSelected();
		FieldTrip fieldTrip = Service.createFieldTrip(date, LocalTime.of(meetingTime, 0), description, price, hasLunch);
		cct.getConference().addFieldTrip(fieldTrip);
		showInformation("Udflugt oprettet!");
	}
}
