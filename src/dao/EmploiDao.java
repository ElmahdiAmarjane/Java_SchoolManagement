package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import db_connect.JDBC;
import modules.Emploi;
import services.IEmploiServices;

public class EmploiDao implements IEmploiServices{

 

	@Override
	public boolean insertEmploi(Emploi emploi) {
		
		String query = "INSERT INTO emploi (date, " +
                "`8-10-element-lundi`, `10-12-element-lundi`, `2-4-element-lundi`, `4-6-element-lundi`, " +
                "`8-10-prof-lundi`, `10-12-prof-lundi`, `2-4-prof-lundi`, `4-6-prof-lundi`, " +
                "`8-10-salle-lundi`, `10-12-salle-lundi`, `2-4-salle-lundi`, `4-6-salle-lundi`, " +
                "`8-10-element-mardi`, `10-12-element-mardi`, `2-4-element-mardi`, `4-6-element-mardi`, " +
                "`8-10-prof-mardi`, `10-12-prof-mardi`, `2-4-prof-mardi`, `4-6-prof-mardi`, " +
                "`8-10-salle-mardi`, `10-12-salle-mardi`, `2-4-salle-mardi`, `4-6-salle-mardi`, " +
                "`8-10-element-mercredi`, `10-12-element-mercredi`, `2-4-element-mercredi`, `4-6-element-mercredi`, " +
                "`8-10-prof-mercredi`, `10-12-prof-mercredi`, `2-4-prof-mercredi`, `4-6-prof-mercredi`, " +
                "`8-10-salle-mercredi`, `10-12-salle-mercredi`, `2-4-salle-mercredi`, `4-6-salle-mercredi`, " +
                "`8-10-element-jeudi`, `10-12-element-jeudi`, `2-4-element-jeudi`, `4-6-element-jeudi`, " +
                "`8-10-prof-jeudi`, `10-12-prof-jeudi`, `2-4-prof-jeudi`, `4-6-prof-jeudi`, " +
                "`8-10-salle-jeudi`, `10-12-salle-jeudi`, `2-4-salle-jeudi`, `4-6-salle-jeudi`, " +
                "`8-10-element-vendredi`, `10-12-element-vendredi`, `2-4-element-vendredi`, `4-6-element-vendredi`, " +
                "`8-10-prof-vendredi`, `10-12-prof-vendredi`, `2-4-prof-vendredi`, `4-6-prof-vendredi`, " +
                "`8-10-salle-vendredi`, `10-12-salle-vendredi`, `2-4-salle-vendredi`, `4-6-salle-vendredi`, " +
                " cni_user, filier_titel) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        // Lundi
	        JSONArray json8_10_element_lundi = new JSONArray(emploi.getH_8_10_element_lundi());
	        JSONArray json10_12_element_lundi = new JSONArray(emploi.getH_10_12_element_lundi());
	        JSONArray json2_4_element_lundi = new JSONArray(emploi.getH_2_4_element_lundi());
	        JSONArray json4_6_element_lundi = new JSONArray(emploi.getH_4_6_element_lundi());

	        JSONArray json8_10_prof_lundi = new JSONArray(emploi.getH_8_10_prof_lundi());
	        JSONArray json10_12_prof_lundi = new JSONArray(emploi.getH_10_12_prof_lundi());
	        JSONArray json2_4_prof_lundi = new JSONArray(emploi.getH_2_4_prof_lundi());
	        JSONArray json4_6_prof_lundi = new JSONArray(emploi.getH_4_6_prof_lundi());

	        JSONArray json8_10_salle_lundi = new JSONArray(emploi.getH_8_10_salle_lundi());
	        JSONArray json10_12_salle_lundi = new JSONArray(emploi.getH_10_12_salle_lundi());
	        JSONArray json2_4_salle_lundi = new JSONArray(emploi.getH_2_4_salle_lundi());
	        JSONArray json4_6_salle_lundi = new JSONArray(emploi.getH_4_6_salle_lundi());

	        // Mardi
	        JSONArray json8_10_element_mardi = new JSONArray(emploi.getH_8_10_element_mardi());
	        JSONArray json10_12_element_mardi = new JSONArray(emploi.getH_10_12_element_mardi());
	        JSONArray json2_4_element_mardi = new JSONArray(emploi.getH_2_4_element_mardi());
	        JSONArray json4_6_element_mardi = new JSONArray(emploi.getH_4_6_element_mardi());

	        JSONArray json8_10_prof_mardi = new JSONArray(emploi.getH_8_10_prof_mardi());
	        JSONArray json10_12_prof_mardi = new JSONArray(emploi.getH_10_12_prof_mardi());
	        JSONArray json2_4_prof_mardi = new JSONArray(emploi.getH_2_4_prof_mardi());
	        JSONArray json4_6_prof_mardi = new JSONArray(emploi.getH_4_6_prof_mardi());

	        JSONArray json8_10_salle_mardi = new JSONArray(emploi.getH_8_10_salle_mardi());
	        JSONArray json10_12_salle_mardi = new JSONArray(emploi.getH_10_12_salle_mardi());
	        JSONArray json2_4_salle_mardi = new JSONArray(emploi.getH_2_4_salle_mardi());
	        JSONArray json4_6_salle_mardi = new JSONArray(emploi.getH_4_6_salle_mardi());

	        // Mercredi
	        JSONArray json8_10_element_mercredi = new JSONArray(emploi.getH_8_10_element_mercredi());
	        JSONArray json10_12_element_mercredi = new JSONArray(emploi.getH_10_12_element_mercredi());
	        JSONArray json2_4_element_mercredi = new JSONArray(emploi.getH_2_4_element_mercredi());
	        JSONArray json4_6_element_mercredi = new JSONArray(emploi.getH_4_6_element_mercredi());

	        JSONArray json8_10_prof_mercredi = new JSONArray(emploi.getH_8_10_prof_mercredi());
	        JSONArray json10_12_prof_mercredi = new JSONArray(emploi.getH_10_12_prof_mercredi());
	        JSONArray json2_4_prof_mercredi = new JSONArray(emploi.getH_2_4_prof_mercredi());
	        JSONArray json4_6_prof_mercredi = new JSONArray(emploi.getH_4_6_prof_mercredi());

	        JSONArray json8_10_salle_mercredi = new JSONArray(emploi.getH_8_10_salle_mercredi());
	        JSONArray json10_12_salle_mercredi = new JSONArray(emploi.getH_10_12_salle_mercredi());
	        JSONArray json2_4_salle_mercredi = new JSONArray(emploi.getH_2_4_salle_mercredi());
	        JSONArray json4_6_salle_mercredi = new JSONArray(emploi.getH_4_6_salle_mercredi());

	        // Jeudi
	        JSONArray json8_10_element_jeudi = new JSONArray(emploi.getH_8_10_element_jeudi());
	        JSONArray json10_12_element_jeudi = new JSONArray(emploi.getH_10_12_element_jeudi());
	        JSONArray json2_4_element_jeudi = new JSONArray(emploi.getH_2_4_element_jeudi());
	        JSONArray json4_6_element_jeudi = new JSONArray(emploi.getH_4_6_element_jeudi());

	        JSONArray json8_10_prof_jeudi = new JSONArray(emploi.getH_8_10_prof_jeudi());
	        JSONArray json10_12_prof_jeudi = new JSONArray(emploi.getH_10_12_prof_jeudi());
	        JSONArray json2_4_prof_jeudi = new JSONArray(emploi.getH_2_4_prof_jeudi());
	        JSONArray json4_6_prof_jeudi = new JSONArray(emploi.getH_4_6_prof_jeudi());

	        JSONArray json8_10_salle_jeudi = new JSONArray(emploi.getH_8_10_salle_jeudi());
	        JSONArray json10_12_salle_jeudi = new JSONArray(emploi.getH_10_12_salle_jeudi());
	        JSONArray json2_4_salle_jeudi = new JSONArray(emploi.getH_2_4_salle_jeudi());
	        JSONArray json4_6_salle_jeudi = new JSONArray(emploi.getH_4_6_salle_jeudi());

	        // Vendredi
	        JSONArray json8_10_element_vendredi = new JSONArray(emploi.getH_8_10_element_vendredi());
	        JSONArray json10_12_element_vendredi = new JSONArray(emploi.getH_10_12_element_vendredi());
	        JSONArray json2_4_element_vendredi = new JSONArray(emploi.getH_2_4_element_vendredi());
	        JSONArray json4_6_element_vendredi = new JSONArray(emploi.getH_4_6_element_vendredi());

	        JSONArray json8_10_prof_vendredi = new JSONArray(emploi.getH_8_10_prof_vendredi());
	        JSONArray json10_12_prof_vendredi = new JSONArray(emploi.getH_10_12_prof_vendredi());
	        JSONArray json2_4_prof_vendredi = new JSONArray(emploi.getH_2_4_prof_vendredi());
	        JSONArray json4_6_prof_vendredi = new JSONArray(emploi.getH_4_6_prof_vendredi());

	        JSONArray json8_10_salle_vendredi = new JSONArray(emploi.getH_8_10_salle_vendredi());
	        JSONArray json10_12_salle_vendredi = new JSONArray(emploi.getH_10_12_salle_vendredi());
	        JSONArray json2_4_salle_vendredi = new JSONArray(emploi.getH_2_4_salle_vendredi());
	        JSONArray json4_6_salle_vendredi = new JSONArray(emploi.getH_4_6_salle_vendredi());

	        // Prepare and set the values in the preparedStatement
	        preparedStatement.setDate(1, java.sql.Date.valueOf(emploi.getDate()));
    
	        //LUNDI
	        preparedStatement.setString(2, json8_10_element_lundi.toString());
	        preparedStatement.setString(3, json10_12_element_lundi.toString());
	        preparedStatement.setString(4, json2_4_element_lundi.toString());
	        preparedStatement.setString(5, json4_6_element_lundi.toString());

	        preparedStatement.setString(6, json8_10_prof_lundi.toString());
	        preparedStatement.setString(7, json10_12_prof_lundi.toString());
	        preparedStatement.setString(8, json2_4_prof_lundi.toString());
	        preparedStatement.setString(9, json4_6_prof_lundi.toString());

	        preparedStatement.setString(10, json8_10_salle_lundi.toString());
	        preparedStatement.setString(11, json10_12_salle_lundi.toString());
	        preparedStatement.setString(12, json2_4_salle_lundi.toString());
	        preparedStatement.setString(13, json4_6_salle_lundi.toString());
	        
	        //MARDI
	        preparedStatement.setString(14, json8_10_element_mardi.toString());
	        preparedStatement.setString(15, json10_12_element_mardi.toString());
	        preparedStatement.setString(16, json2_4_element_mardi.toString());
	        preparedStatement.setString(17, json4_6_element_mardi.toString());

	        preparedStatement.setString(18, json8_10_prof_mardi.toString());
	        preparedStatement.setString(19, json10_12_prof_mardi.toString());
	        preparedStatement.setString(20, json2_4_prof_mardi.toString());
	        preparedStatement.setString(21, json4_6_prof_mardi.toString());

	        preparedStatement.setString(22, json8_10_salle_mardi.toString());
	        preparedStatement.setString(23, json10_12_salle_mardi.toString());
	        preparedStatement.setString(24, json2_4_salle_mardi.toString());
	        preparedStatement.setString(25, json4_6_salle_mardi.toString());
	        
	        //MERCREDI
	        preparedStatement.setString(26, json8_10_element_mercredi.toString());
	        preparedStatement.setString(27, json10_12_element_mercredi.toString());
	        preparedStatement.setString(28, json2_4_element_mercredi.toString());
	        preparedStatement.setString(29, json4_6_element_mercredi.toString());

	        preparedStatement.setString(30, json8_10_prof_mercredi.toString());
	        preparedStatement.setString(31, json10_12_prof_mercredi.toString());
	        preparedStatement.setString(32, json2_4_prof_mercredi.toString());
	        preparedStatement.setString(33, json4_6_prof_mercredi.toString());

	        preparedStatement.setString(34, json8_10_salle_mercredi.toString());
	        preparedStatement.setString(35, json10_12_salle_mercredi.toString());
	        preparedStatement.setString(36, json2_4_salle_mercredi.toString());
	        preparedStatement.setString(37, json4_6_salle_mercredi.toString());
	        
	        //JEUDI
	        preparedStatement.setString(38, json8_10_element_jeudi.toString());
	        preparedStatement.setString(39, json10_12_element_jeudi.toString());
	        preparedStatement.setString(40, json2_4_element_jeudi.toString());
	        preparedStatement.setString(41, json4_6_element_jeudi.toString());

	        preparedStatement.setString(42, json8_10_prof_jeudi.toString());
	        preparedStatement.setString(43, json10_12_prof_jeudi.toString());
	        preparedStatement.setString(44, json2_4_prof_jeudi.toString());
	        preparedStatement.setString(45, json4_6_prof_jeudi.toString());

	        preparedStatement.setString(46, json8_10_salle_jeudi.toString());
	        preparedStatement.setString(47, json10_12_salle_jeudi.toString());
	        preparedStatement.setString(48, json2_4_salle_jeudi.toString());
	        preparedStatement.setString(49, json4_6_salle_jeudi.toString());
	        
	        //VENDREDI
	        preparedStatement.setString(50, json8_10_element_vendredi.toString());
	        preparedStatement.setString(51, json10_12_element_vendredi.toString());
	        preparedStatement.setString(52, json2_4_element_vendredi.toString());
	        preparedStatement.setString(53, json4_6_element_vendredi.toString());

	        preparedStatement.setString(54, json8_10_prof_vendredi.toString());
	        preparedStatement.setString(55, json10_12_prof_vendredi.toString());
	        preparedStatement.setString(56, json2_4_prof_vendredi.toString());
	        preparedStatement.setString(57, json4_6_prof_vendredi.toString());

	        preparedStatement.setString(58, json8_10_salle_vendredi.toString());
	        preparedStatement.setString(59, json10_12_salle_vendredi.toString());
	        preparedStatement.setString(60, json2_4_salle_vendredi.toString());
	        preparedStatement.setString(61, json4_6_salle_vendredi.toString());

	        

	        // Set the remaining values
	        preparedStatement.setString(62, emploi.getCni_user());
	        preparedStatement.setString(63, emploi.getFilier_titel());

	        
	        int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Emploi inserted successfully.");
                return true;
            } else {
                System.out.println("Failed to insert Emploi.");
            }
            
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	private List<String> parseJsonArray(String json) {
	    if (json == null || json.isEmpty()) {
	        return new ArrayList<>();
	    }

	    List<String> list = new ArrayList<>();
	    try {
	        JSONArray jsonArray = new JSONArray(json);

	        for (int i = 0; i < jsonArray.length(); i++) {
	            // Check if the value is not null and is a string
	            Object item = jsonArray.get(i);
	            if (item != JSONObject.NULL && item instanceof String) {
	                list.add((String) item);
	            } else {
	                // Handle cases where the value is null or not a string
	                list.add(""); // or any default value you'd prefer
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	@Override
	public Emploi selectEmploiProf(String cniUser) {
	    String query = "SELECT * FROM emploi WHERE cni_user = ?";
	    Emploi emploi = null;

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        preparedStatement.setString(1, cniUser);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	        	
	            if (resultSet.next()) {
	                emploi = new Emploi();


	                //LUNDI
	                emploi.setH_8_10_element_lundi(parseJsonArray(resultSet.getString("8-10-element-lundi")));
	                emploi.setH_10_12_element_lundi(parseJsonArray(resultSet.getString("10-12-element-lundi")));
	                emploi.setH_2_4_element_lundi(parseJsonArray(resultSet.getString("2-4-element-lundi")));
	                emploi.setH_4_6_element_lundi(parseJsonArray(resultSet.getString("4-6-element-lundi")));

	                emploi.setH_8_10_prof_lundi(parseJsonArray(resultSet.getString("8-10-prof-lundi")));
	                emploi.setH_10_12_prof_lundi(parseJsonArray(resultSet.getString("10-12-prof-lundi")));
	                emploi.setH_2_4_prof_lundi(parseJsonArray(resultSet.getString("2-4-prof-lundi")));
	                emploi.setH_4_6_prof_lundi(parseJsonArray(resultSet.getString("4-6-prof-lundi")));

	                emploi.setH_8_10_salle_lundi(parseJsonArray(resultSet.getString("8-10-salle-lundi")));
	                emploi.setH_10_12_salle_lundi(parseJsonArray(resultSet.getString("10-12-salle-lundi")));
	                emploi.setH_2_4_salle_lundi(parseJsonArray(resultSet.getString("2-4-salle-lundi")));
	                emploi.setH_4_6_salle_lundi(parseJsonArray(resultSet.getString("4-6-salle-lundi")));
	                
	                //MARDI
	                emploi.setH_8_10_element_mardi(parseJsonArray(resultSet.getString("8-10-element-mardi")));
	                emploi.setH_10_12_element_mardi(parseJsonArray(resultSet.getString("10-12-element-mardi")));
	                emploi.setH_2_4_element_mardi(parseJsonArray(resultSet.getString("2-4-element-mardi")));
	                emploi.setH_4_6_element_mardi(parseJsonArray(resultSet.getString("4-6-element-mardi")));

	                emploi.setH_8_10_prof_mardi(parseJsonArray(resultSet.getString("8-10-prof-mardi")));
	                emploi.setH_10_12_prof_mardi(parseJsonArray(resultSet.getString("10-12-prof-mardi")));
	                emploi.setH_2_4_prof_mardi(parseJsonArray(resultSet.getString("2-4-prof-mardi")));
	                emploi.setH_4_6_prof_mardi(parseJsonArray(resultSet.getString("4-6-prof-mardi")));

	                emploi.setH_8_10_salle_mardi(parseJsonArray(resultSet.getString("8-10-salle-mardi")));
	                emploi.setH_10_12_salle_mardi(parseJsonArray(resultSet.getString("10-12-salle-mardi")));
	                emploi.setH_2_4_salle_mardi(parseJsonArray(resultSet.getString("2-4-salle-mardi")));
	                emploi.setH_4_6_salle_mardi(parseJsonArray(resultSet.getString("4-6-salle-mardi")));
	                
	                //MERCREDI
	                emploi.setH_8_10_element_mercredi(parseJsonArray(resultSet.getString("8-10-element-mercredi")));
	                emploi.setH_10_12_element_mercredi(parseJsonArray(resultSet.getString("10-12-element-mercredi")));
	                emploi.setH_2_4_element_mercredi(parseJsonArray(resultSet.getString("2-4-element-mercredi")));
	                emploi.setH_4_6_element_mercredi(parseJsonArray(resultSet.getString("4-6-element-mercredi")));

	                emploi.setH_8_10_prof_mercredi(parseJsonArray(resultSet.getString("8-10-prof-mercredi")));
	                emploi.setH_10_12_prof_mercredi(parseJsonArray(resultSet.getString("10-12-prof-mercredi")));
	                emploi.setH_2_4_prof_mercredi(parseJsonArray(resultSet.getString("2-4-prof-mercredi")));
	                emploi.setH_4_6_prof_mercredi(parseJsonArray(resultSet.getString("4-6-prof-mercredi")));

	                emploi.setH_8_10_salle_mercredi(parseJsonArray(resultSet.getString("8-10-salle-mercredi")));
	                emploi.setH_10_12_salle_mercredi(parseJsonArray(resultSet.getString("10-12-salle-mercredi")));
	                emploi.setH_2_4_salle_mercredi(parseJsonArray(resultSet.getString("2-4-salle-mercredi")));
	                emploi.setH_4_6_salle_mercredi(parseJsonArray(resultSet.getString("4-6-salle-mercredi")));
	                
	                //JEUDI
	                emploi.setH_8_10_element_jeudi(parseJsonArray(resultSet.getString("8-10-element-jeudi")));
	                emploi.setH_10_12_element_jeudi(parseJsonArray(resultSet.getString("10-12-element-jeudi")));
	                emploi.setH_2_4_element_jeudi(parseJsonArray(resultSet.getString("2-4-element-jeudi")));
	                emploi.setH_4_6_element_jeudi(parseJsonArray(resultSet.getString("4-6-element-jeudi")));

	                emploi.setH_8_10_prof_jeudi(parseJsonArray(resultSet.getString("8-10-prof-jeudi")));
	                emploi.setH_10_12_prof_jeudi(parseJsonArray(resultSet.getString("10-12-prof-jeudi")));
	                emploi.setH_2_4_prof_jeudi(parseJsonArray(resultSet.getString("2-4-prof-jeudi")));
	                emploi.setH_4_6_prof_jeudi(parseJsonArray(resultSet.getString("4-6-prof-jeudi")));

	                emploi.setH_8_10_salle_jeudi(parseJsonArray(resultSet.getString("8-10-salle-jeudi")));
	                emploi.setH_10_12_salle_jeudi(parseJsonArray(resultSet.getString("10-12-salle-jeudi")));
	                emploi.setH_2_4_salle_jeudi(parseJsonArray(resultSet.getString("2-4-salle-jeudi")));
	                emploi.setH_4_6_salle_jeudi(parseJsonArray(resultSet.getString("4-6-salle-jeudi")));
	                
	                //VENDREDI
	                emploi.setH_8_10_element_vendredi(parseJsonArray(resultSet.getString("8-10-element-vendredi")));
	                emploi.setH_10_12_element_vendredi(parseJsonArray(resultSet.getString("10-12-element-vendredi")));
	                emploi.setH_2_4_element_vendredi(parseJsonArray(resultSet.getString("2-4-element-vendredi")));
	                emploi.setH_4_6_element_vendredi(parseJsonArray(resultSet.getString("4-6-element-vendredi")));

	                emploi.setH_8_10_prof_vendredi(parseJsonArray(resultSet.getString("8-10-prof-vendredi")));
	                emploi.setH_10_12_prof_vendredi(parseJsonArray(resultSet.getString("10-12-prof-vendredi")));
	                emploi.setH_2_4_prof_vendredi(parseJsonArray(resultSet.getString("2-4-prof-vendredi")));
	                emploi.setH_4_6_prof_vendredi(parseJsonArray(resultSet.getString("4-6-prof-vendredi")));

	                emploi.setH_8_10_salle_vendredi(parseJsonArray(resultSet.getString("8-10-salle-vendredi")));
	                emploi.setH_10_12_salle_vendredi(parseJsonArray(resultSet.getString("10-12-salle-vendredi")));
	                emploi.setH_2_4_salle_vendredi(parseJsonArray(resultSet.getString("2-4-salle-vendredi")));
	                emploi.setH_4_6_salle_vendredi(parseJsonArray(resultSet.getString("4-6-salle-vendredi")));


	                emploi.setId(resultSet.getInt("id"));
	                emploi.setDate(resultSet.getDate("date").toLocalDate());
	                emploi.setCni_user(resultSet.getString("cni_user"));;
	                //emploi.setFilierTitel(resultSet.getString("filier_titel"));
	                
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return emploi;
	}



}
