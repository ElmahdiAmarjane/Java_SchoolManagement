package controllers;

import java.io.File;
import java.util.function.Predicate;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class adminController {
	
	
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
	}
	
	
	public void emploiTempsFilliereGridToFront() {
		System.out.print("fffffffffffffffffffffffffffff");
		emploiTempsFilliereGrid.toFront();
	}
	
	
	
	
	
	
	
	
}
