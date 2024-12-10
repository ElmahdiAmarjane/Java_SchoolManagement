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
        String query = "INSERT INTO etudiant (cne, type_bac, note_bac, bac_acadimie, type_bac2, note_bac2, titel_filier, cni_user, imageBac, imageBac2,imageS1,imageS2,imageS3,imageS4,anneeBac,universityBac2,etablismentBac2,noteS1,noteS2,noteS3,noteS4,anneeS1,anneeS2,anneeS3,anneeS4,relverBac) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the query
            preparedStatement.setString(1, etd.getCne());
            preparedStatement.setString(2, etd.getType_bac());
            preparedStatement.setDouble(3, etd.getNote_bac());
            preparedStatement.setString(4, etd.getBac_acadimic());
            preparedStatement.setString(5, etd.getType_bac2());
            preparedStatement.setDouble(6, etd.getNote_bac2());
            preparedStatement.setString(7, etd.getFilier_titel());
            preparedStatement.setString(8, etd.getCni_user());
            preparedStatement.setString(9, etd.getImageBac());
            preparedStatement.setString(10, etd.getImageBac2());
            preparedStatement.setString(11, etd.getImageS1());
            preparedStatement.setString(12, etd.getImageS2());
            preparedStatement.setString(13, etd.getImageS3());
            preparedStatement.setString(14, etd.getImageS4());
            preparedStatement.setInt(15, etd.getAnneBac());
            preparedStatement.setString(16, etd.getUniversity());
            preparedStatement.setString(17, etd.getEtablisment_bac2());
            preparedStatement.setDouble(18, etd.getNote_S1());
            preparedStatement.setDouble(19, etd.getNote_S2());
            preparedStatement.setDouble(20, etd.getNote_S3());
            preparedStatement.setDouble(21, etd.getNote_S4());
            preparedStatement.setInt(22, etd.getAnneeS1());
            preparedStatement.setInt(23, etd.getAnneeS2());
            preparedStatement.setInt(24, etd.getAnneeS3());
            preparedStatement.setInt(25, etd.getAnneeS4());
            preparedStatement.setString(26, etd.getIamge_note_bac());

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
	public boolean updateEtudiant(Etudiant etd) {
	    String query = "UPDATE etudiant SET cne = ?, type_bac = ?, note_bac = ?, bac_acadimie = ?, type_bac2 = ?, note_bac2 = ?, titel_filier = ?, imageBac = ?, imageBac2 = ?, imageS1 = ?, imageS2 = ?, imageS3 = ?, imageS4 = ?, anneeBac = ?, universityBac2 = ?, etablismentBac2 = ?, noteS1 = ?, noteS2 = ?, noteS3 = ?, noteS4 = ?, anneeS1 = ?, anneeS2 = ?, anneeS3 = ?, anneeS4 = ?, relverBac = ? WHERE cni_user = ?";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        // Set parameters for the query
	        preparedStatement.setString(1, etd.getCne());
	        preparedStatement.setString(2, etd.getType_bac());
	        preparedStatement.setDouble(3, etd.getNote_bac());
	        preparedStatement.setString(4, etd.getBac_acadimic());
	        preparedStatement.setString(5, etd.getType_bac2());
	        preparedStatement.setDouble(6, etd.getNote_bac2());
	        preparedStatement.setString(7, etd.getFilier_titel());
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
	        preparedStatement.setString(26, etd.getCni_user()); // WHERE condition

	        // Execute the update
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
    public List<Etudiant> selectAllEtudiantsFilier(String filier_titel) {
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

	
	
	@Override
    public List<Etudiant> selectAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM etudiant JOIN user ON etudiant.cni_user = user.cni";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        
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

	
	@Override
	public Etudiant selectEtudiantByCni(String cni) {
	    Etudiant etd = null; // Initialize to null to indicate no data if not found
	    String query = "SELECT * FROM etudiant JOIN user ON etudiant.cni_user = user.cni WHERE user.cni = ?";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        preparedStatement.setString(1, cni);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) { // Check if a row exists
	            etd = new Etudiant(); // Instantiate the object only when data is found
	            etd.setCne(resultSet.getString("cne"));
	            etd.setCni(resultSet.getString("cni"));
	            etd.setNom(resultSet.getString("nom"));
	            etd.setSexe(resultSet.getString("sexe"));
	            etd.setPrenom(resultSet.getString("prenom"));
	            etd.setTel(resultSet.getString("tele"));
	            etd.setFilier_titel(resultSet.getString("titel_filier"));
	            etd.setCni_user(resultSet.getString("cni_user"));
	            etd.setEmail(resultSet.getString("email"));
	            etd.setPassword(resultSet.getString("password"));
	            etd.setDateNaissance(resultSet.getDate("dateNaissance").toLocalDate());
	            etd.setNationalite(resultSet.getString("nationalite"));
	            
	            etd.setType_bac2(resultSet.getString("type_bac2"));
	            etd.setNote_bac2(resultSet.getDouble("note_bac2"));
	            etd.setUniversity(resultSet.getString("universityBac2"));
	            etd.setEtablisment_bac2(resultSet.getString("etablismentBac2"));
	            
	            etd.setBac_acadimic(resultSet.getString("bac_acadimie"));
	            etd.setType_bac(resultSet.getString("type_bac"));
	            etd.setNote_bac(resultSet.getDouble("note_bac"));
	            etd.setAnneBac(resultSet.getInt("anneeBac"));
	            
	            etd.setNote_S1(resultSet.getDouble("noteS1"));
	            etd.setNote_S2(resultSet.getDouble("noteS2"));
	            etd.setNote_S3(resultSet.getDouble("noteS3"));
	            etd.setNote_S4(resultSet.getDouble("noteS4"));
	            
	            etd.setAnneeS1(resultSet.getInt("anneeS1"));
	            etd.setAnneeS2(resultSet.getInt("anneeS2"));
	            etd.setAnneeS3(resultSet.getInt("anneeS3"));
	            etd.setAnneeS4(resultSet.getInt("anneeS4"));
	            
	            etd.setImage(resultSet.getString("image"));
	            etd.setImageCni(resultSet.getString("image_cni"));
	            etd.setImageBac(resultSet.getString("imageBac"));
	            etd.setIamge_note_bac(resultSet.getString("relverBac"));
	            etd.setImageBac2(resultSet.getString("imageBac2"));
	            etd.setImageS1(resultSet.getString("imageS1"));
	            etd.setImageS2(resultSet.getString("imageS2"));
	            etd.setImageS3(resultSet.getString("imageS3"));
	            etd.setImageS4(resultSet.getString("imageS4"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return etd;
	}

	@Override
	public Etudiant selectEtudiantByCne(String cne) {
	    Etudiant etd = null; // Initialize to null to indicate no data if not found
	    String query = "SELECT * FROM etudiant JOIN user ON etudiant.cni_user = user.cni WHERE etudiant.cne = ?";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        preparedStatement.setString(1, cne);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) { // Check if a row exists
	            etd = new Etudiant(); // Instantiate the object only when data is found
	            etd.setCne(resultSet.getString("cne"));
	            etd.setCni(resultSet.getString("cni"));
	            etd.setNom(resultSet.getString("nom"));
	            etd.setSexe(resultSet.getString("sexe"));
	            etd.setPrenom(resultSet.getString("prenom"));
	            etd.setTel(resultSet.getString("tele"));
	            etd.setFilier_titel(resultSet.getString("titel_filier"));
	            etd.setCni_user(resultSet.getString("cni_user"));
	            etd.setEmail(resultSet.getString("email"));
	            etd.setPassword(resultSet.getString("password"));
	            etd.setDateNaissance(resultSet.getDate("dateNaissance").toLocalDate());
	            etd.setNationalite(resultSet.getString("nationalite"));
	            
	            etd.setType_bac2(resultSet.getString("type_bac2"));
	            etd.setNote_bac2(resultSet.getDouble("note_bac2"));
	            etd.setUniversity(resultSet.getString("universityBac2"));
	            etd.setEtablisment_bac2(resultSet.getString("etablismentBac2"));
	            
	            etd.setBac_acadimic(resultSet.getString("bac_acadimie"));
	            etd.setType_bac(resultSet.getString("type_bac"));
	            etd.setNote_bac(resultSet.getDouble("note_bac"));
	            etd.setAnneBac(resultSet.getInt("anneeBac"));
	            
	            etd.setNote_S1(resultSet.getDouble("noteS1"));
	            etd.setNote_S2(resultSet.getDouble("noteS2"));
	            etd.setNote_S3(resultSet.getDouble("noteS3"));
	            etd.setNote_S4(resultSet.getDouble("noteS4"));
	            
	            etd.setAnneeS1(resultSet.getInt("anneeS1"));
	            etd.setAnneeS2(resultSet.getInt("anneeS2"));
	            etd.setAnneeS3(resultSet.getInt("anneeS3"));
	            etd.setAnneeS4(resultSet.getInt("anneeS4"));
	            
	            etd.setImage(resultSet.getString("image"));
	            etd.setImageCni(resultSet.getString("image_cni"));
	            etd.setImageBac(resultSet.getString("imageBac"));
	            etd.setIamge_note_bac(resultSet.getString("relverBac"));
	            etd.setImageBac2(resultSet.getString("imageBac2"));
	            etd.setImageS1(resultSet.getString("imageS1"));
	            etd.setImageS2(resultSet.getString("imageS2"));
	            etd.setImageS3(resultSet.getString("imageS3"));
	            etd.setImageS4(resultSet.getString("imageS4"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return etd;
	}
	
}