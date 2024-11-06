package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db_connect.JDBC;
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

}
