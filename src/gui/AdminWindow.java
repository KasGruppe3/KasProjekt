package gui;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TabPane;

public class AdminWindow extends Stage {

    public AdminWindow(String title, Stage owner) {
        initOwner(owner);
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setMinHeight(100);
        setMinWidth(200);
        setResizable(false);

        setTitle("Arrangørens kontrolpanel");
        TabPane pane = new TabPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    private void initContent(TabPane pane) {
        pane.getTabs().add(new ConferenceCreateTab());
        pane.getTabs().add(new HotelCreateTab());
        pane.getTabs().add(new FieldTripCreateTab());
        pane.getTabs().add(new PrintListTab());
    }

}
