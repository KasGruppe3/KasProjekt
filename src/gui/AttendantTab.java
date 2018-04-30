package gui;

import javafx.scene.control.TextField;
import application.Attendant;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class AttendantTab extends Tab {
	

    public AttendantTab() {
        super("Vælg deltager");

        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        setContent(pane);
        
        Label attendantListLabel = new Label("Hoteller");
		pane.add(attendantListLabel, 0, 0);
		
		ListView<Attendant> attendantList = new ListView<Attendant>();
		pane.add(attendantList, 0, 1);
		
		Label nameLabel = new Label("Navn:");
		pane.add(nameLabel, 1, 1);
		
		TextField txfName = new TextField();
        txfName = new TextField();
        txfName.setEditable(true);
        pane.add(txfName, 2, 1);
		
        Label addressLabel = new Label("Adresse:");
		pane.add(addressLabel, 1, 2);
		
		TextField txfAddress = new TextField();
		txfAddress = new TextField();
		txfAddress.setEditable(true);
        pane.add(txfAddress, 2, 2);
        
        Label tlfLabel = new Label("Tlf:");
		pane.add(tlfLabel, 1, 3);
		
		TextField txfCountryCode = new TextField();
		txfCountryCode = new TextField();
		txfCountryCode.setEditable(true);
        txfCountryCode.setMaxWidth(50.0);
		pane.add(txfCountryCode, 2, 3);
        
        TextField txfTlfNummer = new TextField();
        txfTlfNummer = new TextField();
        txfTlfNummer.setEditable(true);
        pane.add(txfTlfNummer, 3, 3);
        
        Label companyLabel = new Label("Firma:");
		pane.add(companyLabel, 1, 4);
		
		TextField txfCompany = new TextField();
		txfCompany = new TextField();
		txfCompany.setEditable(true);
        pane.add(txfCompany, 2, 4);
    }
}
