package gui;

import javafx.scene.control.TextField;
import application.Extra;
import application.Hotel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.GridPane;


public class HotelTab extends Tab {

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
		
		
		ListView<Hotel> hotelList = new ListView<Hotel>();
		pane.add(hotelList, 0, 1);
		hotelList	.setMinHeight(80);
		
		Label hotelExtrasLabel = new Label("Ekstra tilvalg");
		pane.add(hotelExtrasLabel, 1, 0);
		
		ListView<Extra> hotelExtras = new ListView<Extra>();
		pane.add(hotelExtras, 1, 1);
		hotelExtras.setMaxHeight(40);
		
		
		Label hotelPriceLabel = new Label("Samlet pris for hotel:");
		pane.add(hotelPriceLabel, 1, 2);
		
		TextField txfHotelPrice = new TextField("0");
		pane.add(txfHotelPrice, 1, 3);
		txfHotelPrice.setEditable(false);
		
		Button btnAccept = new Button("Godkend valg");
		pane.add(btnAccept, 1, 4);
		
		Label txfConfirmationText = new Label();
		pane.add(txfConfirmationText, 1, 5);
		txfConfirmationText.setVisible(false);
	}
	
	

}
