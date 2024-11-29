package controllers;


import java.io.File;
import java.util.List;
import java.time.LocalDate;
import dao.EtudiantDao;
import dao.FilierDao;
import dao.UserDao;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import modules.Etudiant;
import modules.Filier;
import modules.User;


public class EtudiantController {

	Etudiant etudiant=new Etudiant();
	User user=new User();
	
	EtudiantDao etudiantDao=new EtudiantDao();
	UserDao userDao = new UserDao();
	FilierDao filierDao=new FilierDao();
	

    String imagepath;
    String imageCnipath;
    String imageBacpath;
    String imageBac2path;
    String imageS1path;
    String imageS2path;
    String imageS3path;
    String imageS4path;
    String imageCartNationalpath;
    String imageExtraipath;
    
    @FXML
	private TableColumn<Etudiant, String> colNumber;

	@FXML
	private TableColumn<Etudiant, String> colCNI;

	@FXML
	private TableColumn<Etudiant, String> colNom;

	@FXML
	private TableColumn<Etudiant, String> colPrenom;

	@FXML
	private TableColumn<Etudiant, String> colFilliere;

	@FXML
	private TableColumn<Etudiant, String> colCNE;

	@FXML
	private TableView<Etudiant> studentsTable;
	
	@FXML
	private TableColumn<Etudiant, Void> icons;

	@FXML
	private AnchorPane studentNavMenu ;
	
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
	 
	 @FXML
	 private AnchorPane studentNavMenu1;
	 @FXML
	 private AnchorPane studentNavMenu2;

	 @FXML
	 private ImageView viewImageProfile;
	 @FXML
	 private AnchorPane studentPane ;
	 
	@FXML
	private AnchorPane addStudentPane ; 
	@FXML
	private AnchorPane listStudentPane ; 
		
	@FXML
	private Text addStudentBtn;
		
	@FXML 
	 private Text listStudentBtn;
	 
	 @FXML
	 private ImageView profileViewImage;
	///////////
	 @FXML
	 private Button btnChooseFileCNI;
	 @FXML
	 private Button btnChooseFileBac;
	 @FXML
	 private Button btnChooseFileNoteBac;
	 @FXML
	 private Button btnChooseFileBac2;
	 @FXML
	 private Button btnChooseFileNoteBac2;
	 
	 @FXML
	 private Button btnChooseFileNoteS1,btnChooseFileNoteS2,btnChooseFileNoteS3,btnChooseFileNoteS4;
	 @FXML
	 private Button selectImageProfileButton;
	
    @FXML
    private TextField nom, prenom, cne, cni, tel,email,s1,s2,s3,s4, password,MoyeeneBac,typeBac2,university,moyenneBac2,etablisment,serieBac,bacAcadimie;
    
    @FXML
    private DatePicker date_naissance;
    @FXML
    private ImageView userImageView, imageBac,imageBac2,imageS1,imageS2,imageS3,imageS4, imageCartNational, imageExtrai;
    @FXML
    private ComboBox<String> sexe, nationalite,filier;
    
    @FXML
    private ComboBox<Integer> anneeS1,anneeS2,anneeS3,anneeS4,anneBac;
    
    
    void update(){
		System.out.println("Updated");
	}
    
