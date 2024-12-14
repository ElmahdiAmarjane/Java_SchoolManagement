package controllers;

import java.io.File;
import java.io.IOException;

import application.Main;
import cloudinary.CloudinaryUploader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modules.Annonce;
import modules.User;

public class AnnonceWidgetController {

	///WIDGET ATTRIBUTES ///////
	@FXML private Label announcementHeader;
	
	@FXML private Label announcementText;
	
	@FXML private Text announcementTitle;
	
	@FXML private Label announcementDate;
	
	@FXML private Button downloadButton;
	@FXML private Text annonceId;
	@FXML private Text annonceFilePath;
	@FXML private ImageView showAnnonceDetailsBtn;
	
	 // Setter for the announcement header
    public void setAnnouncementHeaderText(String text) {
        announcementHeader.setText(text);
    }

    // Setter for the announcement body text
    public void setAnnouncementText(String text) {
        announcementText.setText(text);
    }

    // Setter for the announcement title
    public void setAnnouncementTitleText(String text) {
        announcementTitle.setText(text);
    }

    // Setter for the announcement date
    public void setAnnouncementDateText(String text) {
        announcementDate.setText(text);
    }

    // Setter for the download button text
    public void setDownloadButtonText(String text) {
        downloadButton.setText(text);
    }
    
    public Pane loadAnnonceWidget(String title, String contenu , String date,String id , String filePath) throws Exception {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/annoncesWidget.fxml"));
        Pane widget = loader.load();

        AnnonceWidgetController controller = loader.getController();
       
        // Configurer le widget
        controller.announcementHeader.setText("Administration");
        controller.annonceId.setText(id);
        controller.announcementTitle.setText(title);
        controller.announcementText.setText(contenu);
        controller.announcementDate.setText(date);
        controller.annonceFilePath.setText(filePath);
        User user = (User) Main.get("connectedUser");
        if(!user.getRole().equals("Admin")){
        	controller.showAnnonceDetailsBtn.setVisible(false);
        }
        if (filePath == null || filePath.trim().isEmpty()) {
            downloadButton.setStyle("-fx-background-color :red;");
        }
       // controller.downloadButton.setOnAction(e->{ 	downloadAnnonceFile(filePath);});

        return widget;
    }
    
  

    @FXML
    public void handleUpdateAnnonceBtn() {
        try {
            // Load the adminAnnounce.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/annonceRUD.fxml"));
            Parent updateRoot = loader.load();

            // Set up the stage
            Stage updateStage = new Stage();
            updateStage.setTitle("Update Announcement");
            updateStage.setScene(new Scene(updateRoot));
            //make announce data object
            Annonce annonce = new Annonce();
            annonce.setTitle(announcementTitle.getText());
            annonce.setContenu(announcementText.getText());
            annonce.setId(Integer.parseInt(annonceId.getText()));
            //annonce.setFile()
            // Optional: Pass data to the AdminAnnounceController if needed
            AnnonceController annonceController = loader.getController();
            annonceController.setAnnonceDetailsData(annonce); // Pass relevant data if necessary
            annonceController.setDetailsAnnonceStage(updateStage);
            // Show the stage
            updateStage.initModality(Modality.APPLICATION_MODAL); // Block interaction with other stages until closed
            updateStage.setResizable(false);
            updateStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //////////////////////////////////////////////
    /////////////////////////////////////////////////
    private static AnnonceController mainController; // Reference to the main controller

    public static void  setMainController(AnnonceController mainController1) {
        mainController = mainController1;
    }

    @FXML
    public void openAnnonceRUDStage() throws IOException {
        if (mainController == null) {
            System.out.println("Main controller is not set!");
            return;
        }

        // Load the annonceRUD.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/annonceRUD.fxml"));
        Parent root = loader.load();
        Annonce annonce = new Annonce();
        System.out.println("OKKK : "+announcementTitle.getText());
        annonce.setTitle(announcementTitle.getText());
        annonce.setContenu(announcementText.getText());
        annonce.setId(Integer.parseInt(annonceId.getText()));
        // Use the existing main controller (shared)
        AnnonceController rudController = loader.getController();
        rudController.setAnnonceDetailsData(annonce); // Pass the selected annonce

        // Create and show the new stage
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Annonce Details");
        rudController.setDetailsAnnonceStage(stage); // Set the stage to enable closing
        stage.show();
    }
    
    public void downloadAnnonceFile() {
        System.out.println("helloCloud");

        // Get the file path (URL) and check if it's valid
        String filePath = annonceFilePath.getText();
        if (filePath == null || filePath.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Chemin du fichier manquant");
            alert.setContentText("Veuillez entrer un chemin de fichier valide.");
            alert.showAndWait();
            return;
        }

        CloudinaryUploader uploader = new CloudinaryUploader();

        // Extract the file extension from the URL
        String fileExtension = "";
        int dotIndex = filePath.lastIndexOf('.');
        if (dotIndex != -1 && dotIndex < filePath.length() - 1) {
            fileExtension = filePath.substring(dotIndex); // Includes the dot (e.g., ".pdf")
        }

        // Suggest a default file name
        String defaultFileName = announcementTitle.getText();
        if (defaultFileName == null || defaultFileName.trim().isEmpty()) {
            defaultFileName = "fichier"; // Fallback default name
        }
        defaultFileName = defaultFileName.replaceAll("[\\\\/:*?\"<>|]", "_"); // Sanitize file name
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", "*.*"));
        fileChooser.setInitialFileName(defaultFileName + fileExtension);

        // Show the "Save As" dialog
        fileChooser.setTitle("Sélectionner un emplacement pour enregistrer le fichier");
        File fileToSave = fileChooser.showSaveDialog(announcementText.getScene().getWindow());

        if (fileToSave != null) {
            // Ensure the file has the correct extension
            File finalFile = fileToSave;
            if (!fileToSave.getName().endsWith(fileExtension)) {
                finalFile = new File(fileToSave.getAbsolutePath() + fileExtension);
            }

            // Download the file
            try {
                uploader.downloadAnnonceFile(filePath, finalFile.getAbsolutePath());

                // Success alert
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Téléchargement Réussi");
                alert.setHeaderText("Fichier téléchargé avec succès !");
                alert.setContentText("Le fichier a été enregistré à l'emplacement sélectionné.");
                alert.showAndWait();
            } catch (Exception e) {
                // Failure alert
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Échec du Téléchargement");
                alert.setHeaderText("Erreur lors du téléchargement");
                alert.setContentText("Le fichier n'a pas pu être téléchargé. Veuillez réessayer.");
                alert.showAndWait();
                e.printStackTrace();
            }
        } else {
            // Cancel warning in French
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Téléchargement Annulé");
            alert.setHeaderText("Aucun emplacement sélectionné");
            alert.setContentText("Le fichier ne sera pas téléchargé si aucun emplacement n'est sélectionné.");
            alert.showAndWait();
        }
    }
   
}
