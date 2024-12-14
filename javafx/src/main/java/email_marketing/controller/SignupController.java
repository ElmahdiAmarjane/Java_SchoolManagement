package email_marketing.controller;

import email_marketing.Cookies;
import email_marketing.model.User;
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

public class SignupController {
	private Cookies cookies= new Cookies();

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button signupButton;

    @FXML
    private Hyperlink loginLink;

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

    public static class Delta {
        double x, y;
    }

    @FXML
    public void initialize() {

        enableWindowDragging();
    }

    @FXML
    void handleSignup(ActionEvent event) {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Sign-up Failed", "All fields are required.");
            return;
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            showAlert(Alert.AlertType.ERROR, "Sign-up Failed", "Invalid email format.");
            return;
        }

        if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*\\d.*")) {
            showAlert(Alert.AlertType.ERROR, "Sign-up Failed", "Password must be at least 8 characters long and include uppercase, lowercase, and a number.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlert(Alert.AlertType.ERROR, "Sign-up Failed", "Passwords do not match.");
            return;
        }

        if (User.signup(username, email, confirmPassword)) {
        	User user = User.login(username, password);
            
                try {
    				cookies.sauvegarderDonnees(user);
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
        	redirectToDashboard();
        } else {
            showAlert(Alert.AlertType.ERROR, "Sign-up Failed", "User could not be registered.");
        }
    }

    @FXML
    void goToLogin(ActionEvent event) {
        try {
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            Stage stage = (Stage) loginLink.getScene().getWindow();
            stage.setScene(new Scene(loginRoot));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void redirectToDashboard() {
        try {
            Parent dashboardRoot = FXMLLoader.load(getClass().getResource("/fxml/dashBoard.fxml"));
            Stage stage = (Stage) usernameField.getScene().getWindow();
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
