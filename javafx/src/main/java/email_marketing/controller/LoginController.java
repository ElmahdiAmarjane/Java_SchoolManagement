package email_marketing.controller;

import email_marketing.Cookies;
import email_marketing.model.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
	private Cookies cookies= new Cookies();

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink signupLink;

    private User currentUser;

    @FXML
    private Button minimizeButton;

    @FXML
    private Button closeButton;

    @FXML
    private AnchorPane root;

    @FXML
    void handleMinimize(ActionEvent event) {
        Stage stage = (Stage) minimizeButton.getScene().getWindow();
        stage.setIconified(true);
    }


  

    @FXML
    void handleClose() {
    	System.exit(0);
    }

    private void enableWindowDragging() {
        final Delta dragDelta = new Delta();

        root.setOnMousePressed(event -> {
            dragDelta.x = event.getSceneX();
            dragDelta.y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setX(event.getScreenX() - dragDelta.x);
            stage.setY(event.getScreenY() - dragDelta.y);
        });
    }

    private static class Delta {
        double x, y;
    }

    @FXML
    public void initialize() {
    	Platform.runLater(() -> {
	        try {
	        	User existingUser = cookies.chargerDonnees();
	            if (existingUser != null) {
	            	redirectToDashboard();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    });
      

        enableWindowDragging();
    }

    @FXML
    void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Username and password are required.");
            return;
        }

        User user = User.login(username, password);
        if (user != null) {
            currentUser = user;
            try {
				cookies.sauvegarderDonnees(user);
			} catch (IOException e) {
				e.printStackTrace();
			}
            redirectToDashboard();
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    @FXML
    void goToSignup(ActionEvent event) {
        try {
            Parent signupRoot = FXMLLoader.load(getClass().getResource("/fxml/signup.fxml"));
            Stage stage = (Stage) signupLink.getScene().getWindow();
            stage.setScene(new Scene(signupRoot));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void redirectToDashboard() {
        try {
            Parent dashboardRoot = FXMLLoader.load(getClass().getResource("/fxml/dashBoard.fxml"));
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(dashboardRoot));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


