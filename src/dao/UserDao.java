package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.AppFunctions;
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
                 user.setCni(resultSet.getString("cni"));
                 user.setRole(resultSet.getString("role"));
                 user.setEmail(resultSet.getString("email"));
                 user.setImage(resultSet.getString("image"));

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
        
       System.out.println(user.toString()); 
        return user;
    }

    public boolean insertUser(User user) {
        String query = "INSERT INTO user (cni, nom, prenom, image, role, tele, email, dateNaissance, password, nationalite, sexe,image_cni) VALUES (?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            preparedStatement.setDate(8, java.sql.Date.valueOf(user.getDateNaissance()));
            preparedStatement.setString(9, user.getPassword());
            preparedStatement.setString(10, user.getNationalite());
            preparedStatement.setString(11, user.getSexe());
            preparedStatement.setString(12, user.getImageCni());
            

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

	@Override
	public boolean deleteUser(String cni) {
		String query = "DELETE FROM user WHERE cni = ?";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, cni);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("USER deleted successfully.");
                return true;
            } else {
                System.out.println("Failed to delete USER.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}
    
	@Override
	public boolean updateUser(User user) {
	    String query = "UPDATE user SET nom = ?, prenom = ?, image = ?, role = ?, tele = ?, email = ?, dateNaissance = ?, password = ?, nationalite = ?, sexe = ?, image_cni = ? WHERE cni = ?";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        // Set parameters for the query
	        preparedStatement.setString(1, user.getNom());
	        preparedStatement.setString(2, user.getPrenom());
	        preparedStatement.setString(3, user.getImage());
	        preparedStatement.setString(4, user.getRole());
	        preparedStatement.setString(5, user.getTel());
	        preparedStatement.setString(6, user.getEmail());
	        preparedStatement.setDate(7, java.sql.Date.valueOf(user.getDateNaissance()));
	        preparedStatement.setString(8, user.getPassword());
	        preparedStatement.setString(9, user.getNationalite());
	        preparedStatement.setString(10, user.getSexe());
	        preparedStatement.setString(11, user.getImageCni());
	        preparedStatement.setString(12, user.getCni()); // WHERE condition

	        // Execute the update
	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("User updated successfully.");
	            return true;
	        } else {
	            System.out.println("Failed to update user.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
    //UPDATE USER
	
    /*public boolean updateEtudiant(Etudiant etudiant) {
        String query = "UPDATE etudiant SET nom = ?, prenom = ?, image = ?, password = ?, tel = ?, email = ?, dateNaissance = ?";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the parameters for the update
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setInt(3, etudiant.getAge());
            preparedStatement.setString(4, etudiant.getAdresse());
            preparedStatement.setString(5, etudiant.getCni());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Etudiant updated successfully.");
                return true;
            } else {
                System.out.println("Failed to update Etudiant.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }*/
    
	
	@Override
	public boolean resetPassword(String cni, String oldPassword, String newPassword) {
	    // Step 1: Verify the old password
	    String selectQuery = "SELECT password FROM user WHERE cni = ?";
	    String updateQuery = "UPDATE user SET password = ? WHERE cni = ?";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {

	        // Step 2: Check if the old password matches
	        selectStatement.setString(1, cni); // Set user CNI
	        ResultSet resultSet = selectStatement.executeQuery();

	        if (resultSet.next()) {
	            String storedPassword = resultSet.getString("password");

	            // Step 3: Compare old password with stored password
	            if (storedPassword.equals(oldPassword)) {
	                // Step 4: Update the password with the new one
	                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
	                    updateStatement.setString(1, newPassword); // Set the new password
	                    updateStatement.setString(2, cni); // Set user CNI for the WHERE clause
	                    int rowsAffected = updateStatement.executeUpdate();

	                    if (rowsAffected > 0) {
	                        System.out.println("Password updated successfully.");
	                        return true;
	                    } else {
	                        System.out.println("Failed to update the password.");
	                    }
	                }
	            } else {
	                System.out.println("Old password is incorrect.");
	            }
	        } else {
        		AppFunctions.showAlertSuccess("Échec", "L'ancien mot de passe est incorrect.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}
    
}