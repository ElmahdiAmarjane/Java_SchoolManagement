package controllers;

import java.io.File;
import java.util.function.Predicate;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
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

public class AdminController {
	
	
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
	
	
	///////////
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
	///////////
	 
	 @FXML
	 private ImageView profileViewImage;
	///////////
	 @FXML
	 private Button btnChooseFileCIN;
	 @FXML
	 private Button btnChooseFileBac;
	 @FXML
	 private Button btnChooseFileNoteBac;
	 @FXML
	 private Button btnChooseFileBac2;
	 @FXML
	 private Button btnChooseFileNoteBac2;
	 
	 
	 //////////
	 @FXML
	 private AnchorPane studentNavMenu1;
	 @FXML
	 private AnchorPane studentNavMenu2;
	 
	 //////////
	 @FXML
	 private ImageView viewImageProfile;
	 
	 
	 ///////////
	 @FXML
	 private Pane emploiTempsProfBtn;
	 @FXML
	 private AnchorPane emploiTempsProfGrid;
	 
	 @FXML
	 private Pane emploiTempsFilliereBtn;
	 @FXML
	 private AnchorPane emploiTempsFilliereGrid;
	 
	 /////////////////
	 
	 @FXML
	 private ImageView goBackToMainEmploiTempsBtn;
	 @FXML
	 private AnchorPane emploisChoose;
	 
	 //////////////////////
	 @FXML 
	 private HBox filliereMenu;
	 @FXML
	 private ScrollPane filliereScrollPane;
	 
	 @FXML
	  private AnchorPane fillieresMainPane;
	 
	 ////////////////////
	 
	 
	 
	 
	 
	 
	 //////////
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
		studentNavMenu2.toFront();
		//updateLinePosition(addStudentPane);
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
	
