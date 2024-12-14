package email_marketing.controller;

import java.net.URL;
import java.util.ResourceBundle;

import email_marketing.model.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class AddCompagnController implements Initializable{
	@FXML
    private Button addFlowUp;

    @FXML
    private Button annule, next , back;

    @FXML
    private StackPane rootPane;

    @FXML
    private AnchorPane template;

    @FXML
    private AnchorPane templatesField, templatesSection, leadsSection;
    
    private int templateCount = 1;
    
    @FXML
    private Circle step1, step2, step3;
    private int stepCounter = 1;
    @FXML
    void switchStep(ActionEvent event) {
    	if(event.getSource() == next && stepCounter < 3) {
    		stepCounter +=1;
    		stepColorModifier(stepCounter);
    	}else if(event.getSource() == back && stepCounter > 1) {
    		stepCounter -=1;
    		stepColorModifier(stepCounter);
    	}
    }
    void stepColorModifier(int step) {
    	switch(step) {
    	  case 1:
    		  step1.setFill(Color.YELLOW);
    		  step2.setFill(Color.TRANSPARENT);
    		  step3.setFill(Color.TRANSPARENT);
    		  templatesSection.setVisible(true);
    		  leadsSection.setVisible(false);
    	    break;
    	  case 2:
    		  step1.setFill(Color.TRANSPARENT);
    		  step2.setFill(Color.YELLOW);
    		  step3.setFill(Color.TRANSPARENT);
    		  
    		  templatesSection.setVisible(false);
    		  leadsSection.setVisible(true);
    	    break;
		  case 3:
			  step1.setFill(Color.TRANSPARENT);
    		  step2.setFill(Color.TRANSPARENT);
    		  step3.setFill(Color.YELLOW);
    		  
    		  templatesSection.setVisible(false);
    		  leadsSection.setVisible(false);
	  	    break;
    	  default:
    		  break;
    	}
    }
    
    @FXML
    private void addFlowUp() {
        AnchorPane newTemplate = new AnchorPane();
        newTemplate.setPrefSize(600, 280);
        newTemplate.setLayoutX(35); 
        newTemplate.setLayoutY(templateCount * 280); 
        newTemplate.getStyleClass().add("template");

        TextField subjectField = new TextField();
        subjectField.setLayoutX(101);
        subjectField.setLayoutY(14);
        subjectField.setPrefSize(200, 30);
        subjectField.setPromptText("Subject line");
        subjectField.setId("subjectField");
        
        TextArea bodyField = new TextArea();
        bodyField.setLayoutX(101);
        bodyField.setLayoutY(49);
        bodyField.setPrefSize(400, 150);
        bodyField.setPromptText("Body");

        Label delayLabel = new Label("Delay:");
        delayLabel.setLayoutX(101);
        delayLabel.setLayoutY(210);

        TextField delayField = new TextField();
        delayField.setLayoutX(150);
        delayField.setLayoutY(205);
        delayField.setPrefSize(80, 30);
        delayField.setPromptText("Seconds");
        delayField.setId("delayField");

        Button deleteButton = new Button("Delete");
        deleteButton.setLayoutX(520); 
        deleteButton.setLayoutY(14);
        deleteButton.getStyleClass().add("primary_btn");

        deleteButton.setOnAction(event -> {
            templatesField.getChildren().remove(newTemplate); 
            rearrangeTemplates(); 
        });

        newTemplate.getChildren().addAll(subjectField, bodyField, delayLabel, delayField, deleteButton);

        templatesField.getChildren().add(newTemplate);

        templateCount++;
    }

    private void rearrangeTemplates() {
        int index = 0;
        for (javafx.scene.Node child : templatesField.getChildren()) {
            if (child instanceof AnchorPane) {
                child.setLayoutY(index * 280); 
                index++;
            }
        }
        templateCount = index; 
    }
    

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
