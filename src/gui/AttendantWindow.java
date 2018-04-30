package gui;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TabPane;

public class AttendantWindow extends Stage{

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
	        pane.getTabs().add(new AttendantTab());
	        pane.getTabs().add(new ConferrenceTab());
	        pane.getTabs().add(new HotelTab());
	        pane.getTabs().add(new CompanioinTab());
	        pane.getTabs().add(new ApproveTab());
	    }

	}
