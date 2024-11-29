package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db_connect.JDBC;
import modules.Annonce;
import modules.Filier;
import services.IAnnonceServices;

public class AnnonceDao implements IAnnonceServices{

	@Override
	public boolean addAnnonce(Annonce annonce) {
		String query = "INSERT INTO Annonce (title,contenu,file) VALUES (?,?,?)";
        try(Connection connection = JDBC.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)){
        	
        	 preparedStatement.setString(1, annonce.getTitle());
             preparedStatement.setString(2, annonce.getContenu());
             preparedStatement.setString(3, annonce.getFile());
         
             
             int rowsAffected = preparedStatement.executeUpdate();

             if (rowsAffected > 0) {
                 System.out.println("annonce inserted successfully.");
                 return true;
             } else {
                 System.out.println("Failed to insert annonce.");
             }
        	
        }catch(SQLException e) {
        	 e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean supprimerAnnonce(Annonce annonce) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAnnonce(Annonce annonce) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Annonce> selectAllAnnonce() {
		 List<Annonce> annonces = new ArrayList<>();
	        String query = "SELECT * FROM Annonce";

	        try (Connection connection = JDBC.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Annonce annonce = new Annonce();
	                annonce.setTitle(resultSet.getString("title"));
	                annonce.setContenu(resultSet.getString("contenu"));
	                annonce.setDateAnnonce(resultSet.getDate("dateAnnonce"));
	                annonce.setFile(resultSet.getString("file"));
	                
	                
	                annonces.add(annonce);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return annonces;
	}


}
