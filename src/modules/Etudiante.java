package modules;

public class Etudiante extends User{

	String cne;
	String type_bac;
	Double note_bac;
	String type_bac2;
	Double note_bac2;
	int id_filier;
	String cni_user;
	
	public Etudiante() {}
	
	public Etudiante(
			//String cni,
			//String nom,
			//String prenom,
			//String image,
			//String role,
			//String password,
			//String tel,
			//String email,
			String cne,
			String type_bac,
			Double note_bac,
			String type_bac2,
			Double note_bac2,
			int id_filier,
			String cni_user) {
		
		//super(cni,nom,prenom,image,role,password,tel,email);
		this.cne=cne;
		this.type_bac=type_bac;
		this.note_bac=note_bac;
		this.type_bac2=type_bac2;
		this.note_bac2=note_bac2;
		this.id_filier=id_filier;
		this.cni_user=cni_user;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getType_bac() {
		return type_bac;
	}

	public void setType_bac(String type_bac) {
		this.type_bac = type_bac;
	}

	public Double getNote_bac() {
		return note_bac;
	}

	public void setNote_bac(Double note_bac) {
		this.note_bac = note_bac;
	}

	public String getType_bac2() {
		return type_bac2;
	}

	public void setType_bac2(String type_bac2) {
		this.type_bac2 = type_bac2;
	}

	public Double getNote_bac2() {
		return note_bac2;
	}

	public void setNote_bac2(Double note_bac2) {
		this.note_bac2 = note_bac2;
	}

	public int getId_filier() {
		return id_filier;
	}

	public void setId_filier(int id_filier) {
		this.id_filier = id_filier;
	}

	public String getCni_user() {
		return cni_user;
	}

	public void setCni_user(String cni_user) {
		this.cni_user = cni_user;
	}
	
	
	
}
