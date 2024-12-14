package email_marketing.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Lead {
	private String leadId;
	private String nom;
	private List<String> listClientEmails;
	
	public Lead(String leadId, String nom, List<String> listClientEmails) {
		this.leadId = leadId;
		this.nom = nom;
		this.listClientEmails = listClientEmails;
	}
	
	// Getters & Setters
	public String getLeadId() {
		return this.leadId;
	}
	
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<String> getListClientEmails() {
		return listClientEmails;
	}

	public void setListClientEmails(List<String> listClientEmails) {
		this.listClientEmails = listClientEmails;
	}
	
	public void addEmail(String email) {
		if (!email.isEmpty() && !this.listClientEmails.contains(email)) {
			this.listClientEmails.add(email);
		}
	}
	
	public void updateEmail(String oldEmail, String newEmail) {
		if (!newEmail.isEmpty()) {
			this.listClientEmails.set(this.listClientEmails.indexOf(oldEmail), newEmail);
		}
	}
	
	public void removeEmail(String email) {
		this.listClientEmails.remove(email);
	}
	
	// Database Operations
	// save a lead to the database
	public void saveToDatabase(Connection connection, String userId) throws SQLException {
		String leadQuery = "INSERT INTO lead(lead_id, lead_name, user_id) VALUES (?, ?, ?) ";
		
		try (PreparedStatement leadStatement = connection.prepareStatement(leadQuery)) {
			leadStatement.setString(1, java.util.UUID.randomUUID().toString());
			leadStatement.setString(2, this.nom);
			leadStatement.setString(3, userId);
			
			leadStatement.executeUpdate();
		}
		
		String emailQuery = "INSERT INTO email_client (email_client_id, email_address, lead_id) VALUES (?, ?, ?)";
		try (PreparedStatement emailStatement = connection.prepareStatement(emailQuery)) {
			for (String email : this.listClientEmails) {
				emailStatement.setString(1, java.util.UUID.randomUUID().toString());
				emailStatement.setString(2, email);
				emailStatement.setString(3, this.leadId);
				
			}
		}
	}

	
	// Get leads from database
	public static Lead getLeadFromDatabase(Connection connection, String leadId) throws SQLException {
		String leadQuery = "SELECT lead_name FROM lead WHERE lead_id = ?";
		String leadName = null;
		try (PreparedStatement leadStatement = connection.prepareStatement(leadQuery)) {
			leadStatement.setString(1, leadId);
			ResultSet resultSet = leadStatement.executeQuery();
			if (resultSet.next()) {
				leadName = resultSet.getString("lead_name");
			}
		}
		
		// get emails associated with the lead
		String emailQuery = "SELECT email_address FROM email_client WHERE lead_id = ?";
		List<String> emails = new ArrayList<>();
		try (PreparedStatement emailStatement = connection.prepareStatement(emailQuery)) {
			emailStatement.setString(1, leadId);
			ResultSet resultSet = emailStatement.executeQuery();
			while (resultSet.next()) {
				emails.add(resultSet.getString("email_address"));
			}
		}
		
		if (leadName != null) {
			return new Lead(leadId, leadName, emails);
		}
		
		return null;
	}
	
	// delete lead from database
	public void deleteFromDatabase(Connection connection) throws SQLException {
		
		// delete client emails
		String deleteEmailQuery = "DELETE FROM email_client WHERE lead_id = ?";
		
		try (PreparedStatement deleteEmailStmt = connection.prepareStatement(deleteEmailQuery)) {
			deleteEmailStmt.setString(1, this.leadId);
			deleteEmailStmt.executeQuery();
		}
		
		// delete lead
		String deleteLeadQuery = "DELETE FROM lead WHERE lead_id = ?";
		try (PreparedStatement deleteLeadStmt = connection.prepareStatement(deleteLeadQuery)) {
			deleteLeadStmt.setString(1, this.leadId);
			deleteLeadStmt.executeQuery();
		}
	}
}
