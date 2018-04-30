package gui;

import javafx.scene.control.TextField;

import application.Attendant;
import application.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class AttendantTab extends Tab {

    private TextField txfName;
    private TextField txfAddress;
    private TextField txfNumber;
    private TextField txfCompany;
    private ListView<Attendant> attendants = new ListView<>();

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
        pane.add(nameLabel, 0, 1);

        txfName = new TextField();
        txfName.setEditable(true);
        pane.add(txfName, 1, 1);

        Label addressLabel = new Label("Adresse:");
        pane.add(addressLabel, 0, 2);

        txfAddress = new TextField();
        txfAddress.setEditable(true);
        pane.add(txfAddress, 1, 2);

        Label tlfLabel = new Label("Tlf:");
        pane.add(tlfLabel, 0, 3);

        txfNumber = new TextField();
        txfNumber.setEditable(true);
        pane.add(txfNumber, 1, 3);

        Label companyLabel = new Label("Firma:");
        pane.add(companyLabel, 0, 4);

        txfCompany = new TextField();
        txfCompany.setEditable(true);
        pane.add(txfCompany, 1, 4);

        Label attendantList = new Label("Gemte deltagere");
        pane.add(attendantList, 2, 0);
        pane.add(attendants, 2, 1, 1, 5);

        ChangeListener<Attendant> listener = (ov, oldAttendant, newAttendant) -> PersonList();
        attendants.getSelectionModel().selectedItemProperty().addListener(listener);
        attendants.getItems().setAll(Service.getAttendants());
    }

    public String getAttendantInfo() {
        String info = "Navn: " + txfName.getText() + "\n";
        info += "Adresse: " + txfAddress.getText() + "\n";
        info += "Tlf. Nummer: +" + txfNumber.getText() + "\n";
        info += "Firma: " + txfCompany.getText() + "\n";
        return info;
    }

    /**
     * The entered info has been approved, so create an attendant
     *
     * @return the new attendant
     */
    public Attendant approve() {
        if (txfName.getText().isEmpty() || txfAddress.getText().isEmpty() || txfNumber.getText().isEmpty()) {
            return null;
        }

        return Service.createAttendant(txfName.getText(), txfAddress.getText(), "+" + txfNumber.getText(),
                txfCompany.getText());
    }

    private void PersonList() {
        Attendant attendant = attendants.getSelectionModel().getSelectedItem();
        this.txfName.setText(attendant.getName());
        this.txfAddress.setText(attendant.getAddress());
        this.txfNumber.setText(attendant.getTlfNumber());
        if (attendant.getCompany() != null) {
            this.txfCompany.setText(attendant.getCompany());
        }
    }
}
