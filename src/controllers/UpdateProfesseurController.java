package controllers;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import dao.ElementDao;
import dao.FilierDao;
import dao.ProfesseurDao;
import dao.UserDao;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import modules.Etudiant;
import modules.Filier;
import modules.Professeur;
import modules.User;

public class UpdateProfesseurController {
	
	Professeur professeur=new Professeur();
	ProfesseurDao professeurDao=new ProfesseurDao();
	ElementDao elementDao = new ElementDao();
	FilierDao filierDao=new FilierDao();
	UserDao userDao=new UserDao();
	
	User user=new User();
	List<Filier> filiers;
	
	private String imageCv;
	private String imageCni;
	private String imageProfile;
	
	private List<Element> elements;
	
	
    static private String cniVal;
    
    private StringProperty cniValue = new SimpleStringProperty();

    public StringProperty cniValueProperty() {
        return cniValue;
    }

    public void setCniValue(String value) {
        this.cniValue.set(value);
    }

    public String getCniValue() {
        return cniValue.get();
    }
    
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
		private AnchorPane studentNavMenu;
	
	
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
	    	
	    	cniValue.addListener((observable, oldValue, newValue) -> {
	            if (newValue == null || newValue.isEmpty()) {
	                System.out.println("CNI is NULL or EMPTY");
	            } else {
	                //cniVal = newValue;
	                //cniValue.set(newValue);// Set the static variable to the new value of cniValue
	                System.out.println("CNI Value: " + newValue);
	                fetchProfesseur(newValue);
	            }
	        });
	    	
	    	initialisCombpBox();
	    	nom.setText("jjjj");
	    }
	    

	    public void fetchProfesseur(String cnival) {
	        try {
	            Professeur professeur = professeurDao.selectProfesseur(cnival);
	            if (professeur != null) {

	            	nom.setText(professeur.getNom());
	                prenom.setText(professeur.getPrenom());
	                sexe.setValue(professeur.getSexe());
	                date_naissance.setValue(professeur.getDateNaissance());
	                email.setText(professeur.getEmail());
	                tel.setText(professeur.getTel());
	                cni.setText(professeur.getCni());
	                nationalite.setValue(professeur.getNationalite());
	                password.setText(professeur.getPassword());
	                adresse.setText(professeur.getAdress());
	                type_doctorat.setText(professeur.getDoctorant_type());
	                mention_doctorat.setText(professeur.getDoctorant_mention());
	                etablissement.setText(professeur.getEtablissement());
	                Matiere_enseigne.setValue(professeur.getMatiere_enseigne());
	                type_contrat.setValue(professeur.getType_contrat());
	                rip.setText(String.valueOf(professeur.getRip()).toString());
	                
	            	
	            	imageProfile=professeur.getImage();
	            	imageCni=professeur.getImageCni();
	            	imageCv=professeur.getImagecv();
	            	
	            	chooseProfileImageBtn.setText("Image Selected");
	    	    	chooseProfileImageBtn.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    	    	
	    	    	btnChooseCv.setText("Image Selected");
	    	    	btnChooseCv.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	    	    	
	    	    	btnChooseFileCIN.setText("Image Selected");
	    	    	btnChooseFileCIN.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
	            	

	                
	            } else {
	                System.out.println("No professor found with CNI: " + cnival);
	            }
	        } catch (Exception e) {
	            System.out.println("Error fetching professor: " + e.getMessage());
	        }
	    }
	    
	    
	public void enregistrerBtn() {
		
		/*try {
			
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
				
				professeur.setDoctorant_type(type_doctorat.getText());
				professeur.setDoctorant_mention(mention_doctorat.getText());
				professeur.setEtablissement(etablissement.getText());
				professeur.setMatiere_enseigne(Matiere_enseigne.getValue());
				professeur.setType_contrat(type_contrat.getValue());
				professeur.setRip(ripval);
				professeur.setImagecv(imageCv);
				professeur.setCni_user(cni.getText());
				
				professeurDao.insertProfesseur(professeur);
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
		*/
	}
	public void addProfPaneToFront() {
		addProfPane.toFront();
	   // studentNavMenu.getChildren().removeLast();
	}
	public void listProfPaneToFront() {
		listProfPane.toFront();
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