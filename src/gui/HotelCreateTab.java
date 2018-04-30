package gui;

import application.Service;

import java.util.ArrayList;
import application.Extra;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class HotelCreateTab extends KASBaseTab {

    private TextField fieldName;
    private TextField fieldAddress;
    private TextField fieldSingle;
    private TextField fieldDouble;
	private TextField fieldExtraName;
	private TextField fieldPrice;
	private TextField fieldDescription;
	private ListView<Extra> extraList = new ListView<Extra>();
	private ArrayList<Extra> extras = new ArrayList<Extra>();

    public HotelCreateTab() {
        super("Opret Hotel");

        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(50);
        pane.setVgap(10);
        setContent(pane);

        fieldName = addTextField(pane, 0, 0, "Navn");
        fieldAddress = addTextField(pane, 0, 1, "Adresse");
        fieldSingle = addTextField(pane, 0, 2, "Enkelt værelse pris");
        fieldDouble = addTextField(pane, 0, 3, "Dobbelt værelse pris");

        Label empty = new Label();
        pane.add(empty, 0, 4);
        
        
        Label fieldExtra = new Label("Tilføj ekstra");
        pane.add(fieldExtra, 0, 5);
        
        Label listOfExtra = new Label("Liste over ekstra");
        pane.add(listOfExtra, 0, 10);
        
        fieldExtraName = addTextField(pane, 0, 6, "Navn");
        fieldPrice = addTextField(pane, 0, 7, "Pris");
        fieldDescription = addTextField(pane, 0, 8, "Beskrivelse");
        
        Button addExtra = new Button("Tilføj ekstra");
        pane.add(addExtra, 1, 9);
        addExtra.setOnAction(event -> addExtraToList());
        
        pane.add(extraList, 1, 10,1,3);
        extraList.setMaxHeight(60);
        
        // Ok knap
        Button btn = new Button("Ok");
        btn.setFont(Font.font("Arial", 16));
        btn.setOnAction(event -> buttonOk());
        pane.add(btn, 1, 13);

        createMessageField(pane, 1, 14, 2);
    }

    private void addExtraToList() {
    	Extra extra = new Extra(fieldExtraName.getText().trim(), Double.parseDouble(fieldPrice.getText().trim()), fieldDescription.getText().trim());
    	extras.add(extra);
    	extraList.getItems().setAll(extras);
    	this.fieldExtraName.setText(null);
    	this.fieldPrice.setText(null);
    	this.fieldDescription.setText(null);
    }
    
    private void buttonOk() {
        String name = fieldName.getText();
        if (name.isEmpty()) {
            showError("Angiv et navn");
            return;
        }

        String address = fieldAddress.getText();
        if (address.isEmpty()) {
            showError("Angiv en adresse");
            return;
        }

        double priceSingle, priceDouble;
        try {
            priceSingle = Double.parseDouble(fieldSingle.getText());
            priceDouble = Double.parseDouble(fieldDouble.getText());
        } catch (NumberFormatException nfe) {
            showError("En af dine priser er ugyldige");
            return;
        }

        Service.createHotel(name, address, priceSingle, priceDouble).addExtras(extras);
        
        
        showInformation("Hotel oprettet!");
    }
}
