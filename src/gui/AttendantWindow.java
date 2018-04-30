package gui;

import application.Attendant;
import application.Service;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sun.font.CreatedFontTracker;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
//	        pane.getTabs().add(new AttendantTab());
//	        pane.getTabs().add(new ConferrenceTab());
	        pane.getTabs().add(new HotelTab());
//	        pane.getTabs().add(new FieldTripTab());
//	        pane.getTabs().add(new ApproveTab());
	    }

	}
