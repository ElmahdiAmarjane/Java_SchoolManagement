package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import modules.Course;
import modules.Element;
import modules.Filier;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import config.AppFunctions;
import dao.CourseDao;
import dao.ElementDao;
import dao.FilierDao;

public class ProfesseurClassromController {

	FilierDao filierDao=new FilierDao();
	ElementDao elementDao=new ElementDao();
	
	CourseDao courseDao=new CourseDao();
	Course cours=new Course();
	
	LocalDate localDate = LocalDate.now();
	
    @FXML
    private ComboBox<String> typeComboBox,comboBoxFiliere,comboBoxElement;

    @FXML
    private TextField titleField;

    @FXML
    private Label fileNameLabel;

    @FXML
    private HBox deadlineSection;

    @FXML
    private DatePicker deadlinePicker;

    @FXML
    private TextArea description;

    @FXML
    private TextField timeField;

    @FXML
    private ImageView filePreviewImage; // ImageView pour l'aperçu du fichier

    private File selectedFile;

    @FXML
    public void initialize() {
    	
        typeComboBox.setItems(FXCollections.observableArrayList("Cours", "TD/TP"));

        
        deadlinePicker.setValue(null);
        initializComboBox();
    }
    
    public void initializComboBox(){
    	
    	
    	try {
    		List<Element> elements=elementDao.selectAllElemnt();
    		
    		for(Element ele:elements) {
    			comboBoxElement.getItems().add(ele.getNom());
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	try {
    		List<Filier> filiers=filierDao.selectAllFilier();	
    		for(Filier filier:filiers) {
    			comboBoxFiliere.getItems().add(filier.getShortName());
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }

    @FXML
    private void handleBrowse() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            fileNameLabel.setText(selectedFile.getName());
            displayFilePreview(selectedFile);
        } else {
            fileNameLabel.setText("Aucun fichier sélectionné");
        }
    }
    
    private void displayFilePreview(File file) {
        String fileName = file.getName().toLowerCase();
        Image previewImage = null;

        String iconFolderPath = "resources" + File.separator + "icons"; 

        System.out.println("Icon folder path: " + iconFolderPath);

        if (fileName.endsWith(".pdf")) {
            previewImage = new Image("file:" + iconFolderPath + File.separator + "pdf.png");
        } else if (fileName.endsWith(".docx") || fileName.endsWith(".doc")) {
            previewImage = new Image("file:" + iconFolderPath + File.separator + "word icon.png");
        } else if (fileName.endsWith(".pptx") || fileName.endsWith(".ppt")) {
            previewImage = new Image("file:" + iconFolderPath + File.separator + ".png");
        } else if (fileName.endsWith(".txt")) {
            previewImage = new Image("file:" + iconFolderPath + File.separator + "txt-icon.png");
        } else if (fileName.endsWith(".png") || fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            previewImage = new Image(file.toURI().toString());
        } else {
            previewImage = new Image("file:" + iconFolderPath + File.separator + "default-file-icon.png");
        }

        if (previewImage != null) {
            filePreviewImage.setImage(previewImage);
        } else {
            System.out.println("Preview image could not be loaded for file: " + file.getName());
        }
    }



   

    



    @FXML
  
    public void handleUpload() {
    	if(comboBoxElement.getValue()==null || comboBoxFiliere.getValue()==null ||titleField.getText()==null || description.getText()==null) {
    		
   		 AppFunctions.showAlertError("Échec de l'insertion", "Il faut  remplir les champs obligatoires.");

    	}else {
    		
    		if(typeComboBox.getValue()=="TD/TP" && deadlinePicker.getValue()==null) {
    			
    			 AppFunctions.showAlertError("Échec de l'insertion", "Puisque vous avez sélectionné TD/TP, vous devez choisir une date limite de rendu.");

    			}else {
    				
    				try {
    		    		
    		    		cours.setTitle(titleField.getText());
    		  		    cours.setDescription(description.getText());
    		  		    
    		  		    if (selectedFile != null) {
    		              cours.setFiles(selectedFile.getAbsolutePath()); 
    		  		    } else {
    		              cours.setFiles(""); 
    		  		    }
    		  		    
    		  		    cours.setFilier_titel(comboBoxFiliere.getValue());
    		  		    cours.setElement_id(comboBoxElement.getValue());
    		  		    
    		  		    if (deadlinePicker != null) {
    		              cours.setDate_limit(deadlinePicker.getValue());  
    		  		    } else {
    		              cours.setDate_limit(null);  
    		  		    }
    		  		    
    		  		    cours.setType(typeComboBox.getValue());
    		  		    cours.setDatePublication(localDate);
    		  		    
    		  		    boolean isInsered=courseDao.insertCours(cours);
    		  		    if(isInsered) {
    		  		    	AppFunctions.showAlertSuccess("Insertion Réussie", "Supports a été insérée avec succès !");
    		  		    	handleCancel();
    		  		    }else {
    		  		    	AppFunctions.showAlertError("Échec de l'insertion", "Une erreur s'est produite lors de l'insertion de Supports. Veuillez réessayer.");
    		  		    }
    		    		
    		    	}catch(Exception e) {
    		    		System.out.println(e);
    		    	}
    			}
    	    	
    	}
    	
		
        
    	
    }




    @FXML
    public void handleCancel() {
        // Réinitialise les champs
        typeComboBox.setValue(null);
        titleField.clear();
        fileNameLabel.setText("Aucun fichier sélectionné");
        deadlinePicker.setValue(null);
        timeField.clear();
        description.setText("");
        filePreviewImage.setImage(null);
        selectedFile = null;
    }

}