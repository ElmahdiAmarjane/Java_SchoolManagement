package email_marketing.model;

import java.time.LocalTime;

public class FollowUpModel extends EmailTemplateModel {
	private String type;
	private LocalTime delay;
	
	public FollowUpModel(String subject, String body, String type, LocalTime delay) {
		super(subject, body);
		this.type = type;
		this.delay = delay;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalTime getDelay() {
		return delay;
	}
	public void setDelay(LocalTime delay) {
		this.delay = delay;
	}
}
