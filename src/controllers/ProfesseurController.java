package controllers;

import java.io.File;
import java.util.List;
import dao.ElementDao;
import dao.FilierDao;
import dao.ProfesseurDao;
import dao.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import modules.Element;
import modules.Filier;
import modules.Professeur;
import modules.User;

public class ProfesseurController {
	
	Professeur professeur=new Professeur();
	ProfesseurDao professeurDao=new ProfesseurDao();
	ElementDao elementDao = new ElementDao();
	UserDao userDao=new UserDao();
	User user=new User();
	
	private String imageCv;
	private String imageCni;
	private String imageProfile;
	private List<Element> elements;
	 
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

	 @FXML
		private AnchorPane addProfPane ; 
		@FXML
		private AnchorPane listProfPane ; 
		
		@FXML
		private Text addProfBtn;
		
		@FXML 
		 private Text listProfBtn;
		@FXML
		private TableColumn<?, ?> colNumber;

		@FXML
		private TableColumn<?, ?> colCIN;

		@FXML
		private TableColumn<?, ?> colNom;

		@FXML
		private TableColumn<?, ?> colPrenom;

		@FXML
		private TableColumn<?, ?> colFilliere;

		@FXML
		private TableColumn<?, ?> colCNE;

		@FXML
		private TableView<?> studentsTable; 
	
	
		 @FXML
		 private Button btnChooseFileCIN,chooseProfileImageBtn,btnChooseCv;
		 @FXML
		 private TextField nom, prenom, cni, tel,email,adresse,password,rip,etablissement,mention_doctorat,type_doctorat;
		 @FXML
		 private ComboBox<String> Matiere_enseigne,sexe,nationalite,type_contrat;
		 @FXML
		 private DatePicker date_naissance;


		
		 
		public void initialisCombpBox() {
			sexe.getItems().addAll("Male", "Female");
	  	    nationalite.getItems().addAll("Moroccan", "Other");
	  	    type_contrat.getItems().addAll("CDI", "ANAPEC");
	  	  
	  	    try {
	  	    	elements=elementDao.selectAllElemnt();
	  	    	
	  	    	for(Element elem:elements) {
	  	    		Matiere_enseigne.getItems().add(elem.getNom());
	  	    	}
	  	    }catch(Exception e) {
	  	    	System.out.println(e);
	  	    }
		}
		
	    public void initialize() {
	    	 colNumber.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.15));
	  	    colCIN.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.15));
	  	    colNom.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.2));
	  	    colPrenom.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.2));
	  	    colFilliere.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.15));
	  	    colCNE.prefWidthProperty().bind(studentsTable.widthProperty().multiply(0.15));
	  	    
	  	    cni.textProperty().addListener((observal,oledvaleu,newvale)->{
	    		password.setText(newvale);
	    	});
	  	  
	  	    initialisCombpBox();
	  	    
	  	    
	    }
	
	public void enregistrerBtn() {
		
		try {
			
			user.setNom(nom.getText());
			user.setPrenom(prenom.getText());
			user.setCni(cni.getText());
			user.setRole("Professeur");
			user.setSexe(sexe.getValue());
			user.setDateNaissance(date_naissance.getValue());
			user.setEmail(email.getText());
			user.setTel(tel.getText());
			user.setAdress(adresse.getText());
			user.setNationalite(nationalite.getValue());
			user.setPassword(password.getText());
			user.setImage(imageProfile);
			
			if(userDao.insertUser(user)) {
				
				int ripval= Integer.parseInt(rip.getText());
				
				//professeur.getDoctorant_type(type_doctorat.getText());
				professeur.setMatiere_enseigne(mention_doctorat.getText());
				professeur.setEtablissement(etablissement.getText());
				professeur.setMatiere_enseigne(Matiere_enseigne.getValue());
				professeur.setType_contrat(type_contrat.getValue());
				professeur.setRip(ripval);
				
				professeurDao.insertProfesseur(professeur);
			}
			
			
			
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	public void addProfPaneToFront() {
			
	}
	public void listProfPaneToFront() {
		
	}
	
	@FXML
	public void chooseFileCIN() {
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Select an Image");
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
	    );

	    File selectedFile = fileChooser.showOpenDialog(btnChooseFileCIN.getScene().getWindow());
	    if (selectedFile != null) {
	    	imageCni = selectedFile.getAbsolutePath();
	    	btnChooseFileCIN.setText("Image Selected");
	    	btnChooseFileCIN.setText(selectedFile.getName());
	    	btnChooseFileCIN.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    } else {
	        // Handle the case where no file was selected (Optional)
	    	btnChooseFileCIN.setText("Select Image");
	    }
	}
	
	@FXML
	public void chooseFileCv() {
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Select an Image");
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
	    );

	    File selectedFile = fileChooser.showOpenDialog(btnChooseCv.getScene().getWindow());
	    if (selectedFile != null) {
	    	imageCv = selectedFile.getAbsolutePath();
	    	btnChooseCv.setText("Image Selected");
	    	btnChooseCv.setText(selectedFile.getName());
	    	btnChooseCv.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    } else {
	    	btnChooseCv.setText("Select Image");
	    }
	}

	@FXML
	public void chooseProfileImage() {
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Select an Image");
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
	    );

	    File selectedFile = fileChooser.showOpenDialog(chooseProfileImageBtn.getScene().getWindow());
	    if (selectedFile != null) {
	    	imageProfile = selectedFile.getAbsolutePath();
	    	chooseProfileImageBtn.setText("Image Selected");
	    	chooseProfileImageBtn.setText(selectedFile.getName());
	    	chooseProfileImageBtn.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    } else {
	    	chooseProfileImageBtn.setText("Select Image");
	    }
	}

	
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
	

	
	
}