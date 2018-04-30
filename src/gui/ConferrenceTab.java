package gui;

import application.Conference;
import application.Hotel;
import application.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


	public class ConferrenceTab extends Tab {

		private ListView<Conference> conferenceList = new ListView<Conference>();
		
		private TextField txfName = new TextField();
		private TextField txfAddress = new TextField();
		private TextField txfPris = new TextField();
		TextField txfStartDate = new TextField();
		private TextField txfTimeSpan = new TextField();
		
		
	    public ConferrenceTab() {
	        super("Vælg konferrence");

	        GridPane pane = new GridPane();
	        pane.setGridLinesVisible(false);
	        pane.setPadding(new Insets(20));
	        pane.setHgap(10);
	        pane.setVgap(10);

	        setContent(pane);
	        
	        Label conferrenceListLabel = new Label("Konferrencer:");
			pane.add(conferrenceListLabel, 0, 0);
			
			
			pane.add(conferenceList, 0, 1,1,5);
			conferenceList.setMaxHeight(120);
			
			conferenceList.getItems().setAll(Service.getConferences());
			
			Label nameLabel = new Label("Navn:");
			pane.add(nameLabel, 1, 0);
			
			
	        txfName = new TextField();
	        txfName.setEditable(false);
	        pane.add(txfName, 2, 0);
	        
	        Label addressLabel = new Label("Adresse:");
			pane.add(addressLabel, 1, 1);
			
			
			txfAddress = new TextField();
			txfAddress.setEditable(false);
	        pane.add(txfAddress, 2, 1);
	        
	        Label priceLabel = new Label("Pris:");
			pane.add(priceLabel, 1, 2);
	        
	        
	        txfPris = new TextField();
	        txfPris.setEditable(false);
	        pane.add(txfPris, 2, 2);
	        
	        Label startDateLabel = new Label("Startdato:");
			pane.add(startDateLabel, 1, 3);
			
			
			txfStartDate = new TextField();
			txfStartDate.setEditable(false);
	        pane.add(txfStartDate, 2, 3);
	        
	        Label timeSpanLabel = new Label("Forløbstid:");
			pane.add(timeSpanLabel, 1, 4);
			
			
			txfTimeSpan = new TextField();
			txfTimeSpan.setEditable(false);
	        pane.add(txfTimeSpan, 2, 4);
	        
	        ChangeListener<Conference> listener = (ov, oldConferrence, newConferrence) -> this.UpdateTextFields();
	        conferenceList.getSelectionModel().selectedItemProperty().addListener(listener);
	    }
	    
	    public void UpdateTextFields() {
	    	Conference conference = conferenceList.getSelectionModel().getSelectedItem();
	    	this.txfName.setText(conference.getName());
	    	this.txfAddress.setText(conference.getLocation());
	    	this.txfPris.setText("" + conference.getPrice());
	    	this.txfStartDate.setText(conference.getDate().toString());
	    	this.txfTimeSpan.setText("" + conference.getTimeSpan());
	    }
	}