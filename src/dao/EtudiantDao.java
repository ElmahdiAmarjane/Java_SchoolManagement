package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db_connect.JDBC;
import modules.Etudiant;
import modules.User;
import services.IEtudiantServices;

public class EtudiantDao implements IEtudiantServices{

	@Override
	public boolean insertEtudiant(Etudiant etd) {
        String query = "INSERT INTO etudiant (cne, type_bac, note_bac, type_bac2, note_bac2, titel_filier, cni_user, imageBac, imageBac2,imageS1,imageS2,imageS3,imageS4,anneeBac,universityBac2,etablismentBac2,noteS1,noteS2,noteS3,noteS4,anneeS1,anneeS2,anneeS3,anneeS4,relverBac) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the query
            preparedStatement.setString(1, etd.getCne());
            preparedStatement.setString(2, etd.getType_bac());
            preparedStatement.setDouble(3, etd.getNote_bac());
            preparedStatement.setString(4, etd.getType_bac2());
            preparedStatement.setDouble(5, etd.getNote_bac2());
            preparedStatement.setString(6, etd.getFilier_titel());
            preparedStatement.setString(7, etd.getCni_user());
            preparedStatement.setString(8, etd.getImageBac());
            preparedStatement.setString(9, etd.getImageBac2());
            preparedStatement.setString(10, etd.getImageS1());
            preparedStatement.setString(11, etd.getImageS2());
            preparedStatement.setString(12, etd.getImageS3());
            preparedStatement.setString(13, etd.getImageS4());
            preparedStatement.setInt(14, etd.getAnneBac());
            preparedStatement.setString(15, etd.getUniversity());
            preparedStatement.setString(16, etd.getEtablisment_bac2());
            preparedStatement.setDouble(17, etd.getNote_S1());
            preparedStatement.setDouble(18, etd.getNote_S2());
            preparedStatement.setDouble(19, etd.getNote_S3());
            preparedStatement.setDouble(20, etd.getNote_S4());
            preparedStatement.setInt(21, etd.getAnneeS1());
            preparedStatement.setInt(22, etd.getAnneeS2());
            preparedStatement.setInt(23, etd.getAnneeS3());
            preparedStatement.setInt(24, etd.getAnneeS4());
            preparedStatement.setString(25, etd.getIamge_note_bac());

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Etudiant inserted successfully.");
                return true;
            } else {
                System.out.println("Failed to insert Etudiant.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public boolean deleteEtudiant(String cni) {
        String query = "DELETE FROM user WHERE cni = ?";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, cni);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Etudiant deleted successfully.");
                return true;
            } else {
                System.out.println("Failed to delete Etudiant.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public boolean updateEtudiant(Etudiant etd) {
	    String query = "UPDATE etudiant SET cne = ?, type_bac = ?, note_bac = ?, type_bac2 = ?, note_bac2 = ?, id_filier = ?, cni_user = ?, imageBac = ?, imageBac2 = ?, imageS1 = ?, imageS2 = ?, imageS3 = ?, imageS4 = ? WHERE cni_user = ?";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        // Set the parameters for the update
	        preparedStatement.setString(1, etd.getCne());
	        preparedStatement.setString(2, etd.getType_bac());
	        preparedStatement.setDouble(3, etd.getNote_bac());
	        preparedStatement.setString(4, etd.getType_bac2());
	        preparedStatement.setDouble(5, etd.getNote_bac2());
	        preparedStatement.setString(6, etd.getFilier_titel());
	        preparedStatement.setString(7, etd.getCni_user());
	        preparedStatement.setString(8, etd.getImageBac());
	        preparedStatement.setString(9, etd.getImageBac2());
	        preparedStatement.setString(10, etd.getImageS1());
	        preparedStatement.setString(11, etd.getImageS2());
	        preparedStatement.setString(12, etd.getImageS3());
	        preparedStatement.setString(13, etd.getImageS4());
	        preparedStatement.setString(14, etd.getCni_user()); // This sets the cni_user for the WHERE condition

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
	}

	@Override
    public List<Etudiant> selectAllEtudiants(String filier_titel) {
        List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM etudiant JOIN user ON etudiant.cni_user = user.cni WHERE etudiant.titel_filier = ?";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, filier_titel);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Etudiant etd = new Etudiant();
                etd.setCne(resultSet.getString("cne"));
                etd.setCni(resultSet.getString("cni"));
                etd.setNom(resultSet.getString("nom"));
                etd.setPrenom(resultSet.getString("prenom"));
                etd.setFilier_titel(resultSet.getString("titel_filier"));
                etd.setType_bac2(resultSet.getString("type_bac2"));
                etd.setNote_bac2(resultSet.getDouble("note_bac2"));
                etd.setFilier_titel(resultSet.getString("titel_filier"));
                etd.setCni_user(resultSet.getString("cni_user"));
                etd.setImageBac(resultSet.getString("imageBac"));
                etd.setImageBac2(resultSet.getString("imageBac2"));
                etd.setImageS1(resultSet.getString("imageS1"));
                etd.setImageS2(resultSet.getString("imageS2"));
                etd.setImageS3(resultSet.getString("imageS3"));
                etd.setImageS4(resultSet.getString("imageS4"));
                
                etudiants.add(etd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiants;
    }

	
}
