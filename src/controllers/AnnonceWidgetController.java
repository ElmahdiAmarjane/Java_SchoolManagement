package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class AnnonceWidgetController {

	///WIDGET ATTRIBUTES ///////
	@FXML private Label announcementHeader;
	
	@FXML private Label announcementText;
	
	@FXML private Text announcementTitle;
	
	@FXML private Label announcementDate;
	
	@FXML private Button downloadButton;
	
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
    
    public Pane loadAnnonceWidget(String title, String contenu , String date) throws Exception {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/annoncesWidget.fxml"));
        Pane widget = loader.load();

        AnnonceWidgetController controller = loader.getController();
       
        // Configurer le widget
        controller.announcementHeader.setText("Administration");
        controller.announcementTitle.setText(title);
        controller.announcementText.setText(contenu);
        controller.announcementDate.setText(date);
       // controller.setButtonAction(buttonAction);

        return widget;
    }
 
    
}
