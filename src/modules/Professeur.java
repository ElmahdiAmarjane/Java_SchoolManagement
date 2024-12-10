package modules;

import java.time.LocalDate;

public class Professeur extends User{

	private int id;
	private int rip;
	private String doctorant_type;
	private String doctorant_mention;
	private String etablissement;
	private String cni_user;
	private String imagecv;
	private String Matiere_enseigne;
	private String type_contrat;
	
	public Professeur() {}
	
	
	public Professeur(
			String cni,
			String nom,
			String prenom,
			String image,
			String role,
			String password,
			String tel,
			String email,
			LocalDate dateNaissance,
			int rip,
			String doctorant_type,
			String doctorant_mention,
			String faculter,
			String cni_user,
			String cv
			) {
		super(cni,nom,prenom,image,role,password,tel,email, dateNaissance);
		this.rip=rip;
		this.doctorant_type=doctorant_type;
		this.doctorant_mention=doctorant_mention;
		this.etablissement=faculter;
		this.cni_user=cni_user;
		this.imagecv=cv;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getRip() {
		return rip;
	}


	public void setRip(int rip) {
		this.rip = rip;
	}


	public String getDoctorant_type() {
		return doctorant_type;
	}


	public void setDoctorant_type(String doctorant_type) {
		this.doctorant_type = doctorant_type;
	}


	public String getDoctorant_mention() {
		return doctorant_mention;
	}


	public void setDoctorant_mention(String doctorant_mention) {
		this.doctorant_mention = doctorant_mention;
	}


	

	public String getEtablissement() {
		return etablissement;
	}


	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}


	public String getCni_user() {
		return this.cni_user;
	}


	public void setCni_user(String cni_user) {
		this.cni_user = cni_user;
	}


	public String getImagecv() {
		return imagecv;
	}


	public void setImagecv(String imagecv) {
		this.imagecv = imagecv;
	}


	public String getMatiere_enseigne() {
		return Matiere_enseigne;
	}


	public void setMatiere_enseigne(String matiere_enseigne) {
		Matiere_enseigne = matiere_enseigne;
	}


	public String getType_contrat() {
		return type_contrat;
	}


	public void setType_contrat(String type_contrat) {
		this.type_contrat = type_contrat;
	}
	
	
}