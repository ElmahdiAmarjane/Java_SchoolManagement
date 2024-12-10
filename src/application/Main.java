package application;
	
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import dao.AbsenceDao;
import dao.CourseDao;
import dao.EmploiDao;
import dao.EtudiantDao;
import dao.ProfesseurDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modules.Absence;
import modules.Course;
import modules.Emploi;
import modules.Etudiant;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private void showMainApplication() throws Exception {
		
        // Load your main application FXML and show the main window
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/views/professeurDashboard.fxml"));
        Parent mainRoot = mainLoader.load();
        Scene mainScene = new Scene(mainRoot,990,550);
        Stage mainStage = new Stage();
        mainStage.setScene(mainScene);
        mainStage.setTitle("Main Application");
        mainStage.show();
    }
	
	@Override
	public void start(Stage primaryStage) {
		try {
			/*BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();*/
			
			showMainApplication();
			
			
			/*CourseDao courseDao=new CourseDao();
			Course cours=new Course();*/
			
			/*private int id;
		    private String title, description, files, type,filier_titel,element_id;
		    private LocalDate datePublication;*/
		    /*cours.setTitle("Titeeel");
		    cours.setDescription("HHHH");
		    cours.setFiles("ddd");
		    cours.setFilier_titel("IL");
		    cours.setElement_id("JAVA");
		    cours.setType("TD");
		    
		    LocalDate localDate = LocalDate.now();
		    
		    cours.setDatePublication(localDate);
		    
		    courseDao.insertCours(cours);*/
		    
			/*AbsenceDao absenceDao = new AbsenceDao();
			Absence absence = new Absence();

			try {
			    // Correctly setting the date
			    String dateString = "2024-12-03"; // Date as a string
			    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			    java.util.Date utilDate = format.parse(dateString); // Parse the string into a java.util.Date

			    // Convert java.util.Date to java.sql.Date
			    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			    absence.setDate(sqlDate); // Set the converted java.sql.Date

			    // Set the filier title
			    absence.setFilier_titel("IL"); // Set the appropriate filier title

			    // Fetch absences filtered by filier title and date
			    Absence abs = absenceDao.fetchAbsenceFilier(absence);

			    if (abs != null) {
			        System.out.println("Start Time: " + abs.getHeure_debut());
			        System.out.println("End Time: " + abs.getHeure_fine());
			        
			        List<String> cne=abs.getCne_etudiants();
			        
			        for(String a:cne) {
			        	System.out.println("CNE : "+a);
			        }
			    } else {
			        System.out.println("No absences found for the given filier and date.");
			    }
			} catch (Exception e) {
			    e.printStackTrace(); // Catch and print any exceptions
			}*/

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
		//System.out.println("Hello MOhamed");
	}
}
