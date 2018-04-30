package gui;

import application.Hotel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HotelTab {

	public void start(Stage stage)
	{
		stage.setTitle("Hotel");
		GridPane pane = new GridPane();
		this.initContent(pane);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		
		Label hotelListLabel = new Label("Hoteller");
		pane.add(hotelListLabel, 0, 0);
		
		ListView<Hotel> hotelList = new ListView<Hotel>();
		pane.add(hotelList, 0, 1);
		
		
		
	}
	
	

}