    private void addIconsToTable() {
    	
   
        icons.setCellFactory(param -> new TableCell<>() {
            private final HBox actionBox = new HBox(10);
            private final Button updateButton = new Button();
            private final Button deleteButton = new Button();
            private final Button downloadButton = new Button();

            {
                // Configure buttons with FontAwesomeFX icons
                FontAwesomeIconView updateIcon = new FontAwesomeIconView(FontAwesomeIcon.EDIT);
                FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                FontAwesomeIconView downloadIcon = new FontAwesomeIconView(FontAwesomeIcon.DOWNLOAD);

                // Style the icons
                updateIcon.setStyle("-fx-fill: blue; -fx-font-size: 16px;");
                deleteIcon.setStyle("-fx-fill: red; -fx-font-size: 16px;");
                downloadIcon.setStyle("-fx-fill: orange; -fx-font-size: 16px;");

                // Add icons to buttons
                updateButton.setGraphic(updateIcon);
                deleteButton.setGraphic(deleteIcon);
                downloadButton.setGraphic(downloadIcon);

                // Style the buttons
                updateButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
                deleteButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
                downloadButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");

                // Add buttons to the HBox
                actionBox.setStyle("-fx-alignment: CENTER;");
                actionBox.getChildren().addAll(updateButton, deleteButton, downloadButton);
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(actionBox);

                    // Add actions to buttons
                    updateButton.setOnAction(event -> update());
                    deleteButton.setOnAction(event -> update());
                    downloadButton.setOnAction(event -> update());
                }
            }
        });
    }
    public void fetchEtudiant() {
        try {
            List<Etudiant> listEtudiants = etudiantDao.selectAllEtudiants("IL");

            ObservableList<Etudiant> etudiants = FXCollections.observableArrayList(listEtudiants);
            studentsTable.setItems(etudiants); // Set items to the table

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
	public void addStudentPaneToFront() {
		addStudentPane.toFront();	
		//studentNavMenu2.toFront();
		//updateLinePosition(addStudentPane);
	}
	@FXML
	public void listStudentPaneToFront() {
		listStudentPane.toFront();
		//studentNavMenu1.toFront();
		//updateLinePosition(listStudentPane);
	}
    
    @FXML
	public void studentPaneToFront() {
		studentPane.toFront();
		initialize();
		
	}
    
    public void initialize() {
    	
    	
    	addIconsToTable();
    	// Set up TableView and TableColumn bindings
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colCNI.setCellValueFactory(new PropertyValueFactory<>("cni"));
        colCNE.setCellValueFactory(new PropertyValueFactory<>("cne"));
        colFilliere.setCellValueFactory(new PropertyValueFactory<>("filier_titel"));
        
        fetchEtudiant();
        
    	cni.textProperty().addListener((observal,oledvaleu,newvale)->{
    		password.setText(newvale);
    	});
    	
    	userImageView.setImage(new Image("https://via.placeholder.com/150"));
    	FetchCombBox();
    }

    public void AjouterEtudiantAction() {
    	
    	try {
    		
    		user.setNom(nom.getText());
    		user.setPrenom(prenom.getText());
    		user.setSexe(sexe.getValue());
    		user.setImage(imagepath);
    		user.setDateNaissance(date_naissance.getValue());
    		user.setEmail(email.getText());
    		user.setTel(tel.getText());
    		user.setCni(cni.getText());
    		user.setNationalite(nationalite.getValue());
    		user.setPassword(password.getText());
    		user.setRole("Etudiant");
    		
    		if(userDao.insertUser(user)) {
    			
    			Double noteS1= Double.parseDouble(s1.getText());
    			Double noteS2= Double.parseDouble(s2.getText());
    			Double noteS3= Double.parseDouble(s3.getText());
    			Double noteS4= Double.parseDouble(s4.getText());
    			
    			Double noteBac=Double.parseDouble(MoyeeneBac.getText());
    			Double noteBac2=Double.parseDouble(moyenneBac2.getText());
    			
    			
    			etudiant.setCne(cne.getText());
    			etudiant.setCni_user(cni.getText());
    			etudiant.setFilier_titel(filier.getValue());
    			etudiant.setAnneBac(anneBac.getValue());
    			etudiant.setBac_acadimic(bacAcadimie.getText());
    			etudiant.setType_bac(bacAcadimie.getText());
    			etudiant.setNote_bac(noteBac);
    			etudiant.setNote_bac2(noteBac2);
    			etudiant.setType_bac2(typeBac2.getText());
    			etudiant.setUniversity(university.getText());
    			etudiant.setEtablisment_bac2(etablisment.getText());
    			etudiant.setNote_bac2(noteBac2);
    			etudiant.setAnneeS1(anneeS1.getValue());
    			etudiant.setAnneeS2(anneeS2.getValue());
    			etudiant.setAnneeS3(anneeS3.getValue());
    			etudiant.setAnneeS4(anneeS4.getValue());
    			etudiant.setNote_S1(noteS1);
    			etudiant.setNote_S2(noteS2);
    			etudiant.setNote_S3(noteS3);
    			etudiant.setNote_S4(noteS4);
    			
    			etudiant.setImagecni(imageCnipath);
    			etudiant.setImageBac(imageBacpath);
    			etudiant.setImageBac2(imageBac2path);
    			etudiant.setIamge_note_bac(imageBac2path);
    			etudiant.setImageS1(imageS1path);
    			etudiant.setImageS2(imageS2path);
    			etudiant.setImageS3(imageS3path);
    			etudiant.setImageS4(imageS4path);
    			
    			etudiantDao.insertEtudiant(etudiant);
    		}
    		
    		
    		
    	}catch(Exception e) {
    		System.out.println(e);
    	}
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
    
	@FXML
    public void handleSelectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File selectedFile = fileChooser.showOpenDialog(userImageView.getScene().getWindow());
        if (selectedFile != null) {
        	imagepath = selectedFile.getAbsolutePath();
            userImageView.setImage(new Image(selectedFile.toURI().toString()));

            // Update the button text to indicate success
            selectImageProfileButton.setText("Image Selected");
            
            selectImageProfileButton.setText(selectedFile.getName());
            selectImageProfileButton.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
        } else {
            // Handle the case where no file was selected
        	selectImageProfileButton.setText("Select Image");
        }
    }
	
	@FXML
	public void selectCni() {
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Select an Image");
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
	    );

	    File selectedFile = fileChooser.showOpenDialog(btnChooseFileCNI.getScene().getWindow());
	    if (selectedFile != null) {
	    	imageCnipath = selectedFile.getAbsolutePath();
	        btnChooseFileCNI.setText("Image Selected");
	        selectImageProfileButton.setText(selectedFile.getName());
            selectImageProfileButton.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    } else {
	        // Handle the case where no file was selected (Optional)
	        btnChooseFileCNI.setText("Select Image");
	    }
	}
	
	@FXML
	public void selectBac() {
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Select an Image");
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
	    );

	    File selectedFile = fileChooser.showOpenDialog(btnChooseFileBac.getScene().getWindow());
	    if (selectedFile != null) {
	    	imageBacpath = selectedFile.getAbsolutePath();
	    	btnChooseFileBac.setText("Image Selected");
	    	selectImageProfileButton.setText(selectedFile.getName());
            selectImageProfileButton.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    } else {
	        // Handle the case where no file was selected (Optional)
	    	btnChooseFileBac.setText("Select Image");
	    }
	}
	
	@FXML
	public void selectNoteBac() {
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Select an Image");
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
	    );

	    File selectedFile = fileChooser.showOpenDialog(btnChooseFileNoteBac.getScene().getWindow());
	    if (selectedFile != null) {
	    	imageBacpath = selectedFile.getAbsolutePath();
	    	btnChooseFileNoteBac.setText("Image Selected");
	    	selectImageProfileButton.setText(selectedFile.getName());
            selectImageProfileButton.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    } else {
	        // Handle the case where no file was selected (Optional)
	    	btnChooseFileNoteBac.setText("Select Image");
	    }
	}
	
	@FXML
	public void selectBac2() {
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Select an Image");
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
	    );

	    File selectedFile = fileChooser.showOpenDialog(btnChooseFileBac2.getScene().getWindow());
	    if (selectedFile != null) {
	    	imageBac2path = selectedFile.getAbsolutePath();
	    	btnChooseFileBac2.setText("Image Selected");
	    	selectImageProfileButton.setText(selectedFile.getName());
            selectImageProfileButton.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    } else {
	        // Handle the case where no file was selected (Optional)
	    	btnChooseFileBac2.setText("Select Image");
	    }
	}
	
	@FXML
	public void selectS1() {
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Select an Image");
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
	    );

	    File selectedFile = fileChooser.showOpenDialog(btnChooseFileNoteS1.getScene().getWindow());
	    if (selectedFile != null) {
	    	imageS1path = selectedFile.getAbsolutePath();
	    	btnChooseFileNoteS1.setText("Image Selected");
	    	selectImageProfileButton.setText(selectedFile.getName());
            selectImageProfileButton.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    } else {
	        // Handle the case where no file was selected (Optional)
	    	btnChooseFileNoteS1.setText("Select Image");
	    }
	}
   
	@FXML
	public void selectS2() {
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Select an Image");
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
	    );

	    File selectedFile = fileChooser.showOpenDialog(btnChooseFileNoteS2.getScene().getWindow());
	    if (selectedFile != null) {
	    	imageS2path = selectedFile.getAbsolutePath();
	    	btnChooseFileNoteS2.setText("Image Selected");
	    	selectImageProfileButton.setText(selectedFile.getName());
            selectImageProfileButton.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    } else {
	        // Handle the case where no file was selected (Optional)
	    	btnChooseFileNoteS2.setText("Select Image");
	    }
	}
	
	@FXML
	public void selectS3() {
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Select an Image");
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
	    );

	    File selectedFile = fileChooser.showOpenDialog(btnChooseFileNoteS3.getScene().getWindow());
	    if (selectedFile != null) {
	    	imageS3path = selectedFile.getAbsolutePath();
	    	btnChooseFileNoteS3.setText("Image Selected");
	    	selectImageProfileButton.setText(selectedFile.getName());
            selectImageProfileButton.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    } else {
	        // Handle the case where no file was selected (Optional)
	    	btnChooseFileNoteS3.setText("Select Image");
	    }
	}
	
	@FXML
	public void selectS4() {
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Select an Image");
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
	    );

	    File selectedFile = fileChooser.showOpenDialog(btnChooseFileNoteS4.getScene().getWindow());
	    if (selectedFile != null) {
	    	imageS4path = selectedFile.getAbsolutePath();
	    	btnChooseFileNoteS4.setText("Image Selected");
	    	selectImageProfileButton.setText(selectedFile.getName());
            selectImageProfileButton.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    } else {
	        // Handle the case where no file was selected (Optional)
	    	btnChooseFileNoteS4.setText("Select Image");
	    }
	}
	
	private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
	public void FetchCombBox() {
		  
    	int currentYear = LocalDate.now().getYear();
    	
    	try {
    		List<Filier> filiers=filierDao.selectAllFilier();
    		
    		for(Filier fil:filiers) {
    			filier.getItems().addAll(fil.getTitel());
    		}
    		
    	}catch(Exception e) {
    		System.out.print(e);
    	}
    	
    	sexe.getItems().addAll("Male", "Female");
        nationalite.getItems().addAll("Moroccan", "Other");
        
        for(int i=0;i<5;i++) {
        	
            anneeS1.getItems().addAll(currentYear - i);
            anneeS2.getItems().addAll(currentYear - i);
            anneeS3.getItems().add(currentYear - i);
            anneeS4.getItems().add(currentYear - i);
            
            anneBac.getItems().add(currentYear - i);

        }
    	
    }
    
  //DELET ETUDIANT
    public boolean deleteEtudiant(){
    	return etudiantDao.deleteEtudiant("med");
    }
    
    
    
    
}
