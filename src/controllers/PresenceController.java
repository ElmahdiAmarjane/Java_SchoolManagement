package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import modules.Absence;
import modules.Etudiant;
import modules.Professeur;
import dao.EtudiantDao;
import dao.ProfesseurDao;
import dao.UserDao;

import java.util.List;

public class PresenceController {
    @FXML
    private TableView<Etudiant> tableView;
    @FXML
    private TableColumn<Etudiant, String> idColumn;
    @FXML
    private TableColumn<Etudiant, String> nameColumn;
    @FXML
    private TableColumn<Etudiant, String> attendanceColumn;

    private EtudiantDao etudiantDao = new EtudiantDao();
	Professeur professeur = new Professeur();
	Absence absence=new Absence();
	ProfesseurDao professeurDao = new ProfesseurDao();
	UserDao userDao = new UserDao();

    @FXML
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
        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(tableView.getItems().indexOf(cellData.getValue()) + 1)));

        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom() + " " + cellData.getValue().getPrenom()));
        attendanceColumn.setCellValueFactory(cellData -> new SimpleStringProperty("Present")); // Placeholder for attendance

        // Set custom cell factory for attendance column
        attendanceColumn.setCellFactory(column -> new TableCell<>() {
            private final HBox hbox = new HBox();
            private final ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList("Present", "Absent"));

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    choiceBox.setValue(item);
                    hbox.getChildren().clear();
                    hbox.getChildren().add(choiceBox);
                    hbox.setStyle("-fx-alignment: CENTER_RIGHT; -fx-spacing: 10;");

                    choiceBox.valueProperty().addListener((obs, oldVal, newVal) ->
                        getTableView().getItems().get(getIndex())
                    );

                    setGraphic(hbox);
                }
            }
        });

        // Bind columns to resize with table width
        tableView.widthProperty().addListener((obs, oldVal, newVal) -> {
            double width = newVal.doubleValue();
            idColumn.setPrefWidth(width * 0.1);
            nameColumn.setPrefWidth(width * 0.4);
            attendanceColumn.setPrefWidth(width * 0.5);
        });

        // Load student data from the database
        tableView.setItems(getStudentData());
    }

    @FXML
    private void handleSaveAttendance() {
    	
    /*    ObservableList<Etudiant> students = tableView.getItems();
        for (Etudiant etudiant : students) {
            System.out.println("Etudiant CNE: " + etudiant.getCne() + ", Name: " + etudiant.getNom() + " " + etudiant.getPrenom() +
                    ", Attendance: ");
        }
        */
    	
    	absence.setCne_etudiants(null);
    	professeurDao.absence(absence);
    }

    private ObservableList<Etudiant> getStudentData() {
        ObservableList<Etudiant> students = FXCollections.observableArrayList();
        
        // Fetch students from the database with id_filier = 1
        List<Etudiant> etudiants = etudiantDao.selectAllEtudiants();
        students.addAll(etudiants);

        return students;
    }
}
