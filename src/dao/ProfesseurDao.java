package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.json.*;
import db_connect.JDBC;
import modules.Absence;
import modules.Etudiant;
import modules.Professeur;
import modules.User;
import services.IProfesseurServices;

public class ProfesseurDao implements IProfesseurServices{

	@Override
	public boolean insertProfesseur(Professeur professeur) {
        String query = "INSERT INTO professeur (rip, doctorant_type, doctorant_mention, faculter, cni_user, imagecv, Matiere_enseigne,type_contrat) VALUES (? ,? ,?, ?, ?, ?, ?, ?)";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the query
            preparedStatement.setInt(1, professeur.getRip());
            preparedStatement.setString(2, professeur.getDoctorant_type());
            preparedStatement.setString(3, professeur.getDoctorant_mention());
            preparedStatement.setString(4, professeur.getEtablissement());
            preparedStatement.setString(5, professeur.getCni());
            preparedStatement.setString(6, professeur.getImage());
            preparedStatement.setString(7, professeur.getMatiere_enseigne());
            preparedStatement.setString(8, professeur.getType_contrat());
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
	        preparedStatement.setString(4, prof.getEtablissement());
	        preparedStatement.setString(5, prof.getImagecv());
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


	@Override
	public boolean absence(Absence absence) {
	    String query = "INSERT INTO absence (etudiants, date, heure_debut, heure_fine, id_filier, element_id) VALUES (?, ?, ?, ?, ?, ?)";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        connection.setAutoCommit(false); // Enable transaction management

	        // Convert the list of 'cne_etudiants' to a JSON string using org.json
	        JSONArray cneArray = new JSONArray(absence.getCne_etudiants()); // Convert list to JSONArray
	        String cneJson = cneArray.toString(); // Convert JSONArray to JSON string

	        // Set the parameters for the prepared statement
	        preparedStatement.setString(1, cneJson); // Store the JSON string
	        preparedStatement.setDate(2, absence.getDate());
	        preparedStatement.setTime(3, absence.getHeure_debut());
	        preparedStatement.setTime(4, absence.getHeure_fine());
	        preparedStatement.setInt(5, absence.getFilier_id());
	        preparedStatement.setInt(6, absence.getElement_id());

	        int rowsAffected = preparedStatement.executeUpdate();
	        connection.commit(); // Commit transaction after successful execution

	        if (rowsAffected > 0) {
	            System.out.println("Absence recorded successfully.");
	            return true;
	        } else {
	            System.out.println("Failed to record absence.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	       /* try {
	            connection.rollback(); // Roll back if there’s an error
	        } catch (SQLException rollbackException) {
	            rollbackException.printStackTrace();
	        }*/
	    }
	    return false;
	}
	
}
