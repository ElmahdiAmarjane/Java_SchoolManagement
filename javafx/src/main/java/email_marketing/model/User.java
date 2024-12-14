package email_marketing.model;

import email_marketing.database.DatabaseConnection;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;

public class User {
    private String id;
    private String username;
    private String email;
    private String password;
    private List<Campaign> campaignList;
    private List<Lead> leadList;

    public User(String id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.campaignList = new ArrayList<>();
        this.leadList = new ArrayList<>();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public List<Lead> getLeadList() {
        return leadList;
    }
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static User login(String username, String password) {
        String query = "SELECT * FROM user WHERE username = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");
                if (BCrypt.checkpw(password, hashedPassword)) {
                    User user = new User(rs.getString("user_id"), rs.getString("username"), rs.getString("email"));
                    //user.loadUserData(); // Load leads and campaigns
                    return user;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error during login: " + e.getMessage());
        }
        return null; // Login failed
    }

	public static boolean signup(String username, String email, String password) {
	    String userId = UUID.randomUUID().toString(); // Generate unique user ID
	    String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
	    String query = "INSERT INTO user (user_id, username, email, password) VALUES (?, ?, ?, ?)";

	    try (Connection conn = DatabaseConnection.connect();
	         PreparedStatement pstmt = conn.prepareStatement(query)) {
	        pstmt.setString(1, userId); // Set the generated user ID
	        pstmt.setString(2, username);
	        pstmt.setString(3, email);
	        pstmt.setString(4, hashedPassword);
	        pstmt.executeUpdate();
	        return true; // Signup successful
	    } catch (SQLException e) {
	        System.out.println("Error during signup: " + e.getMessage());
	    }
	    return false; // Signup failed
	}


