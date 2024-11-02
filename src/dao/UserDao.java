package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db_connect.JDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import modules.Etudiant;
import modules.User;
import services.IUserServices;

public class UserDao implements IUserServices {


    @Override
    public User login(User user) {
        String query = "SELECT * FROM user WHERE cni = ? AND password = ?";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            
            preparedStatement.setString(1, user.getCni());
            preparedStatement.setString(2, user.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String role = resultSet.getString("role");

                switch (role.toLowerCase()) {
                    case "etudiant":
                        System.out.println("Etudiant");
                        break;
                    case "professeur":
                        System.out.println("Professeur");
                        break;
                    case "admin":
                        System.out.println("Admin");
                        break;
                    default:
                        System.out.println("Role not recognized.");
                        break;
                }
            } else {
                user=null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean insertUser(User user) {
        String query = "INSERT INTO user (cni, nom, prenom, image, role, tele, email, dateNaissance, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the query
            preparedStatement.setString(1, user.getCni());
            preparedStatement.setString(2, user.getNom());
            preparedStatement.setString(3, user.getPrenom());
            preparedStatement.setString(4, user.getImage());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getTel());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, user.getDateNaissance());
            preparedStatement.setString(9, user.getPassword());

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User inserted successfully.");
                return true;
            } else {
                System.out.println("Failed to insert user.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
