package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db_connect.JDBC;
import modules.Element;
import modules.Filier;
import services.IElementServices;

public class ElementDao implements IElementServices{

	@Override
	public List<Element> selectAllElemnt() {
		 List<Element> elements = new ArrayList<>();
	        String query = "SELECT * FROM element";

	        try (Connection connection = JDBC.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Element element = new Element();
	                element.setNom(resultSet.getString("nom"));
	                
	                elements.add(element);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return elements;
	}

}
