package controllers;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign.MaterialDesign;

import java.time.LocalDate;
import dao.EtudiantDao;
import dao.FilierDao;
import dao.UserDao;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import modules.Etudiant;
import modules.Filier;
import modules.SceneSwitch;
import modules.User;


public class EtudiantController {

	Etudiant etudiant=new Etudiant();
	User user=new User();
	
	EtudiantDao etudiantDao=new EtudiantDao();
	UserDao userDao = new UserDao();
	FilierDao filierDao=new FilierDao();
	
	List<Etudiant> listEtudiants;

    String imagepath;
    String imageCnipath;
    String imageBacpath;
    String imageRelverBac;
    String imageBac2path;
    String imageS1path;
    String imageS2path;
    String imageS3path;
    String imageS4path;
    String imageCartNationalpath;
    String imageExtraipath;
    
    @FXML
    private Pane EtudiantView;
    
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
                    
                    Etudiant rowData = getTableView().getItems().get(getIndex());  // Replace YourDataType with the type of your row data

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
        	
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/UpdateEtudiantInfo.fxml"));
            Pane nextPane = loader.load();

            UpdateEtudiantInfoController controller = loader.getController();
            controller.setCniValue(cni); 

            EtudiantView.getChildren().clear();
            EtudiantView.getChildren().add(nextPane);
            
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

                    fetchEtudiant();
                } catch (Exception e) {
                    System.out.println("Error deleting user: " + e.getMessage());
                }
            }
        });
    }


    private void downloadAction(int index) {
        System.out.println("Download action triggered for row: " + index);
    }
    
    public void fetchEtudiant() {
        try {
             listEtudiants = etudiantDao.selectAllEtudiants();

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
			user.setImageCni(imageCnipath);

    		
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
    			
    			etudiant.setImageBac(imageBacpath);
    			etudiant.setImageBac2(imageBac2path);
    			etudiant.setIamge_note_bac(imageRelverBac);
    			etudiant.setImageS1(imageS1path);
    			etudiant.setImageS2(imageS2path);
    			etudiant.setImageS3(imageS3path);
    			etudiant.setImageS4(imageS4path);
    			
    			etudiantDao.insertEtudiant(etudiant);
    			 fetchEtudiant();
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
	        btnChooseFileCNI.setText(selectedFile.getName());
	        btnChooseFileCNI.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
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
	    	btnChooseFileBac.setText(selectedFile.getName());
	    	btnChooseFileBac.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
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
	    	imageRelverBac = selectedFile.getAbsolutePath();
	    	btnChooseFileNoteBac.setText("Image Selected");
	    	btnChooseFileNoteBac.setText(selectedFile.getName());
	    	btnChooseFileNoteBac.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
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
	    	btnChooseFileBac2.setText(selectedFile.getName());
	    	btnChooseFileBac2.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
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
	    	btnChooseFileNoteS1.setText(selectedFile.getName());
	    	btnChooseFileNoteS1.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
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
	    	btnChooseFileNoteS2.setText(selectedFile.getName());
	    	btnChooseFileNoteS2.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
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
	    	btnChooseFileNoteS3.setText(selectedFile.getName());
	    	btnChooseFileNoteS3.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
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
	    	btnChooseFileNoteS4.setText(selectedFile.getName());
	    	btnChooseFileNoteS4.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    } else {
	        // Handle the case where no file was selected (Optional)
	    	btnChooseFileNoteS4.setText("Select Image");
	    }
	}
	
	
	public void FetchCombBox() {
		  
    	int currentYear = LocalDate.now().getYear();
    	
    	try {
    		List<Filier> filiers=filierDao.selectAllFilier();
    		
    		for(Filier fil:filiers) {
    			filier.getItems().addAll(fil.getShortName());
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
   
    
    
    
    
}