	public void initialize() {
	    colNumber.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.15));
	    colCIN.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.15));
	    colNom.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.2));
	    colPrenom.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.2));
	    colFilliere.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.15));
	    colCNE.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.15));
	    
	    /// set imageprofile rounded 
	    // Load the image
        Image image = new Image("https://img.freepik.com/vecteurs-libre/cercle-bleu-utilisateur-blanc_78370-4707.jpg?semt=ais_hybrid");
        viewImageProfile.setImage(image);

        // Set the size of the ImageView
        viewImageProfile.setFitWidth(40);
        viewImageProfile.setFitHeight(40);
        viewImageProfile.setPreserveRatio(true);

        // Apply a circular clip
        Circle clip = new Circle(20,20,20); // Adjust radius as needed
        viewImageProfile.setClip(clip);
	  
        //////////////////////
        
	}
	
	
	
	
	public void switchToFrontBetweenAddStudentsPane() {
		
		System.out.println("LASTPANE : "+addStudentPane.getChildren().getLast().getId());
		if("addStudentInfoPers".equals(addStudentPane.getChildren().getLast().getId())  ) {
			addStudentInfoAcad.toFront();
		}
		else if("addStudentInfoAcad".equals(addStudentPane.getChildren().getLast().getId())) {
			addStudentDocs.toFront();
		}else if("addStudentDocs".equals(addStudentPane.getChildren().getLast().getId()) ) {
			addStudentFin.toFront();
		}else if("addStudentFin".equals(addStudentPane.getChildren().getLast().getId())) {
			System.out.println("NO NEXT!");
		}
		   
	}
	public void switchToBackBetweenAddStudentsPane() {
		
		System.out.println("LASTPANE : "+addStudentPane.getChildren().getLast().getId());
		if("addStudentInfoPers".equals(addStudentPane.getChildren().getLast().getId()) ) {
			System.out.println("NO BACK!");
		}
		else if("addStudentInfoAcad".equals(addStudentPane.getChildren().getLast().getId())) {
			addStudentInfoPers.toFront();
		}else if("addStudentDocs".equals(addStudentPane.getChildren().getLast().getId())) {
			addStudentInfoAcad.toFront();
		}else if("addStudentFin".equals(addStudentPane.getChildren().getLast().getId())) {
			addStudentDocs.toFront();
		}
		   
	}
	
	public void chooseProfileImage() {
		 FileChooser fileChooser = new FileChooser();
		    fileChooser.getExtensionFilters().addAll(
		        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
		    );

		    File selectedFile = fileChooser.showOpenDialog(mainPane.getScene().getWindow());

		    if (selectedFile != null) {
		        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		        Image image = new Image(selectedFile.toURI().toString());
		        profileViewImage.setImage(image);
		    } else {
		        System.out.println("No file selected.");
		    }
		    

	}
	
	public void chooseFileCIN() {
		 FileChooser fileChooser = new FileChooser();
		    fileChooser.getExtensionFilters().addAll(
		        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg","*.pdf")
		    );

		    File selectedFile = fileChooser.showOpenDialog(mainPane.getScene().getWindow());

		    if (selectedFile != null) {
		        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		        btnChooseFileCIN.setText(selectedFile.getName());
		        btnChooseFileCIN.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
		    } else {
		        System.out.println("No file selected.");
		        btnChooseFileCIN.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
		    }
	}
	public void chooseFileBac() {
		 FileChooser fileChooser = new FileChooser();
		    fileChooser.getExtensionFilters().addAll(
		        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg","*.pdf")
		    );

		    File selectedFile = fileChooser.showOpenDialog(mainPane.getScene().getWindow());

		    if (selectedFile != null) {
		        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		        btnChooseFileBac.setText(selectedFile.getName());
		        btnChooseFileBac.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
		    } else {
		        System.out.println("No file selected.");
		        btnChooseFileBac.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
		    }
	}
	public void chooseFileNoteBac() {
		 FileChooser fileChooser = new FileChooser();
		    fileChooser.getExtensionFilters().addAll(
		        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg","*.pdf")
		    );

		    File selectedFile = fileChooser.showOpenDialog(mainPane.getScene().getWindow());

		    if (selectedFile != null) {
		        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		        btnChooseFileNoteBac.setText(selectedFile.getName());
		        btnChooseFileNoteBac.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
		    } else {
		        System.out.println("No file selected.");
		        btnChooseFileNoteBac.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
		    }
	}
	public void chooseFileBac2() {
		 FileChooser fileChooser = new FileChooser();
		    fileChooser.getExtensionFilters().addAll(
		        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg","*.pdf")
		    );

		    File selectedFile = fileChooser.showOpenDialog(mainPane.getScene().getWindow());

		    if (selectedFile != null) {
		        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		        btnChooseFileBac2.setText(selectedFile.getName());
		        btnChooseFileBac2.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
		    } else {
		        System.out.println("No file selected.");
		        btnChooseFileBac2.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
		    }
	}
	public void chooseFileNoteBac2() {
		 FileChooser fileChooser = new FileChooser();
		    fileChooser.getExtensionFilters().addAll(
		        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg","*.pdf")
		    );

		    File selectedFile = fileChooser.showOpenDialog(mainPane.getScene().getWindow());

		    if (selectedFile != null) {
		        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		        btnChooseFileNoteBac2.setText(selectedFile.getName());
		        btnChooseFileNoteBac2.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
		    } else {
		        System.out.println("No file selected.");
		        btnChooseFileNoteBac2.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
		    }
	}
	
	
	
	////////////////////////////////
	
	public void emploiTempsProfGridToFront(){
		emploiTempsProfGrid.toFront();
		
		goBackToMainEmploiTempsBtn.setVisible(true);
	}
	
	
	public void emploiTempsFilliereGridToFront() {
		System.out.print("fffffffffffffffffffffffffffff");
		emploiTempsFilliereGrid.toFront();
		
		goBackToMainEmploiTempsBtn.setVisible(true);
	}
	
	
	/////////////////////////////////
	public void goBackToMainEmploiTemps() {
		emploisChoose.toFront();
		
		goBackToMainEmploiTempsBtn.setVisible(false);
	}
	
	public void filliereMenuOnclick() {
		fillieresMainPane.toFront();
		
		try {
			getFilliers99();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    public void getFilliers() throws Exception {
		FilliereWidgetController loader = new FilliereWidgetController();
		
		 Pane widget1 = loader.loadFilliereWidget(
			        "Nom de la Filière 1",
			        "NF1",
			        new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png")
			    );

			    Pane widget2 = loader.loadFilliereWidget(
			        "Nom de la Filière 2",
			        "NF2",
			        new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png")
			    );

			    Pane widget3 = loader.loadFilliereWidget(
			        "Nom de la Filière 3",
			        "NF3",
			        new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png")
			    );

			    // Get the GridPane content from the ScrollPane
			    GridPane gridPane = (GridPane) filliereScrollPane.getContent();
                gridPane.setAlignment(Pos.CENTER);
                // Center the widgets inside their cells
                GridPane.setHalignment(widget1, HPos.CENTER);
                GridPane.setValignment(widget1, VPos.CENTER);
                GridPane.setHalignment(widget2, HPos.CENTER);
                GridPane.setValignment(widget2, VPos.CENTER);
                GridPane.setHalignment(widget3, HPos.CENTER);
                GridPane.setValignment(widget3, VPos.CENTER);
			    // Add widgets to the GridPane
			    gridPane.add(widget1, 0, 0); // Column 0, Row 0
			    gridPane.add(widget2, 1, 0); // Column 1, Row 0
			    gridPane.add(widget3, 0, 1); // Column 0, Row 1
	}
	
	
    public void getFilliers9() throws Exception {
        FilliereWidgetController loader = new FilliereWidgetController();

        // Create widgets for 9 filières
        Pane widget1 = loader.loadFilliereWidget(
            "Nom de la Filière 1",
            "NF1",
            new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png")
        );

        Pane widget2 = loader.loadFilliereWidget(
            "Nom de la Filière 2",
            "NF2",
            new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png")
        );

        Pane widget3 = loader.loadFilliereWidget(
            "Nom de la Filière 3",
            "NF3",
            new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png")
        );

        Pane widget4 = loader.loadFilliereWidget(
            "Nom de la Filière 4",
            "NF4",
            new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png")
        );

        Pane widget5 = loader.loadFilliereWidget(
            "Nom de la Filière 5",
            "NF5",
            new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png")
        );

        Pane widget6 = loader.loadFilliereWidget(
            "Nom de la Filière 6",
            "NF6",
            new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png")
        );

        Pane widget7 = loader.loadFilliereWidget(
            "Nom de la Filière 7",
            "NF7",
            new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png")
        );

        Pane widget8 = loader.loadFilliereWidget(
            "Nom de la Filière 8",
            "NF8",
            new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png")
        );
        
        Pane widget9 = loader.loadFilliereWidget(
            "Nom de la Filière 9",
            "NF9",
            new Image("file:C:/Users/lenovo/eclipse-workspace/schoolManagement/assets/logoibnzohr.png")
        );
        
        

        // Get the GridPane content from the ScrollPane
        GridPane gridPane = (GridPane) filliereScrollPane.getContent();
        gridPane.setAlignment(Pos.CENTER);

        // Add widgets to the GridPane
        gridPane.add(widget1, 0, 0); // Column 0, Row 0
        gridPane.add(widget2, 1, 0); // Column 1, Row 0
        gridPane.add(widget3, 0, 1); // Column 2, Row 0

        gridPane.add(widget4, 1, 1); // Column 0, Row 1
        gridPane.add(widget5, 0, 2); // Column 1, Row 1
        gridPane.add(widget6, 1, 2); // Column 2, Row 1

        gridPane.add(widget7, 0, 3); // Column 0, Row 2
        gridPane.add(widget8, 1, 3); // Column 1, Row 2
        gridPane.add(widget9, 0, 4); // Column 2, Row 2

        // Center each widget inside its cell
        GridPane.setHalignment(widget1, HPos.CENTER);
        GridPane.setValignment(widget1, VPos.CENTER);

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

	
    public void getFilliers99() throws Exception {
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

	
}
