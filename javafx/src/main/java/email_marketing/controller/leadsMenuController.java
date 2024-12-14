package email_marketing.controller;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import email_marketing.database.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class leadsMenuController implements Initializable {

    @FXML
    private AnchorPane ExelAddLeadPane;

    @FXML
    private AnchorPane PersoAddLeadPane;
    
    @FXML
    private Button addBtn;
    
	@FXML
    private Button annule;

    @FXML
    private ToggleGroup leadAdd;

    @FXML
    private RadioButton leadExelRadioBtn;

    @FXML
    private RadioButton leadPersoRadioBtn;

    @FXML
    private StackPane rootPane;
    
    @FXML
    private Button chooseFileLeadBtn;
    @FXML
    
    private TextField exelLeadFileURL;

    public void annule() {
    	Stage stage = (Stage)annule.getScene().getWindow();
        stage.close();
	}
    public void getTypeLeadAdd() {
    	if(leadExelRadioBtn.isSelected()) {
    		ExelAddLeadPane.setVisible(true);
    		PersoAddLeadPane.setVisible(false);
    	}else if(leadPersoRadioBtn.isSelected()) {
    		ExelAddLeadPane.setVisible(false);
    		PersoAddLeadPane.setVisible(true);
    	}
    }
    
    @FXML
    void handleChooseFile() {
        FileChooser fileChooser = new FileChooser();
        
        fileChooser.getExtensionFilters().addAll(
        		new FileChooser.ExtensionFilter("CSV Files", "*.csv"),
        		new FileChooser.ExtensionFilter("Exel Files", "*.xlsx")
        );
        
        File selectedFile = fileChooser.showOpenDialog(chooseFileLeadBtn.getScene().getWindow());
        
        if (selectedFile != null) {
        	exelLeadFileURL.setText(selectedFile.getAbsolutePath());
        }
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
