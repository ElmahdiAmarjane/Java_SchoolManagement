package controllers;

import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ProfesseurDashboardController {
	
	
	@FXML
	private AnchorPane mainPane;
	
	@FXML
	 private HBox chatMenuBtn ;
	
	@FXML
	 private HBox studentMenuBtn ;
	@FXML
	 private HBox profMenuBtn ;
	
	@FXML
	 private AnchorPane professorPane ;
	
	@FXML
	 private AnchorPane classromMainPane ;
	
	@FXML
	 private AnchorPane studentPane ;
	
	@FXML
	 private AnchorPane absencePane ;
	
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
	
	@FXML 
	 private HBox  emploiTempsMenu;
	
	@FXML
	  private AnchorPane emploiTempsPane;
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
	
	
	//////ADD STUDENT/////
	 @FXML
	 private AnchorPane addStudentFin;
	 @FXML
	 private AnchorPane addStudentDocs;
	 @FXML
	 private AnchorPane addStudentInfoAcad;
	 @FXML
	 private AnchorPane addStudentInfoPers;
	 @FXML
	 private Button btnNext;
	 @FXML
	 private Button btnBack;
     //////ADD PROF/////
	 @FXML
	 private AnchorPane addProfFin;
	 @FXML
	 private AnchorPane addProfDocs;
	 @FXML
	 private AnchorPane addProfInfoAcad;
	 @FXML
	 private AnchorPane addProfInfoPers;
	 @FXML
	 private Button addProfBtnNext;
	 @FXML
	 private Button addProfBtnBack;
	 
	 
	 
	 
	 
	 
	 
	 
	 //////////////////////
	///////////
	 

	 
	 
	 //////////
	 @FXML
	 private AnchorPane studentNavMenu1;
	 @FXML
	 private AnchorPane studentNavMenu2;
	 
	 @FXML
	 private ImageView viewImageProfile;

	 @FXML 
	 private HBox filliereMenu;
	 @FXML
	 private ScrollPane filliereScrollPane;
	 
	 @FXML
	  private AnchorPane fillieresMainPane;
	 	 
	 @FXML
	 private AnchorPane filliereDetailsAnchorPane;
	 @FXML AnchorPane filliereListAnchorPane;
	 
	 ////////
	 @FXML AnchorPane annoncesMainPane;
	 
	 
	@FXML
	 public void absencePaneToFront() {
		
		absencePane.toFront();
	}
	@FXML
	public void professorPaneToFront() {
		professorPane.toFront();
		
	}

	@FXML
	public void studentPaneToFront() {
		studentPane.toFront();
		//initialize();
		
	}
	
	@FXML
	public void chatPaneToFront() {
		chatPane.toFront();
		
	}
	@FXML
	public void addStudentPaneToFront() {
		addStudentPane.toFront();	
		studentNavMenu2.toFront();
		//updateLinePosition(addStudentPane);
	}
	@FXML
	public void coursToFront() {
		classromMainPane.toFront();
	}
	@FXML
	public void listStudentPaneToFront() {
		listStudentPane.toFront();
		studentNavMenu1.toFront();
		//updateLinePosition(listStudentPane);
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
	
	@FXML
	  public void emploiTempsPaneToFront() {
		emploiTempsPane.toFront();
	}
	
	
	
	
	////////////////////////////
	// i add this part to fix chat problem label dont initalize
	 private ChatController chatController; // Reference to the ChatController

	    public void initialize() {
	        // Initialize the chatController from the included chat2.fxml
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chat2.fxml"));
	        try {
	            Parent chatRoot = loader.load();
	            chatController = loader.getController();
	            // Add chat root to the chatPane
	            chatPane.getChildren().setAll(chatRoot);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public ChatController getChatController() {
	        return chatController;
	    }
	

	
	
	

	
	/////////////////////////////////////////////////////////////////////
	
public void switchToFrontBetweenAddProfPane() {
		
		System.out.println("LASTPANE : "+addProfPane.getChildren().getLast().getId());
		if("addProfInfoPers".equals(addProfPane.getChildren().getLast().getId())  ) {
			addProfInfoAcad.toFront();
		}
		else if("addProfInfoAcad".equals(addProfPane.getChildren().getLast().getId())) {
			addProfDocs.toFront();
		}else if("addProfDocs".equals(addProfPane.getChildren().getLast().getId()) ) {
			addProfFin.toFront();
		}else if("addProfFin".equals(addProfPane.getChildren().getLast().getId())) {
			System.out.println("NO NEXT!");
		}
		   
	}
	public void switchToBackBetweenAddProfPane() {
		
		System.out.println("LASTPANE : "+addProfPane.getChildren().getLast().getId());
		if("addProfInfoPers".equals(addProfPane.getChildren().getLast().getId()) ) {
			System.out.println("NO BACK!");
		}
		else if("addProfInfoAcad".equals(addProfPane.getChildren().getLast().getId())) {
			addProfInfoPers.toFront();
		}else if("addProfDocs".equals(addProfPane.getChildren().getLast().getId())) {
			addProfInfoAcad.toFront();
		}else if("addProfFin".equals(addProfPane.getChildren().getLast().getId())) {
			addProfDocs.toFront();
		}
		   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	////////////////////////////////
	

	
	/////////////////////////////////
	
	/*
	public void filliereMenuOnclick() {
		 // Bring the main pane to the front
	    fillieresMainPane.toFront();

	    // Schedule getFilliers() to run after the UI update
	    Platform.runLater(() -> {
	        try {
	            getFilliers();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    });
	    
	    // i use runLater because i want make fillierePANE tofront befor loading filliers
		
	}
	
*/

	/*
    public void getFilliers() throws Exception {
        FilliereWidgetController loader = new FilliereWidgetController();

        Pane widget1 = loader.loadFilliereWidget("Nom de la Filière 1", "NF1", new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png"));
        Pane widget2 = loader.loadFilliereWidget("Nom de la Filière 2", "NF2", new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/chat.png"));
        Pane widget3 = loader.loadFilliereWidget("Nom de la Filière 3", "NF3", new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/annonce.png"));
        Pane widget4 = loader.loadFilliereWidget("Nom de la Filière 4", "NF4", new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/profile1.png"));
        Pane widget5 = loader.loadFilliereWidget("Nom de la Filière 5", "NF5", new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/fillieres.png"));
        Pane widget6 = loader.loadFilliereWidget("Nom de la Filière 6", "NF6", new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png"));
        Pane widget7 = loader.loadFilliereWidget("Nom de la Filière 7", "NF7", new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png"));
        Pane widget8 = loader.loadFilliereWidget("Nom de la Filière 8", "NF8", new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png"));
        Pane widget9 = loader.loadFilliereWidget("Nom de la Filière 9", "NF9", new Image("https://via.placeholder.com/220"));

        // Initialize GridPane
        GridPane gridPane = (GridPane) filliereScrollPane.getContent();
    //    gridPane.setAlignment(Pos.CENTER);
    //    gridPane.setHgap(10);
    //    gridPane.setVgap(10);
     //   gridPane.setPadding(new Insets(10));

        // Define row and column constraints
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();

        for (int i = 0; i < 2; i++) { // 2 columns
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.ALWAYS);
            col.setPercentWidth(50);
            gridPane.getColumnConstraints().add(col);
        }

        for (int i = 0; i < 5; i++) { // 5 rows
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.ALWAYS);
            row.setPercentHeight(35);
            gridPane.getRowConstraints().add(row);
        }

        // Add widgets to GridPane
        gridPane.add(widget1, 0, 0);
        gridPane.add(widget2, 1, 0);
        gridPane.add(widget3, 0, 1);
        gridPane.add(widget4, 1, 1);
        gridPane.add(widget5, 0, 2);
        gridPane.add(widget6, 1, 2);
        gridPane.add(widget7, 0, 3);
        gridPane.add(widget8, 1, 3);
        gridPane.add(widget9, 0, 4);

        // Center each widget
        GridPane.setHalignment(widget1, HPos.CENTER);
        GridPane.setValignment(widget1, VPos.CENTER);
        // Repeat for all other widgets...
        GridPane.setHalignment(widget2, HPos.CENTER);
        GridPane.setValignment(widget2, VPos.CENTER);

        GridPane.setHalignment(widget3, HPos.CENTER);
        GridPane.setValignment(widget3, VPos.CENTER);

        GridPane.setHalignment(widget4, HPos.CENTER);
        GridPane.setValignment(widget4, VPos.CENTER);

        GridPane.setHalignment(widget5, HPos.CENTER);
        GridPane.setValignment(widget5, VPos.CENTER);

        GridPane.setHalignment(widget6, HPos.CENTER);
        GridPane.setValignment(widget6, VPos.CENTER);

        GridPane.setHalignment(widget7, HPos.CENTER);
        GridPane.setValignment(widget7, VPos.CENTER);

        GridPane.setHalignment(widget8, HPos.CENTER);
        GridPane.setValignment(widget8, VPos.CENTER);

        GridPane.setHalignment(widget9, HPos.CENTER);
        GridPane.setValignment(widget9, VPos.CENTER);
    }

    
    public void setFilliereDetailsToFront() {
    	filliereDetailsAnchorPane.toFront();  	
    }
    
    public void setFilliereListToFront() {
    	filliereListAnchorPane.toFront();
    }
    
    
    */
	
	
	
	
	
	
	
	
	
	
	 public void filliereMenuOnclick() {
		 // Bring the main pane to the front
	    fillieresMainPane.toFront();

	}
	 
	public void  annoncesMenuOnclick() {
		annoncesMainPane.toFront();
	}
	
}