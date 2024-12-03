package modules;


import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Absence {

	private int id;
	List<String> cne_etudiants;
	LocalDate date;
	Time heure_debut;
	Time heure_fine;
	String filier_titel;
	int element_id;
	
	public Absence() {}
	
	public Absence(int id,List<String> cne_etudiants,LocalDate date,Time heure_debut,Time heure_fine,String filier_titel,int element_id) {
		this.id=id;
		this.cne_etudiants=cne_etudiants;
		this.date=date;
		this.heure_debut=heure_debut;
		this.filier_titel=filier_titel;
		this.element_id=element_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getCne_etudiants() {
		return cne_etudiants;
	}
	public void setCne_etudiants(List<String> cne_etudiants) {
		this.cne_etudiants = cne_etudiants;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Time getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(Time heure_debut) {
		this.heure_debut = heure_debut;
	}
	public Time getHeure_fine() {
		return heure_fine;
	}
	public void setHeure_fine(Time heure_fine) {
		this.heure_fine = heure_fine;
	}
	public String getFilier_titel() {
		return filier_titel;
	}
	public void setFilier_titel(String filier_titel) {
		this.filier_titel = filier_titel;
	}
	public int getElement_id() {
		return element_id;
	}
	public void setElement_id(int element_id) {
		this.element_id = element_id;
	}
	
}
