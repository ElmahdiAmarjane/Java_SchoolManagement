package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.*;
import db_connect.JDBC;
import modules.Absence;
import modules.Element;
import modules.Etudiant;
import modules.Professeur;
import modules.User;
import services.IProfesseurServices;

public class ProfesseurDao implements IProfesseurServices{

	@Override
	public boolean insertProfesseur(Professeur professeur) {
        String query = "INSERT INTO professeur (rip, doctorant_type, doctorant_mention, etablissement, cni_user, imagecv, Matiere_enseigne,type_contrat) VALUES (? ,? ,?, ?, ?, ?, ?, ?)";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the query
            preparedStatement.setInt(1, professeur.getRip());
            preparedStatement.setString(2, professeur.getDoctorant_type());
            preparedStatement.setString(3, professeur.getDoctorant_mention());
            preparedStatement.setString(4, professeur.getEtablissement());
            preparedStatement.setString(5, professeur.getCni_user());
            preparedStatement.setString(6, professeur.getImagecv());
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

	@Override
	public List<Professeur> selectAllProfesseur() {
		List<Professeur> professeurs = new ArrayList<>();
        String query = "SELECT * FROM professeur JOIN user ON professeur.cni_user = user.cni ";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Professeur prof = new Professeur();
                prof.setCni(resultSet.getString("cni"));
                prof.setNom(resultSet.getString("nom"));
                prof.setPrenom(resultSet.getString("prenom"));
                /*etd.setType_bac2(resultSet.getString("type_bac2"));
                etd.setNote_bac2(resultSet.getDouble("note_bac2"));
                etd.setId_filier(resultSet.getInt("id_filier"));
                etd.setCni_user(resultSet.getString("cni_user"));
                etd.setImageBac(resultSet.getString("imageBac"));
                etd.setImageBac2(resultSet.getString("imageBac2"));
                etd.setImageS1(resultSet.getString("imageS1"));
                etd.setImageS2(resultSet.getString("imageS2"));
                etd.setImageS3(resultSet.getString("imageS3"));
                etd.setImageS4(resultSet.getString("imageS4"));*/
                
                professeurs.add(prof);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professeurs;
	}
	
}
