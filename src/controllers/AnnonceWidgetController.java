package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modules.Annonce;

public class AnnonceWidgetController {

	///WIDGET ATTRIBUTES ///////
	@FXML private Label announcementHeader;
	
	@FXML private Label announcementText;
	
	@FXML private Text announcementTitle;
	
	@FXML private Label announcementDate;
	
	@FXML private Button downloadButton;
	@FXML private Text annonceId;
	
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
    
    public Pane loadAnnonceWidget(String title, String contenu , String date,String id) throws Exception {
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
       // controller.setButtonAction(buttonAction);

        return widget;
    }
    
    @FXML
    private ImageView showAnnonceDetailsBtn;

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
   
    
}
