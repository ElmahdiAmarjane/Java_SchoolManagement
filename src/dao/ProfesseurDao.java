package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db_connect.JDBC;
import modules.Etudiant;
import modules.Professeur;
import modules.User;
import services.IProfesseurServices;

public class ProfesseurDao implements IProfesseurServices{

	@Override
	public boolean insertProfesseur(Professeur professeur) {
        String query = "INSERT INTO professeur (rip, doctorant_type, doctorant_mention, faculter, cni_user, cv) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the query
            preparedStatement.setInt(1, professeur.getRip());
            preparedStatement.setString(2, professeur.getDoctorant_type());
            preparedStatement.setString(3, professeur.getDoctorant_mention());
            preparedStatement.setString(4, professeur.getFaculter());
            preparedStatement.setString(5, professeur.getCni());
            preparedStatement.setString(6, professeur.getCv());

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Professeur inserted successfully.");
                return true;
            } else {
                System.out.println("Failed to insert Professeur.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	@Override
	public boolean deleteProfesseur(String cni) {
        String query = "DELETE FROM user WHERE cni = ?";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, cni);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Professeur deleted successfully.");
                return true;
            } else {
                System.out.println("Failed to delete Professeur.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	
	@Override
	public boolean updateProfesseur(Professeur prof) {
	    String query = "UPDATE professeur SET rip = ?, doctorant_type = ?, doctorant_mention = ?, faculter = ?, cv = ? WHERE cni_user = ?";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        // Set the parameters for the update
	        preparedStatement.setInt(1, prof.getRip());
	        preparedStatement.setString(2, prof.getDoctorant_type());
	        preparedStatement.setString(3, prof.getDoctorant_mention());
	        preparedStatement.setString(4, prof.getFaculter());
	        preparedStatement.setString(5, prof.getCv());
	        preparedStatement.setString(6, prof.getCni_user());

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Professeur updated successfully.");
	            return true;
	        } else {
	            System.out.println("Failed to update Professeur.");
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
}
