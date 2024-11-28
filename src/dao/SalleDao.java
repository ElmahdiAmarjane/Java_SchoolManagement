package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db_connect.JDBC;
import modules.Professeur;
import modules.Salle;
import services.ISalleServices;

public class SalleDao implements ISalleServices{

	@Override
	public boolean insertSalle(Salle salle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Salle> selectSalle() {
		List<Salle> salles= new ArrayList<>();
        String query = "SELECT * FROM salle";
        try (Connection connection = JDBC.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        	
        	ResultSet resultSet = preparedStatement.executeQuery();
        	 while (resultSet.next()) {
                 Salle salle = new Salle();
                 salle.setTitel(resultSet.getString("titel"));
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
                 salles.add(salle);
        	 }
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        
        return salles;
	}

}
