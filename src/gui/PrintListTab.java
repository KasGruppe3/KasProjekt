package gui;

import application.Conference;
import application.FieldTrip;
import application.Hotel;
import application.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import storage.Storage;

public class PrintListTab extends KASBaseTab{
	
	private ListView<Conference> conferenceList = new ListView<Conference>();
//	private ListView<> conferenceAttendees = new ListView<>();
	private Button btnUpdateConference;
	private Button btnPrintConference, btnPrintHotel, btnPrintFieldTrip;
	private Alert alarm;	
	
	public PrintListTab() {
        super("Udprint lister");
        
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(50);
        pane.setVgap(10);
        setContent(pane);
        
        Label conferenceLabel = new Label("Konferrencer:");
		pane.add(conferenceLabel, 0, 1);
		
		pane.add(conferenceList, 0, 2);
		conferenceList.setMaxHeight(120);
        
		conferenceList.getItems().setAll(Service.getConferences());
		
		btnUpdateConference = new Button("Opdater konference liste");
		pane.add(btnUpdateConference, 0, 3);
		btnUpdateConference.setOnAction(event -> conferenceList.getItems().setAll(Service.getConferences()));
		
		GridPane printPane = new GridPane();
		pane.add(printPane, 1, 2);
		printPane.setPadding(new Insets(15));
		printPane.setVgap(5);
		
		btnPrintConference = new Button("Udprint deltagerliste");
		printPane.add(btnPrintConference, 0, 1);
		btnPrintConference.setOnAction(event -> printAttendeeList());
		
		btnPrintHotel = new Button("Udprint hotel beboerliste");
		printPane.add(btnPrintHotel, 0, 2);
		btnPrintHotel.setOnAction(event -> printHotelList());
		
		btnPrintFieldTrip = new Button("Udprint Udflugts deltagerliste");
		printPane.add(btnPrintFieldTrip, 0, 3);
		btnPrintFieldTrip.setOnAction(event -> printFieldTripAttendeeList());
		
		
		
}
	private void printAttendeeList() {
		if (conferenceList.getSelectionModel().getSelectedItem() != null) {
		Service.printConferenceList(conferenceList.getSelectionModel().getSelectedItem());
		} else {
			alarm = new Alert(AlertType.WARNING);

            alarm.setTitle("Ingen konference valgt");
            alarm.setHeaderText("");
            alarm.setContentText("Du har ikke valgt en konferrence.");

            alarm.showAndWait();
		}
	}
	private void printHotelList() {
		if (conferenceList.getSelectionModel().getSelectedItem() != null) {
		Service.printHotelList(conferenceList.getSelectionModel().getSelectedItem());
		} else {
			alarm = new Alert(AlertType.WARNING);

            alarm.setTitle("Ingen konference valgt");
            alarm.setHeaderText("");
            alarm.setContentText("Du har ikke valgt en konferrence.");

            alarm.showAndWait();
		}
	}
	private void printFieldTripAttendeeList() {
		if (conferenceList.getSelectionModel().getSelectedItem() != null) {
		Service.printListFieldTrip(conferenceList.getSelectionModel().getSelectedItem());
		} else {
			alarm = new Alert(AlertType.WARNING);

            alarm.setTitle("Ingen konference valgt");
            alarm.setHeaderText("");
            alarm.setContentText("Du har ikke valgt en konferrence.");

            alarm.showAndWait();
		}
	}
}
