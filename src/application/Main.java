package application;
	
import java.util.List;

import dao.EtudiantDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modules.Etudiant;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private void showMainApplication() throws Exception {
		
        // Load your main application FXML and show the main window
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/views/presence.fxml"));
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
			
			/* try {
		            EtudiantDao etudiantDao = new EtudiantDao();

		            // Fetch all students for id_filier = 1
		            List<Etudiant> etudiants = etudiantDao.selectAllEtudiants(1);

		            // Print each student's details
		            for (Etudiant etd : etudiants) {
		                System.out.println(etd.toString());
		            }

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
