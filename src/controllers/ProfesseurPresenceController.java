package controllers;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import config.AppFunctions;
import dao.AbsenceDao;
import dao.ElementDao;
import dao.EtudiantDao;
import dao.FilierDao;
import dao.UserDao;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import modules.Absence;
import modules.Element;
import modules.Etudiant;
import modules.Filier;
import modules.User;

public class ProfesseurPresenceController {
    
    Etudiant etudiant = new Etudiant();
    User user = new User();
    Absence absence=new Absence();
    Element element=new Element();
    
    EtudiantDao etudiantDao = new EtudiantDao();
    UserDao userDao = new UserDao();
    FilierDao filierDao = new FilierDao();
    AbsenceDao absenceDao=new AbsenceDao();
    ElementDao elementDao=new ElementDao();
    
    List<Etudiant> listEtudiants;
    List<String> cneEtudiants=new ArrayList<>();
    
    @FXML
    private TableView<Etudiant> tableView;
    @FXML
    private TableColumn<Etudiant, String> idColumn;
    @FXML
    private TableColumn<Etudiant, String> cneColumn;
    @FXML
    private TableColumn<Etudiant, String> nomColumn;
    @FXML
    private TableColumn<Etudiant, String> prenomColumn;
    @FXML
    private TableColumn<Etudiant, String> attendanceColumn;
    
    @FXML
    private ComboBox<String> comboBoxFiliere,comboBoxTimeRange,comboBoxElement;
    
    @FXML
    private DatePicker datePicker;
    
    @FXML
    public void initialize() {
    	
    	idColumn.setCellFactory(column -> new TableCell<>() {
    	    @Override
    	    protected void updateItem(String item, boolean empty) {
    	        super.updateItem(item, empty);
    	        if (empty) {
    	            setText(null);
    	        } else {
    	            setText(String.valueOf(getIndex() + 1));
    	        }
    	    }
    	});
        cneColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCne()));
        nomColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        prenomColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
        attendanceColumn.setCellFactory(column -> new TableCell<Etudiant, String>() {
            private final Button presenceButton = new Button("Present");
            private final Button absenceButton = new Button("Absent");

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    // Set up the buttons' initial styles
                    presenceButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    absenceButton.setStyle("-fx-background-color: white; -fx-text-fill: black;");

                    Etudiant etudiant = getTableView().getItems().get(getIndex());
                    
                    if (etudiant.getAttendanceStatus() != null && etudiant.getAttendanceStatus().equals("Absent")) {
                        presenceButton.setStyle("-fx-background-color: white; -fx-text-fill: black;");
                        absenceButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                    }

                    presenceButton.setOnAction(event -> {
                        etudiant.setAttendanceStatus("Present"); 
                        updateButtonStyles(etudiant); 
                       
                        
                    });

                    absenceButton.setOnAction(event -> {
                        etudiant.setAttendanceStatus("Absent"); 
                        updateButtonStyles(etudiant);
                        
                        cneEtudiants.add(etudiant.getCne());
                    });

                    HBox hbox = new HBox(10, presenceButton, absenceButton);
                    setGraphic(hbox);

                    updateButtonStyles(etudiant);
                }
            }

            private void updateButtonStyles(Etudiant etudiant) {
                if ("Present".equals(etudiant.getAttendanceStatus())) {
                    presenceButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    absenceButton.setStyle("-fx-background-color: white; -fx-text-fill: black;");
                } else if ("Absent".equals(etudiant.getAttendanceStatus())) {
                    presenceButton.setStyle("-fx-background-color: white; -fx-text-fill: black;");
                    absenceButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                }
            }
        });
        
        datePicker.setValue(LocalDate.now());
        
        comboBoxFiliere.setOnAction(event -> {
            String selectedFilier = comboBoxFiliere.getValue();
            if (selectedFilier != null) {
                fetchFilteredStudents(selectedFilier);
            }
        });
        
        fetchEtudiant();
        FetchCombBox();
    }

    
    
    public void fetchEtudiant() {
        try {
            listEtudiants = etudiantDao.selectAllEtudiants();
            ObservableList<Etudiant> etudiants = FXCollections.observableArrayList(listEtudiants);
            tableView.setItems(etudiants); // Set items to the table
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        tableView.setItems(data);
    }

    private void FetchCombBox() {
        
    	try {
            List<Filier> filiers=filierDao.selectAllFilier();
            for(Filier filier:filiers){
            	comboBoxFiliere.getItems().add(filier.getShortName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
        // Populate ComboBox with time ranges
        comboBoxTimeRange.setItems(FXCollections.observableArrayList(
            "08:00 - 10:00", 
            "10:00 - 12:00", 
            "14:00 - 16:00", 
            "16:00 - 18:00"
        ));
        
        List<Element> elements=elementDao.selectAllElemnt();
        for(Element elem:elements) {
        	comboBoxElement.getItems().add(elem.getNom());
        }
    }

    @FXML
    private void handleSaveAttendance() {
    	
    	
        
    	if(comboBoxFiliere.getValue()==null || comboBoxTimeRange.getValue()==null || comboBoxElement.getValue()==null) {
    		
      		 AppFunctions.showAlertError("Échec de l'insertion", "Il faut  remplir les champs obligatoires.");
      		 
    	}else if(!datePicker.getValue().isEqual(LocalDate.now())){
    		
    		AppFunctions.showAlertError("Échec de l'insertion", "La date est différente de la date du jour d'hui.");
    		
    	}else {
    		
    		LocalDate selectedDate = datePicker.getValue(); 
            String selectedFiliere = comboBoxFiliere.getValue();
            String[] timeRange = comboBoxTimeRange.getValue().split(" - ");
            String startTime = timeRange[0]; // e.g., "08:00"
            String endTime = timeRange[1];
    		
    		LocalDate localDate = LocalDate.now(); 
		    
        	absence.setCne_etudiants(cneEtudiants);
        	absence.setDate(selectedDate);
        	absence.setElement_nom(comboBoxElement.getValue());
        	absence.setFilier_titel(comboBoxFiliere.getValue());
        	absence.setHeure_debut(Time.valueOf(startTime + ":00")); 
            absence.setHeure_fine(Time.valueOf(endTime + ":00"));
        	
        	boolean isInserted=absenceDao.insertAbsence(absence);
        	
        	if(isInserted) {
        		AppFunctions.showAlertSuccess("Insertion Réussie", "L'absence a été insérée avec succès !");
        	}else {
        		AppFunctions.showAlertError("Échec de l'insertion", "Une erreur s'est produite lors de l'insertion de l'absence. Veuillez réessayer.");
        	}
        	
    	}
    	
    }
    
    
    
    
}
