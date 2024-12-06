package controllers;

import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modules.User;

import com.jfoenix.controls.JFXButton;

import dao.UserDao;

public class LoginViewController {
	
	User user=new User();
	UserDao userDao=new UserDao();

	@FXML
	private Pane LoginView;
	
    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private JFXButton txtButton;
    
    
    
    
    @FXML
    public void exit(ActionEvent event) {
    	System.exit(0);
    	
    }

    @FXML
    public void login(MouseEvent event) {
        /*if (isValidCredentials()) {
            openWelcomePage(event);
            showSuccessNotification("Login successful! Welcome back.");
        } else {
            showErrorNotification("Invalid username or password.");
        }*/
    	
    	
    	try {
    		
    			
    		user.setCni(txtUsername.getText());
    		user.setPassword(txtPassword.getText());
    		
    		User niveauxUser=userDao.login(user);
    		 
    		 if(niveauxUser!=null) {
    			 
    			 if(niveauxUser.getRole()=="Etudiant") {
    				 
    				/*FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/adminDashboard.fxml"));
     	            Parent homeView = loader.load();
     	            
     	            Stage stage = (Stage) ((Node) txtUsername).getScene().getWindow();
     	            Scene scene = new Scene(homeView);
     	            stage.setScene(scene);
     	            stage.show();*/
    				 
    				 System.out.print("Etudiant");
    				 
    			 }else if(niveauxUser.getRole()=="Professeur") {
    				 
    				 FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/professeurDashboard.fxml"));
      	            Parent homeView = loader.load();
      	            
      	            Stage stage = (Stage) ((Node) txtUsername).getScene().getWindow();
      	            Scene scene = new Scene(homeView);
      	            stage.setScene(scene);
      	            stage.show();
      	            
    			 }else {
    				 
    				FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/adminDashboard.fxml"));
      	            Parent homeView = loader.load();
      	            
      	            Stage stage = (Stage) ((Node) txtUsername).getScene().getWindow();
      	            Scene scene = new Scene(homeView);
      	            stage.setScene(scene);
      	            stage.show();
    			 }
    		 }else {
    			 
	    			 System.out.println("FALSE");
	    	         showErrorNotification("Invalid username or password.");
    		 }
    		 
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    private boolean isValidCredentials() {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        return "admin".equals(username) && "admin".equals(password);
    }

    private void openWelcomePage(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/WelcomePage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            ((Node) event.getSource()).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSuccessNotification(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorNotification(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
