package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db_connect.JDBC;
import modules.Etudiant;

public class EtudiantDao {

	
	public boolean insertEtudiant(Etudiant etd) {
        String query = "INSERT INTO etudiante (cne, type_bac, note_bac, type_bac2, note_bac2, id_filier, cni_user, imageBac, imageBac2,imageS1,imageS2,imageS3,imageS4) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the query
            preparedStatement.setString(1, etd.getCne());
            preparedStatement.setString(2, etd.getType_bac());
            preparedStatement.setDouble(3, etd.getNote_bac());
            preparedStatement.setString(4, etd.getType_bac2());
            preparedStatement.setDouble(5, etd.getNote_bac2());
            preparedStatement.setInt(6, etd.getId_filier());
            preparedStatement.setString(7, etd.getCni_user());
            preparedStatement.setString(8, etd.getImageBac());
            preparedStatement.setString(9, etd.getImageBac2());
            preparedStatement.setString(10, etd.getImageS1());
            preparedStatement.setString(11, etd.getImageS2());
            preparedStatement.setString(12, etd.getImageS3());
            preparedStatement.setString(13, etd.getImageS4());

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
	
}
