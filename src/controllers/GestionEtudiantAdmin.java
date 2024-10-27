package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import modules.User;
import javafx.scene.control.TextField;
import java.io.File;

import dao.UserDao;

public class GestionEtudiantAdmin {
	
	User user = new User();
	UserDao userDao = new UserDao();

	@FXML
    private TextField nom, prenom, cni, role, tele, email, password;
	
	@FXML
	    private ImageView userImageView; 

	 
	    @FXML
	    public void handleSelectImage() {
	        // Create a FileChooser to select an image file
	        FileChooser fileChooser = new FileChooser();
	        fileChooser.setTitle("Select Image");
	        fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
	        );

	        // Show the open file dialog
	        File file = fileChooser.showOpenDialog(userImageView.getScene().getWindow());
	        
	        if (file != null) {
	            // Get the file path
	            String filePath = file.toURI().toString();

	            // Display the image in the ImageView
	            Image image = new Image(filePath);
	            userImageView.setImage(image);

	            // Optional: print the file path
	            System.out.println("Image path: " + filePath);
	        } else {
	            // If no file is selected, show an alert
	            Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("No Image Selected");
	            alert.setHeaderText(null);
	            alert.setContentText("Please select an image file.");
	            alert.showAndWait();
	        }
	    }
	    
	    
	    public boolean insertUser() {
	    	
	    	user.setCni(cni.getText());
	    	user.setNom(nom.getText());
	    	user.setPrenom(prenom.getText());
	    	user.setRole(role.getText());
	    	user.setPassword(password.getText());
	    	user.setTel(tele.getText());
	    	user.setEmail(email.getText());
	    	user.setDateNaissance("03-07-2003");
	    	user.setImage("dd");
	    	
	    	return userDao.insertUser(user);
	    	//user= User(cni.getText(),nom.getText(),prenom.getText(),role.getText(),password.getText(),tel.getText(),email.getText());	
	    }
}
