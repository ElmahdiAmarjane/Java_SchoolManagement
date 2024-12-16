package controllers;

import java.io.IOException;
import dao.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modules.SceneSwitch;
import modules.User;

public class AuthController {

    private final UserDao userDao = new UserDao();
    private final User user = new User();

    @FXML
    private TextField cni, password;

    @FXML
    private Pane loginview;

    @FXML
    public void login() {
        try {
            user.setCni(cni.getText().trim());
            user.setPassword(password.getText().trim());

            if (userDao.login(user) != null) { 
                new SceneSwitch(loginview, "/views/addUser.fxml");
            } else {
                System.out.println("Login failed. User not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading new scene.");
        }
    }
}
