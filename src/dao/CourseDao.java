package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db_connect.JDBC;
import modules.Course;
import services.ICourseServices;

public class CourseDao implements ICourseServices{

	@Override
	public List<Course> selectCoursesByFilliere(int filliereID) {
		 List<Course> courses = new ArrayList<>();
	        String query = "SELECT * FROM Course where id_filliere = ?";

	        try (Connection connection = JDBC.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        	 preparedStatement.setInt(1, filliereID);
	        	 
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Course course = new Course();
	                course.setId(resultSet.getInt("id"));
	                course.setTitle(resultSet.getString("title"));
	                course.setDescription(resultSet.getString("description"));
	                course.setFiles(resultSet.getString("files"));
	                course.setType(resultSet.getString("type"));
	                course.setDatePublication(resultSet.getDate("datePublication"));
	                courses.add(course);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return courses;
	}

}
