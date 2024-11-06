package controllers;

import java.util.function.Predicate;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class adminController {
	
	
	@FXML
	 private HBox chatMenuBtn ;
	
	@FXML
	 private HBox studentMenuBtn ;
	@FXML
	 private HBox profMenuBtn ;
	
	@FXML
	 private AnchorPane professorPane ;
	@FXML
	 private AnchorPane studentPane ;
	@FXML
	 private AnchorPane chatPane ;
	
	@FXML
	private AnchorPane addStudentPane ; 
	@FXML
	private AnchorPane listStudentPane ; 
	
	@FXML
	private Text addStudentBtn;
	
	@FXML 
	 private Text listStudentBtn;
	
	@FXML
	private AnchorPane addProfPane ; 
	@FXML
	private AnchorPane listProfPane ; 
	
	@FXML
	private Text addProfBtn;
	
	@FXML 
	 private Text listProfBtn;
	// TABLE STUDENT 
	
	@FXML
	private TreeTableColumn<?, ?> colNumber;

	@FXML
	private TreeTableColumn<?, ?> colCIN;

	@FXML
	private TreeTableColumn<?, ?> colNom;

	@FXML
	private TreeTableColumn<?, ?> colPrenom;

	@FXML
	private TreeTableColumn<?, ?> colFilliere;

	@FXML
	private TreeTableColumn<?, ?> colCNE;

	@FXML
	private TreeTableView<?> studentsTable; // Assuming you also have the TreeTableView defined in FXML

	
	@FXML
	private AnchorPane studentNavMenu ;
	//FIN TABLE STUDENT
	private Line line1;
	
	@FXML
	public void professorPaneToFront() {
		professorPane.toFront();
		
	}

	@FXML
	public void studentPaneToFront() {
		studentPane.toFront();
		initialize();
		
	}
	
	@FXML
	public void chatPaneToFront() {
		chatPane.toFront();
		
	}
	@FXML
	public void addStudentPaneToFront() {
		addStudentPane.toFront();	
		updateLinePosition(addStudentPane);
	}
	@FXML
	public void listStudentPaneToFront() {
		listStudentPane.toFront();
		updateLinePosition(listStudentPane);
	}
	
	@FXML
	public void addProfPaneToFront() {
		addProfPane.toFront();
	    studentNavMenu.getChildren().removeLast();

		
	}
	@FXML
	public void listProfPaneToFront() {
		listProfPane.toFront();
	    studentNavMenu.getChildren().removeLast();
		
	};
	
	public void initialize() {
	    colNumber.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.15));
	    colCIN.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.15));
	    colNom.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.2));
	    colPrenom.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.2));
	    colFilliere.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.15));
	    colCNE.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.15));
	    
	    line1 = new Line();
	    // Set line color and width
	    line1.setStroke(Color.WHITE); // Set line color
	    line1.setStrokeWidth(3);     // Set line width
	    studentNavMenu.getChildren().add(line1);
	    
//just to initialize the line for first time
	    updateLinePosition(listStudentPane);
	}
	
	public void updateLinePosition(AnchorPane activePane) {
		if(activePane == addStudentPane) {
			 line1.setStartX(190); // Starting X position of the line
			    line1.setStartY(40); // Starting Y position of the line
			    line1.setEndX(305);  // Ending X position of the line
			    line1.setEndY(40);   // Ending Y position of the line (same as start to make it horizontal)  
			
		}
		else if(activePane == listStudentPane) {
			 // Set line properties
		    line1.setStartX(50); // Starting X position of the line
		    line1.setStartY(40); // Starting Y position of the line
		    line1.setEndX(150);  // Ending X position of the line
		    line1.setEndY(40);   // Ending Y position of the line (same as start to make it horizontal)  
			
		}
	}
	
	
	
}
