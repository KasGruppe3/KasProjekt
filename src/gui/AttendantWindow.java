package gui;

import java.util.Hashtable;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;
import javafx.scene.control.TabPane;

public class AttendantWindow extends Stage {

    // Contains the different panes
    private AttendantTab attendant = new AttendantTab();
    private ConferrenceTab conference = new ConferrenceTab();
    private HotelTab hotel = new HotelTab();
    private CompanionTab companion = new CompanionTab();

    public AttendantWindow(String title, Stage owner) {
        initOwner(owner);
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setMinHeight(100);
        setMinWidth(200);
        setResizable(false);

        setTitle("Attending a conferrence");
        TabPane pane = new TabPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);

    }

    private void initContent(TabPane pane) {
        pane.getTabs().add(attendant);
        pane.getTabs().add(conference);
        pane.getTabs().add(hotel);
        pane.getTabs().add(companion);
        pane.getTabs().add(new ApproveTab(attendant, conference, hotel, companion));
    }

}