    /*public void modifyProfile(String newUsername, String newEmail, String newPassword) {
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        String query = "UPDATE user SET username = ?, email = ?, password = ? WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newUsername);
            pstmt.setString(2, newEmail);
            pstmt.setString(3, hashedPassword);
            pstmt.setString(4, id);
            pstmt.executeUpdate();

            this.username = newUsername;
            this.email = newEmail;
            this.setPassword(hashedPassword);
        } catch (SQLException e) {
            System.out.println("Error updating profile: " + e.getMessage());
        }
    }

    public void deleteAccount() {
        String query = "DELETE FROM user WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting account: " + e.getMessage());
        }
    }

    public void addLead(String leadName, List<String> leadEmails) {
        String query = "INSERT INTO lead (user_id, name, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            pstmt.setString(2, leadName);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
            Lead newLead = new Lead(String.valueOf(id), leadName, leadEmails);
            leadList.add(newLead);
        } catch (SQLException e) {
            System.out.println("Error adding lead: " + e.getMessage());
        }
    }

    public void updateLead(String oldName, String newName, String newEmail) {
        String query = "UPDATE lead SET name = ?, email = ? WHERE user_id = ? AND name = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newName);
            pstmt.setString(2, newEmail);
            pstmt.setString(3, id);
            pstmt.setString(4, oldName);
            pstmt.executeUpdate();

            for (Lead lead : leadList) {
                if (lead.getNom().equals(oldName)) {
                    lead.setNom(newName);
                    lead.addEmail(newEmail);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating lead: " + e.getMessage());
        }
    }

    public void deleteLead(String leadName) {
        String query = "DELETE FROM lead WHERE user_id = ? AND name = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            pstmt.setString(2, leadName);
            pstmt.executeUpdate();

            leadList.removeIf(lead -> lead.getNom().equals(leadName));
        } catch (SQLException e) {
            System.out.println("Error deleting lead: " + e.getMessage());
        }
    }

    public void addCampaign(String name,String description,String status,List<EmailTemplateModel> emailTemplates,SettingModel setting,List<Lead> campaignLeads,LocalDate startDate) {
    	    String query = "INSERT INTO campaign (user_id, name, description, status, creation_date, start_date) VALUES (?, ?, ?, ?, ?, ?)";
    	    LocalDate creationDate = LocalDate.now();

    	    try (Connection conn = DatabaseConnection.connect();
    	         PreparedStatement pstmt = conn.prepareStatement(query)) {
    	         
    	        pstmt.setString(1, id);
    	        pstmt.setString(2, name);
    	        pstmt.setString(3, description);
    	        pstmt.setString(4, status);
    	        pstmt.setDate(5, java.sql.Date.valueOf(creationDate));
    	        pstmt.setDate(6, java.sql.Date.valueOf(startDate));
    	        pstmt.executeUpdate();

    	        Campaign newCampaign = new Campaign(name,emailTemplates,setting,status,description,creationDate,campaignLeads,startDate);

    	        campaignList.add(newCampaign);
    	    } catch (SQLException e) {
    	        System.out.println("Error adding campaign: " + e.getMessage());
    	    }
    	}

    public void modifyCampaign(String oldName, String newName, String newDescription, String newStatus) {
        String query = "UPDATE campaign SET name = ?, description = ?, status = ? WHERE user_id = ? AND name = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newName);
            pstmt.setString(2, newDescription);
            pstmt.setString(3, newStatus);
            pstmt.setString(4, id);
            pstmt.setString(5, oldName);
            pstmt.executeUpdate();

            for (Campaign campaign : campaignList) {
                if (campaign.getName().equals(oldName)) {
                    campaign.setName(newName);
                    campaign.setDescription(newDescription);
                    campaign.setStatus(newStatus);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error modifying campaign: " + e.getMessage());
        }
    }

    public void deleteCampaign(String campaignName) {
        String query = "DELETE FROM campaign WHERE user_id = ? AND name = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            pstmt.setString(2, campaignName);
            pstmt.executeUpdate();

            campaignList.removeIf(campaign -> campaign.getName().equals(campaignName));
        } catch (SQLException e) {
            System.out.println("Error deleting campaign: " + e.getMessage());
        }
    }

    private void loadUserData() {
        loadCampaigns();
        loadLeads();
    }

    private void loadCampaigns() {
        String query = "SELECT name, description, status, creation_date, start_date FROM campaign WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String status = rs.getString("status");
                LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
                LocalDate startDate = rs.getDate("start_date").toLocalDate();

                List<EmailTemplateModel> emailTemplates = fetchEmailTemplatesForCampaign(name);

                SettingModel setting = fetchSettingForCampaign(name);

                List<Lead> campaignLeads = fetchLeadsForCampaign(name);

                Campaign campaign = new Campaign(name,emailTemplates,setting,status,description,creationDate,campaignLeads,startDate
                );

                campaignList.add(campaign);
            }
        } catch (SQLException e) {
            System.out.println("Error loading campaigns: " + e.getMessage());
        }
    }
    private List<EmailTemplateModel> fetchEmailTemplatesForCampaign(String campaignId) {
        List<EmailTemplateModel> emailTemplates = new ArrayList<>();
        String query = "SELECT subject, body FROM email_template WHERE campaign_id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, campaignId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                emailTemplates.add(new EmailTemplateModel(
                    rs.getString("subject"),
                    rs.getString("body")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching email templates: " + e.getMessage());
        }
        return emailTemplates;
    }
    
    private SettingModel fetchSettingForCampaign(String settingId) {
        String query = "SELECT s.delay_between_emails, s.start_hour, s.end_hour " +
                       "FROM setting s WHERE s.setting_id = ?";
        SettingModel setting = null;
        List<SendingEmailModel> sendingEmailList = fetchSendingEmailsForSetting(settingId);
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, settingId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                setting = new SettingModel(
                    sendingEmailList,
                    LocalTime.ofSecondOfDay(rs.getInt("delay_between_emails")),
                    rs.getTime("start_hour").toLocalTime(),
                    rs.getTime("end_hour").toLocalTime()
                );
            }
        } catch (SQLException e) {
            System.out.println("Error fetching setting: " + e.getMessage());
        }
        return setting;
    }

    private List<SendingEmailModel> fetchSendingEmailsForSetting(String settingId) {
        List<SendingEmailModel> sendingEmailModels = new ArrayList<>();
        String query = "SELECT se.email, se.stmp_password, se.max_email_per_day, se.is_selected " +
                       "FROM sending_email se JOIN setting_sending_email sse ON se.sending_email_id = sse.sending_email_id " +
                       "WHERE sse.setting_id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, settingId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                sendingEmailModels.add(new SendingEmailModel(
                    rs.getString("email"),
                    rs.getString("stmp_password"),
                    rs.getInt("max_email_per_day"),
                    rs.getBoolean("is_selected")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching sending emails for setting: " + e.getMessage());
        }
        return sendingEmailModels;
    }

    private List<Lead> fetchLeadsForCampaign(String campaignId) {
        List<Lead> leads = new ArrayList<>();
        String query = "SELECT l.lead_id, l.lead_name " +
                       "FROM lead l JOIN campaign_lead cl ON l.lead_id = cl.lead_id WHERE cl.campaign_id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, campaignId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String leadId = rs.getString("lead_id");
                List<String> emails = fetchEmailsForLead(leadId);
                leads.add(new Lead(leadId, rs.getString("lead_name"), emails));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching leads: " + e.getMessage());
        }
        return leads;
    }
    private List<String> fetchEmailsForLead(String leadId) {
        List<String> emails = new ArrayList<>();
        String query = "SELECT email_address FROM email_client WHERE lead_id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, leadId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                emails.add(rs.getString("email_address"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching emails for lead: " + e.getMessage());
        }
        return emails;
    }
    private void loadLeads() {
        String query = "SELECT name, email FROM lead WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String leadName = rs.getString("name");
                String email = rs.getString("email");
                Lead lead = new Lead(String.valueOf(id), leadName, List.of(email));
                leadList.add(lead);
            }
        } catch (SQLException e) {
            System.out.println("Error loading leads: " + e.getMessage());
        }
    }*/
    @Override
	public String toString() {
		return "User," +this.id+"," + this.username + "," + this.email;
    }
}
