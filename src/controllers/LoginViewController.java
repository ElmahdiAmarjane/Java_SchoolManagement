package controllers;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

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
        try {
            // Set the user's CNI and password from the text fields
            user.setCni(txtUsername.getText());
            user.setPassword(txtPassword.getText());

            // Attempt to log in the user using the DAO
            User niveauxUser = userDao.login(user);

            if (niveauxUser != null) {
            	
            	FXMLLoader loader;
                Parent homeView;
                
                String role = niveauxUser.getRole();

                if ("Professeur".equalsIgnoreCase(role)) {
                	
                    System.out.println("Professeur HH");
                    
                    /*URL url = getClass().getResource("/views/professeurDashboard.fxml");
                    if (url == null) {
                	    throw new RuntimeException("FXML file not found: /views/professeurDashboard.fxml");
                	} else {
                	    System.out.println("FXML file found successfully: " + url);
                	}
                    loader = new FXMLLoader(url);
                    homeView = loader.load();
                    Stage stage = (Stage) ((Node) txtUsername).getScene().getWindow();
                    Scene scene = new Scene(homeView);
                    stage.setScene(scene);
                    stage.show();*/
                	
                    
                    loader = new FXMLLoader(getClass().getResource("/views/professeurDashboard.fxml"));
                    Pane nextPane = loader.load();

                    professeurDashboardController controller = loader.getController();
                    //controller.setCniValue(cni); 

                    LoginView.getChildren().clear();
                    LoginView.getChildren().add(nextPane);
                	


                } else if ("Etudiant".equalsIgnoreCase(role)) {
                    System.out.println("Etudiant");
                    
                    /*URL url = getClass().getResource("/views/professeurDashboard.fxml");
                    if (url != null) {
                        System.out.println("FXML file not found: /Views/professeurDashboard.fxml");
                    }
                    loader = new FXMLLoader(url);
                    homeView = loader.load();*/
                    
                } else if("Admin".equalsIgnoreCase(role)){
                    System.out.println("Admin");
                    
                    URL url = getClass().getResource("/views/adminDashboard.fxml");
                    if (url != null) {
                        System.out.println("FXML file not found: ");
                    }
                    loader = new FXMLLoader(url);
                    homeView = loader.load();
                    Stage stage = (Stage) ((Node) txtUsername).getScene().getWindow();
                    Scene scene = new Scene(homeView);
                    stage.setScene(scene);
                    stage.show();
                    
                    
                    
                    
                }
                
                
            } else {
                // Show an error message if login fails
                System.out.println("Invalid CNI or password.");
            }
            
            
        } catch (Exception e) {
            // Log the exception and provide feedback
            e.printStackTrace();
            System.out.println("An error occurred during login.");
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
