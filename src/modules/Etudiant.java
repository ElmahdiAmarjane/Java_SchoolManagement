package modules;

public class Etudiant extends User{

	String cne;
	String type_bac;
	Double note_bac;
	String type_bac2;
	Double note_bac2;
	int id_filier;
	String cni_user;
	String imageBac;
	String imageBac2;
	String imageS1;
	String imageS2;
	String imageS3;
	String imageS4;
	
	public Etudiant() {}
	
	public Etudiant(
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
			String cni_user,
			String imageBac,
			String imageBac2,
			String imageS1,
			String imageS2,
			String imageS3,
			String imageS4
			) {
		
		//super(cni,nom,prenom,image,role,password,tel,email);
		this.cne=cne;
		this.type_bac=type_bac;
		this.note_bac=note_bac;
		this.type_bac2=type_bac2;
		this.note_bac2=note_bac2;
		this.id_filier=id_filier;
		this.cni_user=cni_user;
		this.imageBac=imageBac;
		this.imageBac=imageBac2;
		this.imageBac=imageS1;
		this.imageBac=imageS2;
		this.imageBac=imageS3;
		this.imageBac=imageS4;
	}

	public String getImageBac() {
		return imageBac;
	}

	public void setImageBac(String imageBac) {
		this.imageBac = imageBac;
	}

	public String getImageBac2() {
		return imageBac2;
	}

	public void setImageBac2(String imageBac2) {
		this.imageBac2 = imageBac2;
	}

	public String getImageS1() {
		return imageS1;
	}

	public void setImageS1(String imageS1) {
		this.imageS1 = imageS1;
	}

	public String getImageS2() {
		return imageS2;
	}

	public void setImageS2(String imageS2) {
		this.imageS2 = imageS2;
	}

	public String getImageS3() {
		return imageS3;
	}

	public void setImageS3(String imageS3) {
		this.imageS3 = imageS3;
	}

	public String getImageS4() {
		return imageS4;
	}

	public void setImageS4(String imageS4) {
		this.imageS4 = imageS4;
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
