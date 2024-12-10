package controllers;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import java.time.LocalDate;
import dao.EtudiantDao;
import dao.FilierDao;
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
import javafx.scene.control.TableRow;
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
import modules.Absence;
import modules.Etudiant;
import modules.Filier;
import modules.SceneSwitch;
import modules.User;


public class ProfesseurEtudiantController {

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
	 private Text listStudentBtn;
	 
	@FXML
	private ImageView profileViewImage;
	
	@FXML
	private ComboBox<String> comboBoxFiliere;
	
   
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

        FetchCombBox();
        
        comboBoxFiliere.setOnAction(event -> {
            String selectedFilier = comboBoxFiliere.getValue();
            if (selectedFilier != null) {
                fetchFilteredStudents(selectedFilier);
            }
        });

        fetchEtudiant();
    }

    public void fetchFilteredStudents(String filier) {
        try {
            if ("Select All".equals(filier)) {
                fetchEtudiant(); // Load all students
                return;
            }

            List<Etudiant> filteredStudents = etudiantDao.selectAllEtudiantsFilier(filier);
            refreshTable(filteredStudents);

        } catch (Exception e) {
            System.err.println("Error filtering students by filier: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void refreshTable(List<Etudiant> students) {
        ObservableList<Etudiant> data = FXCollections.observableArrayList(students);
        studentsTable.setItems(data);
    }

    public void FetchCombBox() {
    	
        List<Filier> filiers = filierDao.selectAllFilier();
        for (Filier filier : filiers) {
            comboBoxFiliere.getItems().add(filier.getShortName());
        }
        comboBoxFiliere.getItems().add("Select All");
        
        comboBoxFiliere.getSelectionModel().select("Select All");
    }
   
}