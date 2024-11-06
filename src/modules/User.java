package modules;

import java.sql.Date;

public class User {

	protected String cni;
	protected String nom;
	protected String prenom;
	protected String image;
	protected String role;
	protected String password;
	protected String tel;
	protected String email;
	protected String dateNaissance;
	
	
	public User() {}
	
	public User(String cni,String nom,String prenom,String image,String role, String password,String tel,String email,String dateNaissance) {
		this.cni=cni;
		this.nom=nom;
		this.prenom=prenom;
		this.role=role;
		this.password=password;
		this.tel=tel;
		this.email=email;
		this.dateNaissance=dateNaissance;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public String toString() {
		return "Nom Complete"+nom+" "+prenom;
	}

	public String getCni() {
		return cni;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
