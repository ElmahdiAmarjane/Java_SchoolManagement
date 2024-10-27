package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.Query;

import db_connect.JDBC;
import modules.Etudiante;
import modules.User;
import services.IUserServices;

public class UserDao implements IUserServices{

	@Override 
	public User login(User user) {
	        //User user = null;
	        String query = "SELECT * FROM user WHERE cni = ? AND password = ?";

	        try (Connection connection = JDBC.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            // Set parameters for the query
	            preparedStatement.setString(1, user.getCni());
	            preparedStatement.setString(2, user.getPassword());

	            // Execute the query
	            ResultSet resultSet = preparedStatement.executeQuery();

	            // If user found, initialize the User object
	            if (resultSet.next()) {
	                //user = new User("D136110674","MOHAMED","BOUKOUCH","aa");
	            	
	            	String role = resultSet.getString("role");
	            	
	            	if("etudiant".equalsIgnoreCase(role))
	            		System.out.println("Etudiant");
	            	else if("professeur".equalsIgnoreCase(role))
	            		System.out.println("Professeur");
	            	else if("admin".equalsIgnoreCase(role))
	            		System.out.println("Admin");
	            	else
	            		System.out.println("Error 404");
	                
	            }else {
	            	System.out.println("USER IS NOOOOT FOUNDED");
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
	        preparedStatement.setString(8, user.getDateNaissance());  // assuming this is a String, change to Date if needed
	        preparedStatement.setString(9, user.getPassword());

	        // Execute the update
	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("User inserted successfully.");
	            return true;
	        } else {
	            System.out.println("Failed to insert User.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
}
