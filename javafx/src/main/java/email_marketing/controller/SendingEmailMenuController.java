package email_marketing.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SendingEmailMenuController implements Initializable {
	
	@FXML
    private StackPane rootPane;
    @FXML
    private Button annule;
    public void annule() {
    	Stage stage = (Stage)annule.getScene().getWindow();
        stage.close();
	}

    
    private double xOffset = 0;
	private double yOffset = 0;
	 public void initialize(URL location, ResourceBundle resources) {
		 rootPane.setOnMousePressed(event -> {
	            xOffset = event.getSceneX();
	            yOffset = event.getSceneY();
	        });

	        rootPane.setOnMouseDragged(event -> {
	            Stage stage = (Stage) rootPane.getScene().getWindow();
	            stage.setX(event.getScreenX() - xOffset);
	            stage.setY(event.getScreenY() - yOffset);
	        });
	    	
	    }
}
