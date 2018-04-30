package gui;

import application.Service;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class HotelCreateTab extends KASBaseTab {

    private TextField fieldName;
    private TextField fieldAddress;
    private TextField fieldSingle;
    private TextField fieldDouble;

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

        // Ok knap
        Button btn = new Button("Ok");
        btn.setFont(Font.font("Arial", 16));
        btn.setOnAction(event -> buttonOk());
        pane.add(btn, 1, 4);

        createMessageField(pane, 1, 5, 2);
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

        Service.createHotel(name, address, priceSingle, priceDouble);
        showInformation("Hotel oprettet!");
    }
}
