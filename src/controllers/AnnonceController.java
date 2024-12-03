package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.AnnonceDao;
import dao.FilierDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modules.Annonce;
import modules.Filier;

public class AnnonceController {
	
	@FXML
    private Pane annoncesMainPane;

	
	private AnnonceDao annonceDao = new AnnonceDao() ;
	private Annonce annonce;
	private  List<Annonce> annonces;

	private String annonceFilePath;
	private int idAnnonce;

	////////////////////
	@FXML private ScrollPane annoncesScrollPane;
	@FXML private AnchorPane annoncesListAnchorPane;
	@FXML private AnchorPane annoncesAddAnchorPane;
	/////////////////////
	@FXML private TextArea AnnonceTextArea;
	@FXML private TextField annonceTitleTF ;
	@FXML private Button annonceSubmitButton;
	@FXML private Button annonceCancelButton;
	@FXML private Button uploadAnnonceFichierButton;
	@FXML private Label annonceFileNameLabel;
	////////////////////
	@FXML private TextArea AnnonceTextAreaDetails;
	@FXML private TextField annonceTitleTFDetails ;
	@FXML private Button uploadAnnonceFichierButtonDetails;
	@FXML private Label annonceFileNameLabelDetails;
	@FXML private Button  deleteAnnonceBtn;
	@FXML private Button updateAnnonceBtn;
	//////////////
	@FXML private Text titleAnnonceToModify;
	
	 public void initialize() {
		 
		 
	     if (annoncesScrollPane != null) {
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
	         annoncesScrollPane.setContent(container);

	         // Configure ScrollPane
	         annoncesScrollPane.setFitToWidth(true);
	         annoncesScrollPane.setPannable(true);
	         
	         System.out.print("hello form initis");
	     } else {
	         System.out.println("ScrollPane is not initialized");
	       
	     }
	 }
	 
	 
	 public void saveAnnonceToDB() {
		    
	    	try {
	    		String title = annonceTitleTF.getText();
	        	String text =AnnonceTextArea.getText();
	        	annonce = new Annonce();
	        	annonce.setTitle(title);
	        	annonce.setContenu(text);
	        	annonce.setFile(annonceFilePath);
	        	
	    		if(annonceDao.addAnnonce(annonce)) {
	    			
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
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

	 public void setAnnoncesListToFront() {
		 initialize();
		 annoncesListAnchorPane.toFront();
	 }
	
	 public void setAnnonceAddAnchorPaneToFront() {
		 annoncesAddAnchorPane.toFront();
		 
	 }
	 
	 public void setAnnonceDetailsData(Annonce annonceData) {
		   AnnonceTextAreaDetails.setText(annonceData.getContenu());
			annonceTitleTFDetails.setText(annonceData.getTitle());
			titleAnnonceToModify.setText("Modifier l'annonce: " + annonceData.getTitle());
			idAnnonce = annonceData.getId();
		
	 }
	
	 
	 @FXML
	 public void selectAnnonceFile() {
	     FileChooser fileChooser = new FileChooser();
	     fileChooser.setTitle("Select a file");

	     // Show the file chooser dialog
	     File selectedFile = fileChooser.showOpenDialog(uploadAnnonceFichierButton.getScene().getWindow());
	     if (selectedFile != null) {
	         annonceFilePath = selectedFile.getAbsolutePath();
	         uploadAnnonceFichierButton.setText("File Selected");
	         annonceFileNameLabel.setText(selectedFile.getName());
	         uploadAnnonceFichierButton.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	     } else {
	         // Handle the case where no file was selected (Optional)
	         uploadAnnonceFichierButton.setText("Select File");
	     }
	 }

	 private Stage stage;

	    public void setDetailsAnnonceStage(Stage stage) {
	        this.stage = stage;
	    }

	    public void closeStage() {
	    	
	        if (stage != null) {
	            stage.close();
	        }
	    }
	    
	    private void addWidgetsToGridPane(GridPane gridPane) {
	        try {
	            int col = 0, row = 0;
	            annonces = annonceDao.selectAllAnnonce();

	            if (!annonces.isEmpty()) {
	                for (Annonce annonce : annonces) {
	                    // Load the widget FXML
	                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/annoncesWidget.fxml"));
	                    Pane widget = loader.load();

	                    // Get the widget's controller
	                    AnnonceWidgetController widgetController = loader.getController();
	                    widget = widgetController.loadAnnonceWidget(
	                   		  annonce.getTitle(), annonce.getContenu(),
	                   		  annonce.getDateAnnonce().toString(), String.valueOf(annonce.getId()) );
	                    // Pass the main controller instance to the widget controller
	                    AnnonceWidgetController.setMainController(this);
	                    // Add the widget to the grid
	                    gridPane.add(widget, col, row++);

	                    // Center the widget in the grid
	                    GridPane.setHalignment(widget, HPos.CENTER);
	                    GridPane.setValignment(widget, VPos.CENTER);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteAnnonce() throws IOException {
	        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Confirm Delete");
	        alert.setHeaderText("Are you sure you want to delete this announcement?");
	        alert.setContentText("This action cannot be undone.");

	        Optional<ButtonType> result = alert.showAndWait();

	        if (result.isPresent() && result.get() == ButtonType.OK) {
	        	annonceDao.deleteAnnonce(idAnnonce);
	            closeStage();
	        } else {
	            System.out.println("Delete canceled!");
	        }
	        
	        selectAnnonceFile();
	    }
	    
	    public void updateAnnonce() throws IOException {
	        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Confirm update");
	        alert.setHeaderText("Are you sure you want to update this announcement?");
	        alert.setContentText("This action cannot be undone.");

	        Optional<ButtonType> result = alert.showAndWait();

	        annonce = new Annonce();
	        annonce.setTitle(annonceTitleTFDetails.getText());
	        annonce.setContenu(AnnonceTextAreaDetails.getText());
	        annonce.setId(idAnnonce);
	        annonce.setFile(annonceFilePath);
	        
	        if (result.isPresent() && result.get() == ButtonType.OK) {
	            // Delete the annonce from the database
	            annonceDao.updateAnnonce(annonce);

	            closeStage();
	            annonceDao.selectAllAnnonce();
	         
	        } else {
	            System.out.println("upate canceled!");
	        }
	    }
	    
	    
	    public void annulerAnnonceDetails() {
	    	 closeStage();
	    }
	    
	    public void refrechAnnoncesWidgets() {
	    	initialize();
	    }


}