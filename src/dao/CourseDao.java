package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
	                course.setDatePublication(resultSet.getDate("datePublication").toLocalDate());
	                courses.add(course);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return courses;
	}

	@Override
	public boolean insertCours(Course course) {
	    if (course.getDatePublication() == null) {
	        System.out.println("Error: Date of publication is null.");
	        return false; // Or handle appropriately
	    }
	    
	    String query = "INSERT INTO course (title, description, files, type, filier_titel, element_id, datePublication, date_limit) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        // Set parameters for the query
	        preparedStatement.setString(1, course.getTitle());
	        preparedStatement.setString(2, course.getDescription());
	        preparedStatement.setString(3, course.getFiles());
	        preparedStatement.setString(4, course.getType());
	        preparedStatement.setString(5, course.getFilier_titel());
	        preparedStatement.setString(6, course.getElement_id());

	        // Check if datePublication is null
	        if (course.getDatePublication() != null) {
	            preparedStatement.setDate(7, java.sql.Date.valueOf(course.getDatePublication()));
	        } else {
	            preparedStatement.setNull(7, java.sql.Types.DATE); // Set null if date is missing
	        }

	        // Same check for date_limit (if it's also a LocalDate)
	        if (course.getDate_limit() != null) {
	            preparedStatement.setDate(8, java.sql.Date.valueOf(course.getDate_limit()));
	        } else {
	            preparedStatement.setNull(8, java.sql.Types.DATE);
	        }

	        // Execute the update
	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Course inserted successfully.");
	            return true;
	        } else {
	            System.out.println("Failed to insert Course.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}


}