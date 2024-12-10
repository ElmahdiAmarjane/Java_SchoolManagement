package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import modules.Absence;
import modules.Etudiant;
import modules.Filier;
import dao.AbsenceDao;
import dao.EtudiantDao;
import dao.FilierDao;
public class AdminAbsenceController {

    // Data Models
    private final EtudiantDao etudiantDao = new EtudiantDao();
    private final AbsenceDao absenceDao = new AbsenceDao();
    private final FilierDao filierDao = new FilierDao();

    private List<Etudiant> listEtudiants = new ArrayList<>();
    private List<Etudiant> listEtudiantsAbsence = new ArrayList<>();
    private List<Filier> filiers;

    // FXML elements
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
    private AnchorPane studentPane;
    @FXML
    private AnchorPane addStudentPane;
    @FXML
    private AnchorPane listStudentPane;

    @FXML
    private DatePicker date;
    @FXML
    private ComboBox<String> filierComboBox;

    public void initialize() {
        // Set up TableView columns
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

        fetchAllStudents();
        fetchComboBox();
        addIconsToTable();

        // Add listener to ComboBox for filier selection
        filierComboBox.setOnAction(event -> {
            String selectedFilier = filierComboBox.getValue();
            if (selectedFilier != null) {
                fetchFilteredStudents(selectedFilier);
            }
        });
        
        date.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                fetchStudentsByDate(newValue);
            }
        });
    }

    private void fetchAllStudents() {
        try {
            // Fetch all students
            listEtudiants = etudiantDao.selectAllEtudiants();

            // Populate the table
            ObservableList<Etudiant> etudiants = FXCollections.observableArrayList(listEtudiants);
            studentsTable.setItems(etudiants);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchStudentsByDate(LocalDate selectedDate) {
    	 try {
    	        listEtudiantsAbsence.clear();
    	        Absence absence = absenceDao.fetchAbsenceFilieByDater(selectedDate);

    	        if (absence == null || absence.getCne_etudiants() == null) {
    	            logMessage("No absences found for date: " + selectedDate);
    	            refreshTable(new ArrayList<>());
    	            return;
    	        }

    	        for (String cne : absence.getCne_etudiants()) {
    	            Etudiant student = etudiantDao.selectEtudiantByCne(cne);
    	            if (student != null) {
    	                listEtudiantsAbsence.add(student);
    	            }
    	        }
    	        refreshTable(listEtudiantsAbsence);
    	    } catch (Exception e) {
    	        logError("Failed to filter students by date.", e);
    	    }
    }
    public void fetchFilteredStudents(String filier) {
    	 try {
    		 
    		 if ("Select All".equals(filier)) {
    	            fetchAllStudents();
    	            return;
    	        }
    		 
    		 listEtudiantsAbsence.clear();
             Absence absence = absenceDao.fetchAbsenceFilier(filier);

             if (absence == null || absence.getCne_etudiants() == null) {
                 logMessage("No absences found for filier: " + filier);
                 refreshTable(new ArrayList<>());
                 return;
             }

             for (String cne : absence.getCne_etudiants()) {
                 Etudiant student = etudiantDao.selectEtudiantByCne(cne);
                 if (student != null) {
                	 listEtudiantsAbsence.add(student);
                 }
             }
             refreshTable(listEtudiantsAbsence);
         } catch (Exception e) {
             logError("Failed to filter students by filier.", e);
         }
    }

    private void refreshTable(List<Etudiant> students) {
    	
        ObservableList<Etudiant> data = FXCollections.observableArrayList(students);
        studentsTable.setItems(data);

        studentsTable.setRowFactory(tv -> {
            TableRow<Etudiant> row = new TableRow<>();

            row.itemProperty().addListener((obs, oldItem, newItem) -> {
                if (newItem != null) {
                    boolean isAbsent = listEtudiantsAbsence.contains(newItem);
                    if (isAbsent) {
                    	row.setStyle("-fx-background-color: #ff6262;"); 
                    } else {
                        row.setStyle(""); 
                    }
                }
            });

            return row;
        });
    }

    
    private void logError(String message, Exception e) {
        System.err.println(message);
        e.printStackTrace();
    }

    private void logMessage(String message) {
        System.out.println(message);
    }

    public void fetchComboBox() {
    	try {
            filierComboBox.getItems().clear(); 
            filiers = filierDao.selectAllFilier();
            for (Filier filier : filiers) {
                filierComboBox.getItems().add(filier.getShortName());
            }
            filierComboBox.getItems().add("Select All");
        } catch (Exception e) {
            logError("Failed to fetch filiers for ComboBox.", e);
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

                	HBox actionBox = new HBox(10);
                   
                    Button messageButton = new Button();
                                       
                    ImageView messageIcon = createImageView("assets/message.png");

                    // Add ImageView to buttons
                    messageButton.setGraphic(messageIcon);
                  

                    // Style buttons
                    messageButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");

                    // Add buttons to HBox
                    actionBox.setStyle("-fx-alignment: CENTER;");
                    actionBox.getChildren().addAll(messageButton);

                    // Set the HBox as the graphic for the cell
                    setGraphic(actionBox);
                    
                    Etudiant rowData = getTableView().getItems().get(getIndex());  // Replace YourDataType with the type of your row data

                    // Add button actions
                    messageButton.setOnAction(event -> updateAction(rowData.getCni()));
                   
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
        	e.printStackTrace();
            System.err.println("Could not load image: " + resourcePath);
             
        }
        return imageView;
    }


    private void updateAction(String cni) {
       
    }

    @FXML
    public void listStudentPaneToFront() {
        listStudentPane.toFront();
    }

    @FXML
    public void studentPaneToFront() {
        studentPane.toFront();
        initialize();
    }
}