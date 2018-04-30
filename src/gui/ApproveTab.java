package gui;

import application.Attendant;
import application.Companion;
import application.Conference;
import application.FieldTrip;
import application.Hotel;
import application.RegistrationForm;
import application.Service;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ApproveTab extends KASBaseTab {

    private AttendantTab attendantTab;
    private ConferrenceTab conferenceTab;
    private HotelTab hotelTab;
    private CompanionTab companionTab;
    private Label lblAttendant;
    private Label lblConference;
    private Label lblHotel;
    private Label lblCompanion;

    public ApproveTab(AttendantTab attendant, ConferrenceTab conference, HotelTab hotel, CompanionTab companion) {
        super("Godkendt valg");
        this.attendantTab = attendant;
        this.conferenceTab = conference;
        this.hotelTab = hotel;
        this.companionTab = companion;

        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        setContent(pane);

        lblAttendant = addLabel(pane, 0, 0, "Deltager");
        lblConference = addLabel(pane, 0, 1, "Konference");
        lblHotel = addLabel(pane, 0, 2, "Hotel");
        lblCompanion = addLabel(pane, 0, 3, "Ledsager");

        Button btn = new Button("Ok");
        btn.setFont(Font.font("Arial", 16));
        btn.setOnAction(event -> buttonApprove());
        pane.add(btn, 1, 5);

        createMessageField(pane, 1, 6, 1);

        selectedProperty().addListener((ov, oldTab, newTab) -> {
            updateData();
        });
    }

    private void updateData() {
        // Show attendant info
        lblAttendant.setText(attendantTab.getAttendantInfo());

        // Show conference info
        lblConference.setText(conferenceTab.getConferenceInfo());

        // Show hotel info
        lblHotel.setText(hotelTab.getHotelInfo());

        // Show companion info
        lblCompanion.setText(companionTab.getCompanionInfo());
    }

    private void buttonApprove() {
        // Approve all the data on the tabs
        Attendant attendant = attendantTab.approve();
        if (attendant == null) {
            showError("Deltager info er ikke gyldig");
            return;
        }

        Conference conf = conferenceTab.approve();
        if (conf == null) {
            showError("Vælg en konference!");
            return;
        }

        Hotel hotel = hotelTab.approve();
        String companionName = companionTab.approve();

        // Create the registration form
        RegistrationForm rf = Service.createRegistrationForm(conf, conferenceTab.getArrivalDate(),
                conferenceTab.getLeavingDate(), conferenceTab.isSpeaker(), conferenceTab.getComment(), attendant, hotel,
                hotelTab.getExtras());

        // Create the companion and add it to the selected fieldtrips
        Companion companion = rf.createCompanion(companionName);
        for (FieldTrip ft : companionTab.getFieldTrips()) {
            ft.addCompanion(companion);
        }

        Alert alarm = new Alert(AlertType.INFORMATION);
        alarm.setTitle("Registrering oprettet!");
        alarm.setHeaderText("");
        alarm.setContentText("Din registrering til konferencen er accepteret.");
        alarm.showAndWait();

        Stage s = (Stage) getTabPane().getScene().getWindow();
        s.close();
    }
}
