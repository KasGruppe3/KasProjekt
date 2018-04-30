package gui;

import java.util.ArrayList;

import application.Extra;
import application.Hotel;
import application.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class HotelTab extends Tab {

    private ListView<Hotel> hotelList = new ListView<>();
    ListView<Extra> hotelExtras = new ListView<>();

    public HotelTab() {

        super("Hotel");
        GridPane pane = new GridPane();

        setContent(pane);
        setClosable(false);

        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label hotelListLabel = new Label("Hoteller:");
        pane.add(hotelListLabel, 0, 0);

        hotelList.getItems().setAll(Service.getHotels());

        pane.add(hotelList, 0, 1);

        ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> updateExtras();
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

    public String getHotelInfo() {
        Hotel hotel = hotelList.getSelectionModel().getSelectedItem();
        if (hotel == null) {
            return "";
        }

        String info = "Navn: " + hotel.getName() + "\n";
        info += "Adresse: " + hotel.getAddress() + "\n";
        info += "Enkeltværelse pris: " + hotel.getPriceSingle() + "\n";
        info += "Dobbeltværelse pris: " + hotel.getPriceDouble();
        return info;
    }

    public ArrayList<Extra> getExtras() {
        return new ArrayList<>(hotelExtras.getSelectionModel().getSelectedItems());
    }

    public Hotel approve() {
        return hotelList.getSelectionModel().getSelectedItem();
    }
}
