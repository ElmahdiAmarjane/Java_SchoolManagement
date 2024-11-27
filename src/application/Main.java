package application;
	
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import dao.EtudiantDao;
import dao.ProfesseurDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modules.Absence;
import modules.Etudiant;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

// TEST
public class Main extends Application {
	
	private void showMainApplication() throws Exception {
		
        // Load your main application FXML and show the main window
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/views/adminDashboard.fxml"));
        Parent mainRoot = mainLoader.load();
        Scene mainScene = new Scene(mainRoot,800,500);
        Stage mainStage = new Stage();
        mainStage.setScene(mainScene);
        mainStage.setTitle("Main Application");

        // Add your main application logic here

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
			
			/*try {
		        ProfesseurDao professeurDao = new ProfesseurDao();

		        // Initialize the list of CNEs with sample values
		        List<String> cne_etudiants = new ArrayList<>();
		        cne_etudiants.add("a");
		        cne_etudiants.add("dd");

		        // Define other parameters for testing
		        Date date_jour = Date.valueOf("2024-11-09"); // Use java.sql.Date for date_jour
		        Time heure_debut = Time.valueOf("08:00:00"); // Use java.sql.Time for heure_debut
		        Time heure_fin = Time.valueOf("10:00:00"); 
		        int id_filiere = 2;
		        int element_id = 1;

		        Absence abs = new Absence();
		        abs.setCne_etudiants(cne_etudiants);
		        abs.setDate(date_jour);
		        abs.setHeure_debut(heure_debut);
		        abs.setHeure_fine(heure_fin);
		        abs.setFilier_id(id_filiere);
		        abs.setElement_id(element_id);

		        // Call the absence method
		        boolean result = professeurDao.absence(abs);

		        // Output result for testing
		        System.out.println("Absence recorded: " + result);

		    } catch (Exception e) {
		        e.printStackTrace();
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
