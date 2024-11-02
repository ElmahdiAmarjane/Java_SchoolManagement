package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import modules.User;
import javafx.scene.control.TextField;
import java.io.File;
import dao.UserDao;

public class AddUser {
    
    User user = new User();
    UserDao userDao = new UserDao();

    @FXML
    private TextField nom, prenom, cni, tele, email, password, date_naissance ;
    
    @FXML
    private ComboBox<String> role; 
    
    @FXML
    private ImageView userImageView; 

    String filePath;

    @FXML
    public void initialize() {
        // Populate the ComboBox with roles
        ObservableList<String> roles = FXCollections.observableArrayList("Etudiant", "Admin", "Professeur");
        role.setItems(roles);
        
        // Update password field with CNI value
        cni.textProperty().addListener((observable, oldValue, newValue) -> {
            password.setText(newValue);
        });
    }

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
            filePath = file.toURI().toString();

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
        // Check if the image was selected
        if (filePath == null) {
            // Show an alert if no image has been selected
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Image Not Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select an image before inserting the user.");
            alert.showAndWait();
            return false; // Indicate that the operation failed
        }

        // Set user details
        user.setCni(cni.getText());
        user.setNom(nom.getText());
        user.setPrenom(prenom.getText());
        user.setRole(role.getValue());
        user.setPassword(cni.getText());
        user.setTel(tele.getText());
        user.setEmail(email.getText());
        user.setDateNaissance(date_naissance.getText()); // Set birth date
        user.setImage(filePath);

        // Attempt to insert user and return result
        return userDao.insertUser(user);
    }
}
