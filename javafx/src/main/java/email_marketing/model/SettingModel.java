package email_marketing.model;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;

public class SettingModel {
	private List<SendingEmailModel> sendingEmailList;
	private LocalTime delayBetweenEmails;
	private LocalTime startHour;
	private LocalTime endHour;
	
	public SettingModel(List<SendingEmailModel> sendingEmailList, LocalTime delayBetweenEmails, LocalTime startHour,
			LocalTime endHour) {
		super();
		this.sendingEmailList = sendingEmailList;
		this.delayBetweenEmails = delayBetweenEmails;
		this.startHour = startHour;
		this.endHour = endHour;
	}
	
	// Getters & Setters
	public List<SendingEmailModel> getSendingEmailList() {
		return sendingEmailList;
	}

	public void setSendingEmailList(List<SendingEmailModel> sendingEmailList) {
		this.sendingEmailList = sendingEmailList;
	}

	public LocalTime getDelayBetweenEmails() {
		return delayBetweenEmails;
	}

	public void setDelayBetweenEmails(LocalTime delayBetweenEmails) {
		this.delayBetweenEmails = delayBetweenEmails;
	}

	public LocalTime getStartHour() {
		return startHour;
	}

	public void setStartHour(LocalTime startHour) {
		this.startHour = startHour;
	}

	public LocalTime getEndHour() {
		return endHour;
	}

	public void setEndHour(LocalTime endHour) {
		this.endHour = endHour;
	}
	
	public void addSendingEmail(SendingEmailModel email) {
		this.sendingEmailList.add(email);
	}
	
	public void updateSendingEmail(SendingEmailModel oldSendingEmail, SendingEmailModel newSendingEmail) {
		this.sendingEmailList.set(this.sendingEmailList.indexOf(oldSendingEmail), newSendingEmail);
	}
	
	public void deleteSendingEmail(SendingEmailModel email) {
		this.sendingEmailList.remove(email);
	}
	
	// Save Settings to the database
	public void saveToDatabase(Connection connection, String settingId, String userId) throws SQLException {
		String settinQuery = "INSERT INTO setting (setting_id, delay_between_emails, start_hour, end_hour) " +
		"VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE delay_between_emails = ?, start_hour = ?, end_hour = ?";
		
		try (PreparedStatement settingStmt = connection.prepareStatement(settinQuery)) {
			settingStmt.setString(1, settingId);
			settingStmt.setInt(2, this.delayBetweenEmails.getSecond());
			settingStmt.setInt(3, this.startHour.getHour());
			settingStmt.setInt(4, this.endHour.getHour());
			settingStmt.setInt(5, this.delayBetweenEmails.getSecond());
			settingStmt.setInt(6, this.startHour.getHour());
			settingStmt.setInt(7, this.endHour.getHour());
			settingStmt.executeQuery();
		}
	}
}
