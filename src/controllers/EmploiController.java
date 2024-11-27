package controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class EmploiController {

	
	
	 @FXML
	 private Pane emploiTempsProfBtn;
	 @FXML
	 private AnchorPane emploiTempsProfGrid;
	 
	 @FXML
	 private Pane emploiTempsFilliereBtn;
	 @FXML
	 private AnchorPane emploiTempsFilliereGrid;
	 @FXML
	 private ImageView goBackToMainEmploiTempsBtn;
	 @FXML
	 private AnchorPane emploisChoose;
	
	
	
	
	
	public void saveEmploi() {
		
	}
	
	
	
	
	public void emploiTempsProfGridToFront(){
		emploiTempsProfGrid.toFront();
		
		goBackToMainEmploiTempsBtn.setVisible(true);
	}
	
	
	public void emploiTempsFilliereGridToFront() {
		System.out.print("fffffffffffffffffffffffffffff");
		emploiTempsFilliereGrid.toFront();
		
		goBackToMainEmploiTempsBtn.setVisible(true);
	}
	
	
	public void goBackToMainEmploiTemps() {
		emploisChoose.toFront();
		
		goBackToMainEmploiTempsBtn.setVisible(false);
	}
	
}
