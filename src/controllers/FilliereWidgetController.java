package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class FilliereWidgetController extends FilliereController{
	
	
	
	@FXML
	 private ImageView filliereLogo ;
	@FXML
	 private Text filliereName;
	@FXML
	 private Text filliereShortName;
	@FXML
	  private Button fillereDetailsBtn;
	
	  // Méthode pour définir le titre
    public void setTitle(String title) {
    	filliereName.setText(title);
    }

    // Méthode pour définir le texte abrégé
    public void setShortName(String shortName) {
        filliereShortName.setText(shortName);
    }

    // Méthode pour définir l'image
    public void setImage(Image image) {
        filliereLogo.setImage(image);
    }
    
    
    public Pane loadFilliereWidget(String name, String shortName, Image image) throws Exception {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/filliereWidget.fxml"));
        Pane widget = loader.load();

        // Récupérer le contrôleur du fichier FXML
        FilliereWidgetController controller = loader.getController();

        
        // Configurer le widget
        controller.setTitle(name);
        controller.setShortName(shortName);
        controller.setImage(image);
       // controller.setButtonAction(buttonAction);

        return widget;
    }
    
   /* public void setFilliereDetailsToFront(){
    	
        // Charger le fichier FXML
    	try {
    		  FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/adminFilliere.fxml"));
    	        // Récupérer le contrôleur du fichier FXML
    	        FilliereController controller = loader.getController();

    	        controller.setFilliereDetailsToFront();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		
    	}
      
    	
    }
    */
    public void setFilliersMoreDetailstoFront() {
    	this.setFilliereDetailsToFront();
    }
	

}

