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
	public boolean updateProfesseur(Professeur professeur) {
	    String query = "UPDATE professeur SET doctorant_type = ?, doctorant_mention = ?, etablissement = ?, imagecv = ?, Matiere_enseigne = ?, type_contrat = ? WHERE cni_user = ?";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        preparedStatement.setString(1, professeur.getDoctorant_type());
	        preparedStatement.setString(2, professeur.getDoctorant_mention());
	        preparedStatement.setString(3, professeur.getEtablissement());
	        preparedStatement.setString(4, professeur.getImagecv());
	        preparedStatement.setString(5, professeur.getMatiere_enseigne());
	        preparedStatement.setString(6, professeur.getType_contrat());
	        preparedStatement.setString(7, professeur.getCni_user()); 

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

	        connection.setAutoCommit(false); 

	        JSONArray cneArray = new JSONArray(absence.getCne_etudiants()); 
	        String cneJson = cneArray.toString(); 

	        preparedStatement.setString(1, cneJson); 
	        preparedStatement.setDate(2, java.sql.Date.valueOf(absence.getDate().toString()) );
	        preparedStatement.setTime(3, absence.getHeure_debut());
	        preparedStatement.setTime(4, absence.getHeure_fine());
	        preparedStatement.setString(5, absence.getFilier_titel());
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
                prof.setMatiere_enseigne(resultSet.getString("Matiere_enseigne"));
                prof.setType_contrat(resultSet.getString("type_contrat"));;
                
                professeurs.add(prof);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professeurs;
	}


	@Override
	public Professeur selectProfesseur(String cni) {
		Professeur prof = null; // Initialize to null to indicate no data if not found
	    String query = "SELECT * FROM professeur JOIN user ON professeur.cni_user = user.cni WHERE user.cni = ?";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        preparedStatement.setString(1, cni);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) { // Check if a row exists
	        	prof = new Professeur(); // Instantiate the object only when data is found
	        	prof.setCni(resultSet.getString("cni"));
	        	prof.setNom(resultSet.getString("nom"));
	        	prof.setSexe(resultSet.getString("sexe"));
	        	prof.setPrenom(resultSet.getString("prenom"));
	        	prof.setTel(resultSet.getString("tele"));
	        	prof.setCni_user(resultSet.getString("cni_user"));
	        	prof.setEmail(resultSet.getString("email"));
	        	prof.setPassword(resultSet.getString("password"));
	        	prof.setDateNaissance(resultSet.getDate("dateNaissance").toLocalDate());
	        	prof.setNationalite(resultSet.getString("nationalite"));
	        	
	        	prof.setDoctorant_type(resultSet.getString("doctorant_type"));
	        	prof.setDoctorant_mention(resultSet.getString("doctorant_mention"));
	        	prof.setMatiere_enseigne(resultSet.getString("Matiere_enseigne"));
	        	prof.setType_contrat(resultSet.getString("type_contrat"));
	        	prof.setRip(resultSet.getInt("rip"));
	        	prof.setEtablissement(resultSet.getString("etablissement"));
	        	
	        	prof.setImageCni(resultSet.getString("image_cni"));
	        	prof.setImagecv(resultSet.getString("imagecv"));
	        	prof.setImage(resultSet.getString("image"));
	        	
	        	
	            
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return prof;
	}
	
}
