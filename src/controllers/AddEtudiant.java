package controllers;

import java.io.File;

import dao.EtudiantDao;
import dao.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import modules.Etudiant;
import modules.User;

public class AddEtudiant {

	Etudiant etudiant=new Etudiant();
	User user=new User();
	
	EtudiantDao etudiantDao=new EtudiantDao();
	UserDao userDao = new UserDao();
	
    @FXML
    private TextField nom, prenom, cne, cni, tele, email, password, date_naissance, bac_note, bac_type,ecole,bac2_note,bac2_type,filier;
    @FXML
    private ImageView userImageView, imageBac,imageBac2,imageS1,imageS2,imageS3,imageS4, imageCartNational, imageExtrai;
    @FXML
    private ComboBox<String> sexe, nationaliter;
    
    String imagepath;
    String imageBacpath;
    String imageBac2path;
    String imageS1path;
    String imageS2path;
    String imageS3path;
    String imageS4path;
    String imageCartNationalpath;
    String imageExtraipath;

    public void initialize() {
        sexe.getItems().addAll("Male", "Female");
        nationaliter.getItems().addAll("Moroccan", "Other");
    }

    @FXML
    private void handleSelectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            userImageView.setImage(image);
            imagepath = file.toURI().toString();
        }
    }
    
    @FXML
    private void selectBac() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageBac.setImage(image);
            imageBacpath = file.toURI().toString();
        }
    }
    
    @FXML
    private void selectBac2() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageBac2.setImage(image);
            imageBac2path = file.toURI().toString();
        }
    }
    
    @FXML
    private void selectS1() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageS1.setImage(image);
            imageS1path = file.toURI().toString();
        }
    }
    
    @FXML
    private void selectS2() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageS2.setImage(image);
            imageS2path = file.toURI().toString();
        }
    }
    
    @FXML
    private void selectS3() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageS3.setImage(image);
            imageS3path = file.toURI().toString();
        }
    }
    
    @FXML
    private void selectS4() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageS4.setImage(image);
            imageS4path = file.toURI().toString();
        }
    }
    
    @FXML
    private void selectCartNationl() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageCartNational.setImage(image);
            imageCartNationalpath = file.toURI().toString();
        }
    }
    
    @FXML
    private void selectExtrai() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageExtrai.setImage(image);
            imageExtraipath = file.toURI().toString();
        }
    }
    
    @FXML
    private void btn_aaddEtd() {
    	
        user.setCni(cni.getText());
        user.setNom(nom.getText());
        user.setPrenom(prenom.getText());
        user.setRole("Etudiant");
        user.setPassword(cni.getText());
        user.setTel(tele.getText());
        user.setEmail(email.getText());
        user.setDateNaissance(date_naissance.getText()); // Set birth date
        user.setImage(imagepath);

       

        // Convert the text from filier TextField to integer and set it
        try {
            int idFilier = Integer.parseInt(filier.getText());
            etudiant.setId_filier(idFilier);
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid number for the filier field.");
            return;
        }

        etudiant.setCne(cne.getText());
        etudiant.setNote_bac(Double.parseDouble(bac_note.getText())); // Assuming bac_note is a numeric TextField
        etudiant.setType_bac(bac_type.getText());
        etudiant.setNote_bac2(Double.parseDouble(bac2_note.getText())); // Assuming bac2_note is a numeric TextField
        etudiant.setType_bac2(bac2_type.getText());
        etudiant.setCni_user(cni.getText());
        etudiant.setImageBac(imageBacpath);
        etudiant.setImageBac2(imageBac2path);
        etudiant.setImageS1(imageS1path);
        etudiant.setImageS2(imageS2path);
        etudiant.setImageS3(imageS3path);
        etudiant.setImageS4(imageS4path);

        if (userDao.insertUser(user)) {
            etudiantDao.insertEtudiant(etudiant);
        	
        }
    	
    	
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
  //DELET ETUDIANT
    public boolean deleteEtudiant(){
    	return etudiantDao.deleteEtudiant("med");
    }
    
    
}
