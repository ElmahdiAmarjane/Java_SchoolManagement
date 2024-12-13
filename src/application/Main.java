package application;
	
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Map;

import dao.EtudiantDao;
import dao.ProfesseurDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modules.Absence;
import modules.Etudiant;
import network.ChatServer2;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

// TEST
public class Main extends Application {
	
	private void showMainApplication() throws Exception {
		
        // Load your main application FXML and show the main window
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/views/loginView.fxml"));
        Parent mainRoot = mainLoader.load();
      
        Scene mainScene = new Scene(mainRoot); 
        Stage mainStage = new Stage();
        mainStage.setScene(mainScene);
        mainStage.setTitle("Main Application");
        mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

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
		 System.out.println("JavaFX Version: " + System.getProperty("javafx.version"));
		launch(args);
		//ChatServer2.runServer();
		//System.out.println("Hello MOhamed");
	}
	////////////////////////////////
	
	 // Crée un Map pour stocker des données par clé
    private static Map<String, Object> sessionData = new HashMap<>();

    // Méthode pour enregistrer les données dans la session
    public static void set(String key, Object value) {
        sessionData.put(key, value);
    }

    // Méthode pour récupérer les données de la session
    public static Object get(String key) {
        return sessionData.get(key);
    }

    // Méthode pour vérifier si une donnée existe dans la session
    public static boolean contains(String key) {
        return sessionData.containsKey(key);
    }
	
	
	
	
	
	
	
	
}
