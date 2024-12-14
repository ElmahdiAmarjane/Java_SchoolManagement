package email_marketing.model;

import java.util.List;
import java.time.LocalDate;

public class Campaign {
	private String name;
	private List<EmailTemplateModel> emailTemplates;
	private SettingModel setting;
	private String status;
	private String description;
	private LocalDate creationDate;
	private List<Lead> campaignLeads;
	private LocalDate startDate;
	
	public Campaign(String name, List<EmailTemplateModel> emailTemplates, SettingModel setting, String status, String description,
			LocalDate creationDate, List<Lead> campaignLeads, LocalDate startDate) {
		this.name = name;
		this.emailTemplates = emailTemplates;
		this.setting = setting;
		this.status = status;
		this.description = description;
		this.creationDate = creationDate;
		this.campaignLeads = campaignLeads;
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmailTemplateModel> getEmailTemplates() {
		return emailTemplates;
	}

	public void setEmailTemplates(List<EmailTemplateModel> emailTemplates) {
		this.emailTemplates = emailTemplates;
	}

	public SettingModel getSetting() {
		return setting;
	}

	public void setSetting(SettingModel setting) {
		this.setting = setting;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public List<Lead> getCampaignLeads() {
		return campaignLeads;
	}

	public void setCampaignLeads(List<Lead> campaignLeads) {
		this.campaignLeads = campaignLeads;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public void sendAutoEmail() {
		// TODO: send an email automatically
	}
	
	public void addFollowUp() {
		// TODO: add a follow up email
	}
	
	public void sendFollowUp() {
		// TODO: send a follow up Email
	}
	
	public void deleteFollowUp() {
		// TODO: delete a follow up email
	}
	
	public void addEmailTemplate(EmailTemplateModel newEmailTemplate) {
		if (!this.emailTemplates.isEmpty()) {
			this.emailTemplates.add(newEmailTemplate);
		}
	}
}
