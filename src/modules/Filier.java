
package modules;

public class Filier {

	private int id;
	private String titel;
	private int programmeId;
	
	public Filier() {}
	
	public Filier(int id,String titel,int programmeId) {
		this.id=id;
		this.titel=titel;
		this.programmeId=programmeId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public int getProgrammeId() {
		return programmeId;
	}
	public void setProgrammeId(int programmeId) {
		this.programmeId = programmeId;
	}
	
	
}
