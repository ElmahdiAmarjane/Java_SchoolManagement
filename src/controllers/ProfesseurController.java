package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import config.AppFunctions;
import dao.ElementDao;
import dao.FilierDao;
import dao.ProfesseurDao;
import dao.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import modules.Element;
import modules.Etudiant;
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
	private List<Professeur> listProfesseurs;
	 
	@FXML
    private Pane ProfesseurView;
	
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
		private TableColumn<Professeur, String> colNumber;

		@FXML
		private TableColumn<Professeur, String> colCIN;

		@FXML
		private TableColumn<Professeur, String> colNom;

		@FXML
		private TableColumn<Professeur, String> colPrenom;

		@FXML
		private TableColumn<Professeur, String> colMatiere_enseigne ;

		@FXML
		private TableColumn<Professeur, String> coltype_contrat;

		@FXML
		private TableView<Professeur> studentsTable;
		
		@FXML
		private TableColumn<Professeur, Void> icons; 
		
		@FXML
		private AnchorPane studentNavMenu;
	
	
		 @FXML
		 private Button btnChooseFileCIN,chooseProfileImageBtn,btnChooseCv;
		 @FXML
		 private TextField nom, prenom, cni, tel,email,adresse,password,rip,etablissement,mention_doctorat,type_doctorat;
		 @FXML
		 private ComboBox<String> Matiere_enseigne,sexe,nationalite,type_contrat;
		 @FXML
		 private DatePicker date_naissance;
////////////////////////
		 @FXML
		 private AnchorPane listProfMenu;
		 @FXML
		 private AnchorPane addProfMenu;
		
		 
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
		
		 private void addIconsToTable() {
		        icons.setCellFactory(param -> new TableCell<>() {
		            @Override
		            protected void updateItem(Void item, boolean empty) {
		                super.updateItem(item, empty);

		                if (empty) {
		                    setGraphic(null);
		                } else {
		                    // Create HBox for buttons
		                    HBox actionBox = new HBox(10);

		                    // Create buttons
		                    Button updateButton = new Button();
		                    Button deleteButton = new Button();
		                    Button downloadButton = new Button();

		                    // Create ImageView for icons
		                    ImageView deleteIcon = createImageView("/assets/delete_icon.png");
		                    ImageView downloadIcon = createImageView("/assets/upload_icon.png");
		                    ImageView updateIcon = createImageView("/assets/edit_icon.png");

		                    // Add ImageView to buttons
		                    updateButton.setGraphic(updateIcon);
		                    deleteButton.setGraphic(deleteIcon);
		                    downloadButton.setGraphic(downloadIcon);

		                    // Style buttons
		                    updateButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
		                    deleteButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
		                    downloadButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");

		                    // Add buttons to HBox
		                    actionBox.setStyle("-fx-alignment: CENTER;");
		                    actionBox.getChildren().addAll(updateButton, deleteButton, downloadButton);

		                    // Set the HBox as the graphic for the cell
		                    setGraphic(actionBox);
		                    
		                    Professeur rowData = getTableView().getItems().get(getIndex());  // Replace YourDataType with the type of your row data

		                    // Add button actions
		                    updateButton.setOnAction(event -> updateAction(rowData.getCni()));
		                    deleteButton.setOnAction(event -> deleteAction(rowData.getCni()));
		                    downloadButton.setOnAction(event -> downloadAction(getIndex()));
		                }
		            }
		        });
		    }
		 
		 // Helper method to create an ImageView
		    private ImageView createImageView(String resourcePath) {
		        ImageView imageView = new ImageView();
		        try {
		            Image image = new Image(getClass().getResourceAsStream(resourcePath));
		            imageView.setImage(image);
		            imageView.setFitWidth(16); // Set desired icon width
		            imageView.setFitHeight(16); // Set desired icon height
		            imageView.setPreserveRatio(true);
		        } catch (Exception e) {
		            System.err.println("Could not load image: " + resourcePath);
		        }
		        return imageView;
		    }


		    private void updateAction(String cni) {
		        try {
		            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/UpdateProfesseur.fxml"));
		            Pane nextPane = loader.load();

		            UpdateProfesseurController controller = loader.getController();
		            controller.setCniValue(cni); // This now calls customInitialize()

		            ProfesseurView.getChildren().clear();
		            ProfesseurView.getChildren().add(nextPane);
		        } catch (IOException e) {
		            System.err.println("Failed to load UpdateEtudiantInfo.fxml: " + e.getMessage());
		        }
		    }


		    private void deleteAction(String cni) {
		        // Create a confirmation alert
		        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		        alert.setTitle("Confirm Deletion");
		        alert.setHeaderText(null);
		        alert.setContentText("Are you sure you want to delete this user?");

		        alert.showAndWait().ifPresent(response -> {
		            if (response.getText().equals("OK")) {
		                try {
		                    userDao.deleteUser(cni);

		                    fetchProfesseur();
		                } catch (Exception e) {
		                    System.out.println("Error deleting user: " + e.getMessage());
		                }
		            }
		        });
		    }


		    private void downloadAction(int index) {
		        System.out.println("Download action triggered for row: " + index);
		    }
		    
		    public void fetchProfesseur() {
		        try {
		             listProfesseurs = professeurDao.selectAllProfesseur();

		            ObservableList<Professeur> professeurs = FXCollections.observableArrayList(listProfesseurs);
		            studentsTable.setItems(professeurs); // Set items to the table

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		    
	    public void initialize() {
	    	
	    	colNumber.setCellFactory(column -> new TableCell<>() {
	    	    @Override
	    	    protected void updateItem(String item, boolean empty) {
	    	        super.updateItem(item, empty);
	    	        if (empty) {
	    	            setText(null);
	    	        } else {
	    	            setText(String.valueOf(getIndex() + 1)); // Row index starts from 0, so add 1
	    	        }
	    	    }
	    	});
	    	addIconsToTable();
	    	// Set up TableView and TableColumn bindings
	        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
	        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
	        colCIN.setCellValueFactory(new PropertyValueFactory<>("cni"));
	        colMatiere_enseigne.setCellValueFactory(new PropertyValueFactory<>("Matiere_enseigne"));
	        coltype_contrat.setCellValueFactory(new PropertyValueFactory<>("type_contrat"));
	        
	        fetchProfesseur();
	  	    
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
    		user.setImageCni(imageCni);
    		
			if(userDao.insertUser(user)) {
				
				int ripval= Integer.parseInt(rip.getText());
				
				professeur.setDoctorant_type(type_doctorat.getText());
				professeur.setDoctorant_mention(mention_doctorat.getText());
				professeur.setEtablissement(etablissement.getText());
				professeur.setMatiere_enseigne(Matiere_enseigne.getValue());
				professeur.setType_contrat(type_contrat.getValue());
				professeur.setRip(ripval);
				professeur.setImagecv(imageCv);
				
				professeur.setCni_user(cni.getText());
				
				boolean isInsered=professeurDao.insertProfesseur(professeur);
				
    			
    			if(isInsered) {
    				AppFunctions.showAlertInformation("Succès","Utilisateur ajouter avec succès !");
    				fetchProfesseur();
    				
    			}else {
    				AppFunctions.showAlertInformation("Erreur","Échec de l'ajoute de l'utilisateur.");
    			}
    		}
			
			
			
			
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	public void addProfPaneToFront() {
		addProfPane.toFront();
		addProfMenu.toFront();
	   // studentNavMenu.getChildren().removeLast();
	}
	public void listProfPaneToFront() {
		listProfPane.toFront();
		listProfMenu.toFront();
	   // studentNavMenu.getChildren().removeLast();
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