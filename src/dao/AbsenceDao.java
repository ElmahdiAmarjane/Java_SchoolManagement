package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import db_connect.JDBC;
import modules.Absence;
import services.IAbsenceServices;

public class AbsenceDao implements IAbsenceServices{

	@Override
	public boolean insertAbsence(Absence absence) {
	    // SQL query to insert absence details
	    String query = "INSERT INTO absence (etudiants, date,heure_debut, heure_fine, id_filier, element_nom) " +
	                   "VALUES (?, ?, ?, ?, ?, ?)";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        // Set the parameters for the query
	        String jsonCNEs = new JSONArray(absence.getCne_etudiants()).toString();

	        
	        preparedStatement.setString(1, jsonCNEs); 
	        preparedStatement.setDate(2, java.sql.Date.valueOf(absence.getDate())); 
	        preparedStatement.setTime(3, java.sql.Time.valueOf(absence.getHeure_debut().toString())); 
	        preparedStatement.setTime(4, java.sql.Time.valueOf(absence.getHeure_fine().toString())); 
	        preparedStatement.setString(5, absence.getFilier_titel()); // id_filier
	        preparedStatement.setString(6, absence.getElement_nom()); // element_id

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Absence inserted successfully.");
	            return true;
	        } else {
	            System.out.println("Failed to insert Absence.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}



	@Override
	public Absence fetchAbsenceFilier(String filier) {
		 //List<Absence> absences = new ArrayList<>();
		Absence abs = new Absence();
	        // Query to filter absences by filier_id and date
	        String query = "SELECT * FROM absence WHERE id_filier = ? ";
	        
	        try (Connection connection = JDBC.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, filier); 
	            //preparedStatement.setDate(2, java.sql.Date.valueOf(absence.getDate()));
	            
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                

	            	abs.setId(resultSet.getInt("id"));
	            	
	            	 String jsonCNEs = resultSet.getString("etudiants"); // Assuming column name is 'etudiants'
	                 List<String> cneList = parseJsonToList(jsonCNEs); // Parse JSON into a list
	                 abs.setCne_etudiants(cneList);
	                
	                 //java.sql.Date.valueOf(user.getDateNaissance())
	            	abs.setDate(resultSet.getDate("date").toLocalDate());
	            	abs.setHeure_debut(resultSet.getTime("heure_debut"));
	            	abs.setHeure_fine(resultSet.getTime("heure_fine"));
	            	abs.setFilier_titel(resultSet.getString("id_filier"));
	            	abs.setElement_nom(resultSet.getString("element_nom"));
	                
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return abs;
	}
	
	private List<String> parseJsonToList(String json) {
	    List<String> list = new ArrayList<>();
	    try {
	        JSONArray jsonArray = new JSONArray(json); // Parse JSON string to JSONArray
	        for (int i = 0; i < jsonArray.length(); i++) {
	            list.add(jsonArray.getString(i)); // Add each element to the list
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	@Override
	public Absence fetchAbsenceFilieByDater(LocalDate date) {
		 //List<Absence> absences = new ArrayList<>();
		Absence abs = new Absence();
	        // Query to filter absences by filier_id and date
	        String query = "SELECT * FROM absence WHERE date = ? ";
	        
	        try (Connection connection = JDBC.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setDate(1,  java.sql.Date.valueOf(date)); 
	            //preparedStatement.setDate(2, java.sql.Date.valueOf(absence.getDate()));
	            
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                

	            	abs.setId(resultSet.getInt("id"));
	            	
	            	 String jsonCNEs = resultSet.getString("etudiants"); // Assuming column name is 'etudiants'
	                 List<String> cneList = parseJsonToList(jsonCNEs); // Parse JSON into a list
	                 abs.setCne_etudiants(cneList);
	                
	                 //java.sql.Date.valueOf(user.getDateNaissance())
	            	abs.setDate(resultSet.getDate("date").toLocalDate());
	            	abs.setHeure_debut(resultSet.getTime("heure_debut"));
	            	abs.setHeure_fine(resultSet.getTime("heure_fine"));
	            	abs.setFilier_titel(resultSet.getString("id_filier"));
	            	abs.setElement_nom(resultSet.getString("element_nom"));;
	                
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return abs;
	}

}