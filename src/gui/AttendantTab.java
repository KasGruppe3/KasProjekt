package gui;

import javafx.scene.control.TextField;

import java.util.Hashtable;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class AttendantTab extends Tab {

    private TextField txfName;
    private TextField txfAddress;
    private TextField txfCountryCode;
    private TextField txfTlfNummer;
    private TextField txfCompany;

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

        txfName = new TextField();
        txfName.setEditable(true);
        pane.add(txfName, 1, 0);

        Label addressLabel = new Label("Adresse:");
        pane.add(addressLabel, 0, 1);

        txfAddress = new TextField();
        txfAddress.setEditable(true);
        pane.add(txfAddress, 1, 1);

        GridPane tlfPane = new GridPane();
        pane.add(tlfPane, 1, 2);

        Label tlfLabel = new Label("Tlf:");
        pane.add(tlfLabel, 0, 2);

        txfCountryCode = new TextField();
        txfCountryCode.setEditable(true);
        txfCountryCode.setMaxWidth(50.0);
        tlfPane.add(txfCountryCode, 1, 0);

        txfTlfNummer = new TextField();
        txfTlfNummer.setEditable(true);
        tlfPane.add(txfTlfNummer, 2, 0);

        Label companyLabel = new Label("Firma:");
        pane.add(companyLabel, 0, 3);

        txfCompany = new TextField();
        txfCompany.setEditable(true);
        pane.add(txfCompany, 1, 3);
    }

    public String getAttendantInfo() {
        String info = "Navn: " + txfName.getText() + "\n";
        info += "Adresse: " + txfAddress.getText() + "\n";
        info += "Tlf. Nummer: +" + txfCountryCode.getText() + " " + txfTlfNummer.getText() + "\n";
        info += "Firma: " + txfCompany.getText() + "\n";
        return info;
    }
}
