package controllers;

import javafx.event.ActionEvent;
import java.io.IOException;

import application.Main;
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



import dao.UserDao;

public class LoginViewController {
	
	User user=new User();
	UserDao userDao=new UserDao();
	//ChatController chatController = new ChatController();

	@FXML
	private Pane LoginView;
	
    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

  
    
    
    
    
    @FXML
    public void exit(ActionEvent event) {
    	System.exit(0);
    	
    }
    
 // Declare the FXMLLoader and controller at a higher scope if needed


 
  

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
    		System.out.println("imhere after login");
    		 System.out.println(niveauxUser.toString()); 
    		 if(niveauxUser!=null) {
    			 /////////////////////////////////////
    			 Main.set("connectedUser", niveauxUser);
    			 
    			 
    			 /////////////////////////////////////
    			 System.out.println("role user : "+niveauxUser.getRole()); 
    			 if(niveauxUser.getRole().equals("Etudiant")) {
    				 System.out.println("inside etudiant");
    				FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/studentDash/studentDashboard.fxml"));
     	            Parent homeView = loader.load();
     	           AdminController adminController = loader.getController(); // Get the controller
     	             adminController.setloggedInUserData(niveauxUser);
     	            Stage stage = (Stage) ((Node) txtUsername).getScene().getWindow();
     	            Scene scene = new Scene(homeView);
     	            stage.setScene(scene);
     	           ///////////////////////////
     	           
       			 
     	           if (adminController != null && adminController.getChatController() != null) {
         	            // Pass the logged-in user to the chat controller
     	        	  adminController.getChatController().setLoggedInUser(niveauxUser);
         	        } else {
         	            System.out.println("ChatController is not initialized!");
         	        }
         	        
       			 ////////////////////////////
       			 
       			 
     	            stage.show();
    				 
    				 System.out.println("TTT : Etudiant");
    				 		 
    				 
    			 }
    			 
    			 else if(niveauxUser.getRole().equals("Professeur")) {
    				 
    				 FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/professeurDashboard.fxml"));
      	            Parent homeView = loader.load();
      	          ProfesseurDashboardController professeurController = loader.getController(); // Get the controller
      	        professeurController.setloggedInUserData(niveauxUser);
      	            Stage stage = (Stage) ((Node) txtUsername).getScene().getWindow();
      	            Scene scene = new Scene(homeView);
      	            stage.setScene(scene);
      	            stage.show(); 
      	          System.out.println("TTT : Professeur");
      	          
      	          ///////////////////////////////
      	        // Initialize chat view if not already initialized
      	        // Now access the chat controller from professeurDashboardController
      	        if (professeurController != null && professeurController.getChatController() != null) {
      	            // Pass the logged-in user to the chat controller
      	            professeurController.getChatController().setLoggedInUser(niveauxUser);
      	        } else {
      	            System.out.println("ChatController is not initialized!");
      	        }
      	        
      	       
      	          
      	        
      	          ///////////////////////////////
      	       
      	        
    			 }
    			 else {
    				 
    				FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/adminDashboard.fxml"));
      	            Parent homeView = loader.load();
      	          AdminController adminController = loader.getController(); // Get the controller
        	        adminController.setloggedInUserData(niveauxUser);
      	            Stage stage = (Stage) ((Node) txtUsername).getScene().getWindow();
      	            Scene scene = new Scene(homeView);
      	            stage.setScene(scene);
      	            stage.show();
      	          System.out.print("TTT : Admin");
    			 }
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