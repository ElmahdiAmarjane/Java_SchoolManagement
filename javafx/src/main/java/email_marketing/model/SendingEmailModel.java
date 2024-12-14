package email_marketing.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SendingEmailModel {
	private String email;
	private String passwordSMTP;
	private int maxEmailPerDay;
	private boolean isSelected;
	
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/email_marketing";
	private static final String DB_USER = "";
	private static final String DB_PASSWORD = "";
	
	public SendingEmailModel(String email, String passwordSMTP, int maxEmailPerDay, boolean isSelected) {
		this.email = email;
		this.passwordSMTP = passwordSMTP;
		this.maxEmailPerDay = maxEmailPerDay;
		this.isSelected = isSelected;
	}
	
	
	// Getters & Setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswordSMTP() {
		return passwordSMTP;
	}
	public void setPasswordSMTP(String passwordSMTP) {
		this.passwordSMTP = passwordSMTP;
	}
	public int getMaxEmailPerDay() {
		return maxEmailPerDay;
	}
	public void setMaxEmailPerDay(int maxEmailPerDay) {
		this.maxEmailPerDay = maxEmailPerDay;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	// Database Operations
	// Add new email
	public void addSendingEmail(String userID) {
		String query = "INSERT INTO sending_email (sending_email_id, user_id, stmp_password, max_email_per_day, is_selected) VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			String id = UUID.randomUUID().toString();
			
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, userID);
			preparedStatement.setString(3, this.passwordSMTP);
			preparedStatement.setInt(4, this.maxEmailPerDay);
			preparedStatement.setBoolean(5, this.isSelected);
			
			preparedStatement.executeUpdate();
			System.out.println("Email added successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Get all emails
	public static List<SendingEmailModel> getAllSendingEmails() {
		String query = "SELECT * FROM sending_email";
		List<SendingEmailModel> emails = new ArrayList<>();
		
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
					Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {
			while (resultSet.next()) {
				String email = resultSet.getString("sending_email_id");
				String smtpPassword = resultSet.getString("smpt_password");
				int maxEmails = resultSet.getInt("max_email_per_day");
				boolean isSelected = resultSet.getBoolean("is_selected");
				
				emails.add(new SendingEmailModel(email, smtpPassword, maxEmails, isSelected));
			}
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
		
		return emails;
	}
	
	// Update an email
	public void updateSendingEmail(String sendingEmailId) {
		String query = "UPDATE sending_email SET smtp_password = ?, max_email_per_day = ?, isSelected = ? WHERE sending_email_id = ?";
		
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, this.passwordSMTP);
			preparedStatement.setInt(2, this.maxEmailPerDay);
			preparedStatement.setBoolean(3, this.isSelected);
			preparedStatement.setString(4, sendingEmailId);
			
			preparedStatement.executeUpdate();
			System.out.println("Email updated successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// delete an email
	public void deleteSendingEmail(String sendingEmailId) {
		String query = "DELETE FROM sending_email WHERE sending_email_id = ?";
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, sendingEmailId);
			preparedStatement.executeUpdate();
			System.out.println("Email deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
