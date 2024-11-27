package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db_connect.JDBC;
import modules.Etudiant;
import modules.Filier;
import services.IFilierServices;

public class FilierDao implements IFilierServices{

	
	@Override
	public boolean addFilier(Filier filier) {
        String query = "INSERT INTO filier (titel, programme_id) VALUES (?,?)";
        try(Connection connection = JDBC.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)){
        	
        	 preparedStatement.setString(1, filier.getTitel());
             preparedStatement.setInt(2, filier.getProgrammeId());
             
             int rowsAffected = preparedStatement.executeUpdate();

             if (rowsAffected > 0) {
                 System.out.println("Filier inserted successfully.");
                 return true;
             } else {
                 System.out.println("Failed to insert Filier.");
             }
        	
        }catch(SQLException e) {
        	 e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean supprimerFilier(Filier filier) {
		String query = "DELETE FROM filier WHERE id = ?";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, filier.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Filier deleted successfully.");
                return true;
            } else {
                System.out.println("Failed to delete Filier.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean updateFilier(Filier filier) {
		String query = "UPDATE filier SET titel=?, programme_id=? WHERE id=? ";
		
		try (Connection connection = JDBC.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

		        // Set the parameters for the update
		        preparedStatement.setString(1, filier.getTitel());
		        preparedStatement.setInt(2, filier.getProgrammeId());
		        preparedStatement.setInt(3, filier.getId());

		        int rowsAffected = preparedStatement.executeUpdate();

		        if (rowsAffected > 0) {
		            System.out.println("Filier updated successfully.");
		            return true;
		        } else {
		            System.out.println("Failed to update Filier.");
		        }
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return false;
	}

	@Override
	public List<Filier> selectAllFilier() {
		 List<Filier> filiers = new ArrayList<>();
	        String query = "SELECT * FROM filier";

	        try (Connection connection = JDBC.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Filier filier = new Filier();
	                filier.setTitel(resultSet.getString("titel"));
	                
	                filiers.add(filier);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return filiers;
	}

}
