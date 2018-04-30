package gui;

import application.Extra;
import application.Hotel;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;


public class HotelTab extends Tab {

	private ListView<Hotel> hotelList = new ListView<Hotel>();
	ListView<Extra> hotelExtras = new ListView<Extra>();
	



	public HotelTab()
	{
		super ("Hotel");
		GridPane pane = new GridPane();

		setContent(pane);
		setClosable(false);

		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		Label hotelListLabel = new Label("Hoteller:");
		pane.add(hotelListLabel, 0, 0);


		
		pane.add(hotelList, 0, 1);
//		hotelList.getItems().setAll(new Hotel("Lol", "Lal", 20, 30), new Hotel("Lols", "Ldal", 50, 100), new Hotel("Lols", "Ldal", 60, 140));

		ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> this.updateExtras();
		hotelList.getSelectionModel().selectedItemProperty().addListener(listener);



		Label hotelExtrasLabel = new Label("Ekstra tilvalg");
		pane.add(hotelExtrasLabel, 1, 0);


		pane.add(hotelExtras, 1, 1);
		hotelExtras.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}

	private void updateExtras() {
		Hotel hotel = hotelList.getSelectionModel().getSelectedItem();
		hotelExtras.getItems().setAll(hotel.getExtras());
	}

}
