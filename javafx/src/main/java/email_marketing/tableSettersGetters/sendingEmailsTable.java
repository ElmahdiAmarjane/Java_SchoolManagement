package email_marketing.tableSettersGetters;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class sendingEmailsTable {
	
	private CheckBox selected;
	String email;
	int max_use;
	Button delete;
	
	public sendingEmailsTable(CheckBox selected,String email,int max_use ){
		this.email = email;
		this.selected = selected;
		this.max_use = max_use;
		this.delete = new Button("Delete");
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMax_use() {
		return max_use;
	}
	public void setMax_use(int max_use) {
		this.max_use = max_use;
	}
	public Button getDelete() {
		return delete;
	}
	public void setDelete(Button delete) {
		this.delete = delete;
	}
	public CheckBox getSelected() {
		return selected;
	}
	public void setSelected(CheckBox selected) {
		this.selected = selected;
	}
}
