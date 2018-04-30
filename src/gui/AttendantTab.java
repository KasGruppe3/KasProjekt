package gui;

import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
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
        setClosable(false);
		
		Label nameLabel = new Label("Navn:");
		pane.add(nameLabel, 0, 0);
		
		TextField txfName = new TextField();
        txfName = new TextField();
        txfName.setEditable(true);
        pane.add(txfName, 1, 0);
		
        Label addressLabel = new Label("Adresse:");
		pane.add(addressLabel, 0, 1);
		
		TextField txfAddress = new TextField();
		txfAddress = new TextField();
		txfAddress.setEditable(true);
        pane.add(txfAddress, 1, 1);
        
        GridPane tlfPane = new GridPane();
        pane.add(tlfPane, 1, 2);
        
        Label tlfLabel = new Label("Tlf:");
		pane.add(tlfLabel, 0, 2);
		
		TextField txfCountryCode = new TextField();
		txfCountryCode = new TextField();
		txfCountryCode.setEditable(true);
        txfCountryCode.setMaxWidth(50.0);
		tlfPane.add(txfCountryCode, 1, 0);
        
        TextField txfTlfNummer = new TextField();
        txfTlfNummer = new TextField();
        txfTlfNummer.setEditable(true);
        tlfPane.add(txfTlfNummer, 2, 0);
        
        Label companyLabel = new Label("Firma:");
		pane.add(companyLabel, 0, 3);
		
		TextField txfCompany = new TextField();
		txfCompany = new TextField();
		txfCompany.setEditable(true);
        pane.add(txfCompany, 1, 3);
    }
}
