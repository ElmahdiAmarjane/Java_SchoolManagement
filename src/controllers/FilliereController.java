package controllers;

import java.util.ArrayList;
import java.util.List;

import dao.FilierDao;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import modules.Filier;

public class FilliereController {
	
	private FilierDao filierDao = new FilierDao() ;
	private Filier filier;
	private  List<Filier> filiers;

    @FXML
    private ScrollPane filliereScrollPane;  // Ensure this ScrollPane is referenced correctly
    @FXML
    private AnchorPane fillieresMainPane;
    @FXML
    private AnchorPane filliereDetailsAnchorPane;
    @FXML
    private AnchorPane filliereListAnchorPane;
    @FXML
    private AnchorPane fillereAddAnchorPane;
    
    //////////ADD FILLIERE //////////
    @FXML
    private TextField filliereNameTF;
    @FXML
    private TextField filliereShortNameTF;
    
    
    
    
    
    ///////////////////////////
@FXML
public void initialize() {
    if (filliereScrollPane != null) {
        // Create and configure the GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Add widgets to the GridPane
        addWidgetsToGridPane(gridPane);

        // Wrap GridPane in a VBox (to prevent sizing issues)
        VBox container = new VBox(gridPane);
        container.setPadding(new Insets(10));
        ////////////////

        // Set the container as ScrollPane content
        filliereScrollPane.setContent(container);

        // Configure ScrollPane
        filliereScrollPane.setFitToWidth(true);
        filliereScrollPane.setPannable(true);
    } else {
        System.out.println("ScrollPane filliere is not initialized");
    }
}

private void addWidgetsToGridPane(GridPane gridPane) {
    FilliereWidgetController loader = new FilliereWidgetController();
    try {
        int col = 0, row = 0;
        filiers = new ArrayList<>();

        filiers = filierDao.selectAllFilier();
        if (!filiers.isEmpty()) {
            for (Filier filier : filiers) {
                Pane widget1 = loader.loadFilliereWidget(
                    filier.getTitel(),
                    filier.getShortName(),
                    new Image("file:C:/Users/lenovo/eclipse-workspace/java_project/Java_SchoolManagement/assets/logoibnzohr.png")
                );

                // Add the widget to the gridPane
                gridPane.add(widget1, col++, row);

                // Center the widget in the grid
                GridPane.setHalignment(widget1, HPos.CENTER);
                GridPane.setValignment(widget1, VPos.CENTER);


                // Adjust column and row indices
                if (col == 2) { // Assuming 2 widgets per row
                    col = 0;
                    row++;
                }
            }
        }

        // Set a fixed height for each row
        for (int i = 0; i <= row; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPrefHeight(150); // Set fixed height for rows
            rowConstraints.setVgrow(Priority.NEVER); // Prevent resizing
            gridPane.getRowConstraints().add(rowConstraints);
        }
     // Set a fixed width for each column
        for (int i = 0; i <= col; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPrefWidth(900); // Set fixed width for columns
            columnConstraints.setHgrow(Priority.NEVER); // Prevent resizing
            gridPane.getColumnConstraints().add(columnConstraints);
        }


    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void saveFilliereToDB() {
    
    	try {
    		String Fname = filliereNameTF.getText();
        	String FShortName=filliereShortNameTF.getText();
        	filier = new Filier();
        	filier.setTitel(Fname);
        	filier.setShortName(FShortName);
        	
    		if(filierDao.addFilier(filier)) {
    			 Alert alert = new Alert(AlertType.INFORMATION);
    			    alert.setTitle("Insertion Successful");
    			    alert.setHeaderText(null);
    			    alert.setContentText("The data has been inserted successfully!");
    			    alert.showAndWait(); // Displays the alert and waits for user interaction
    		}
    		
    		
    	}catch(Exception e) {
    		System.out.println("add filiere exception!!!");
    		e.printStackTrace();
    	}
    
    }

    public void setFilliereDetailsToFront() {
        filliereDetailsAnchorPane.toFront();
    }
    public void setFillereAddAnchorPaneToFront(){
    	fillereAddAnchorPane.toFront();
    }

    public void setFilliereListToFront() {
        filliereListAnchorPane.toFront();
        initialize();
    }
}
