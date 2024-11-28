package modules;

public class Salle {

	private int id;
	private String titel;
	
	public Salle() {}
	public Salle(int id,String titel) {
		this.id=id;
		this.titel=titel;
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
	
	
}
