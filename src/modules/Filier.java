
package modules;

public class Filier {

	private int id;
	private String title;
	private String shortName;
	private String filliereLogo;
	private int programmeId;
	
	public Filier() {}
	
	public Filier(int id,String title,String shortName,String filliereLogo,int programmeId) {
		this.id=id;
		this.title=title;
		this.shortName=shortName;
		this.filliereLogo=filliereLogo;
		this.programmeId=programmeId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitel() {
		return title;
	}
	public void setTitel(String titel) {
		this.title = titel;
	}
	public int getProgrammeId() {
		return programmeId;
	}
	public void setProgrammeId(int programmeId) {
		this.programmeId = programmeId;
	}
	
	public String getShortName() {
		return this.shortName;
	}
	public String getFilliereLogo() {
		return this.filliereLogo;
	}
	public void setShortName(String shortName) {
		 this.shortName = shortName;
	}
	public void setFilliereLogo(String filiereLogo) {
	     this.filliereLogo=filliereLogo;
	}
	
	
	
	
}