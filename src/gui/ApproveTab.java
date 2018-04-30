package gui;

import java.util.Hashtable;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class ApproveTab extends KASBaseTab {

    private AttendantTab attendant;
    private ConferrenceTab conference;
    private HotelTab hotel;
    private CompanionTab companion;
    private Label lblAttendant;
    private Label lblConference;
    private Label lblHotel;
    private Label lblCompanion;

    public ApproveTab(AttendantTab attendant, ConferrenceTab conference, HotelTab hotel, CompanionTab companion) {
        super("Godkendt valg");
        this.attendant = attendant;
        this.conference = conference;
        this.hotel = hotel;
        this.companion = companion;

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

        selectedProperty().addListener((ov, oldTab, newTab) -> {
            updateData();
        });
    }

    private void updateData() {
        // Show attendant info
        lblAttendant.setText(attendant.getAttendantInfo());

        // Show conference info
        lblConference.setText(conference.getConferenceInfo());

        // Show hotel info
        lblHotel.setText(hotel.getHotelInfo());

        // Show companion info
        lblCompanion.setText(companion.getCompanionInfo());
    }
}
