package gui;

import application.Service;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sun.font.CreatedFontTracker;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {
	    public static void main(String[] args) {
	        Application.launch(args);
	    }

	    @Override
	    public void start(Stage stage) {
	        stage.setTitle("KAS");
	        GridPane pane = new GridPane();
	        initContent(pane);
	        Scene scene = new Scene(pane);
	        stage.setScene(scene);
	        stage.setResizable(false);
	        stage.show();
	    }

	    private Button btnAttending;
	    private Button btnAdmin;
	    private Button btnCancel;
	    private Button btnHelp;
	    private Alert alarm;
	    
	    private AttendantWindow attendantWindow;
		private AdminWindow adminWindow;
	    // -------------------------------------------------------------------------

	    private void initContent(GridPane pane) {
	    	pane.setGridLinesVisible(false);
	    	pane.setPadding(new Insets(10));
	    	pane.setHgap(10);
	    	pane.setVgap(10);
	    	
	    GridPane frontPage = new GridPane();
        pane.add(frontPage, 0, 0);
        frontPage.setGridLinesVisible(false);
        frontPage.setPadding(new Insets(10));
        frontPage.setHgap(10);
        frontPage.setVgap(10);
//        frontPage.setStyle("-fx-border-color: black");
        
	   
	        
	    btnAttending = new Button("Attending a conference?");
        frontPage.add(btnAttending, 1, 1);
        btnAttending.setPrefHeight(100);
        btnAttending.setPrefWidth(400);
        btnAttending.setFont(Font.font(null, FontWeight.BOLD, 25));
        btnAttending.setOnAction(event -> attendantAction());
        
        btnAdmin = new Button("Admin");
        frontPage.add(btnAdmin, 1, 2);
        btnAdmin.setPrefHeight(100);
        btnAdmin.setPrefWidth(400);
        btnAdmin.setFont(Font.font(null, FontWeight.BOLD, 25));
        btnAdmin.setOnAction(event -> adminAction);  // - tilføj action
        
        btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, 3);
        btnCancel.setOnAction(event -> closeWindow());
	    
	    
	    btnHelp = new Button("Help");
        pane.add(btnHelp, 0, 3);
        btnHelp.setOnAction(event -> helpWindow());
	    }

	
	    
	 // -----------------------------------------------------
		// Button actions

		private void attendantAction() {
			attendantWindow.show();
		}
		private void adminAction() {
			adminWindow.show();
		}
		public void closeWindow() {
		    System.exit(0);
		}
		
		public void helpWindow() {
			alarm = new Alert(AlertType.INFORMATION);

            alarm.setTitle("Help Window");
            alarm.setHeaderText("Press a button");
            alarm.setContentText("Press Attending a conferrence if you are attending a conference.\nOr Admin if you are part of the conferrence team.");

            alarm.showAndWait();

}
}