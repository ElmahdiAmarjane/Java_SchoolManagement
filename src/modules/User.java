package modules;

import java.sql.Date;
import java.time.LocalDate;

public class User {

	protected String cni;
	protected String nom;
	protected String prenom;
	protected String image;
	protected String role;
	protected String password;
	protected String adress;
	protected String tel;
	protected String email;
	protected String Sexe;
	protected LocalDate dateNaissance;
	protected String Nationalite;
	protected String imagecni;
	
	
	public User() {}
	
	public User(String cni,String nom,String prenom,String image,String role, String password,String tel,String email,LocalDate dateNaissance) {
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

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	/*public String toString() {
		return " "+nom+" "+prenom;
	}*/

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

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		Sexe = sexe;
	}

	public String getNationalite() {
		return Nationalite;
	}

	public void setNationalite(String nationalite) {
		Nationalite = nationalite;
	}

	public String getImageCni() {
		return imagecni;
	}

	public void setImageCni(String imagecni) {
		this.imagecni = imagecni;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "User [cni=" + cni + ", nom=" + nom + ", prenom=" + prenom + ", image=" + image + ", role=" + role
				+ ", password=" + password + ", adress=" + adress + ", tel=" + tel + ", email=" + email + ", Sexe="
				+ Sexe + ", dateNaissance=" + dateNaissance + ", Nationalite=" + Nationalite + ", imagecni=" + imagecni
				+ "]";
	}
	
	
	
	
	
	
	
	
}