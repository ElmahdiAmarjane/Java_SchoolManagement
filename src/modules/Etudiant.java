package modules;

import java.time.LocalDate;

public class Etudiant extends User{

	protected String cne;
	protected String type_bac;
	protected int anneBac;
	protected Double note_bac;
	protected String bac_acadimic;
	protected String university;
	protected String etablisment_bac2;
	protected String type_bac2;
	protected Double note_bac2;
	protected String filier_titel;
	protected int anneeS1;
	protected int anneeS2;
	protected int anneeS3;
	protected int anneeS4;
	protected Double note_S1;
	protected Double note_S2;
	protected Double note_S3;
	protected Double note_S4;
	protected String cni_user;
	protected String imageBac;
	protected String iamge_note_bac;
	protected String imageBac2;
	protected String imageS1;
	protected String imageS2;
	protected String imageS3;
	protected String imageS4;
	protected String attendanceStatus;
	
	public Etudiant() {}
	
	public Etudiant(
			String cni,
			String nom,
			String prenom,
			String image,
			String role,
			String password,
			String tel,
			String email,
			LocalDate dateNaissance,
			String cne,
			String type_bac,
			Double note_bac,
			String type_bac2,
			Double note_bac2,
			String filier_titel,
			String cni_user,
			String imageBac,
			String imageBac2,
			String imageS1,
			String imageS2,
			String imageS3,
			String imageS4
			) {
		
		super(cni,nom,prenom,image,role,password,tel,email, dateNaissance);
		this.cne=cne;
		this.type_bac=type_bac;
		this.note_bac=note_bac;
		this.type_bac2=type_bac2;
		this.note_bac2=note_bac2;
		this.filier_titel=filier_titel;
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
		return this.note_bac2;
	}

	public void setNote_bac2(Double note_bac2) {
		this.note_bac2 = note_bac2;
	}

	public String getCni_user() {
		return cni_user;
	}

	public void setCni_user(String cni_user) {
		this.cni_user = cni_user;
	}
	
	public String toString() {
		return cne+" "+nom+" "+prenom;
	}

	public String getFilier_titel() {
		return filier_titel;
	}

	public void setFilier_titel(String filier_titel) {
		this.filier_titel = filier_titel;
	}

	public int getAnneBac() {
		return anneBac;
	}

	public void setAnneBac(int anneBac) {
		this.anneBac = anneBac;
	}

	public String getBac_acadimic() {
		return bac_acadimic;
	}

	public void setBac_acadimic(String bac_acadimic) {
		this.bac_acadimic = bac_acadimic;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getEtablisment_bac2() {
		return etablisment_bac2;
	}

	public void setEtablisment_bac2(String etablisment_bac2) {
		this.etablisment_bac2 = etablisment_bac2;
	}

	public int getAnneeS1() {
		return anneeS1;
	}

	public void setAnneeS1(int anneeS1) {
		this.anneeS1 = anneeS1;
	}

	public int getAnneeS2() {
		return anneeS2;
	}

	public void setAnneeS2(int anneeS2) {
		this.anneeS2 = anneeS2;
	}

	public int getAnneeS3() {
		return anneeS3;
	}

	public void setAnneeS3(int anneeS3) {
		this.anneeS3 = anneeS3;
	}

	public int getAnneeS4() {
		return anneeS4;
	}

	public void setAnneeS4(int anneeS4) {
		this.anneeS4 = anneeS4;
	}

	public double getNote_S1() {
		return note_S1;
	}

	public void setNote_S1(double note_S1) {
		this.note_S1 = note_S1;
	}

	public Double getNote_S2() {
		return note_S2;
	}

	public void setNote_S2(double note_S2) {
		this.note_S2 = note_S2;
	}

	public Double getNote_S3() {
		return note_S3;
	}

	public void setNote_S3(double note_S3) {
		this.note_S3 = note_S3;
	}

	public Double getNote_S4() {
		return note_S4;
	}

	public void setNote_S4(double note_S4) {
		this.note_S4 = note_S4;
	}

	public String getIamge_note_bac() {
		return iamge_note_bac;
	}

	public void setIamge_note_bac(String iamge_not_bac) {
		this.iamge_note_bac = iamge_not_bac;
	}
	
	public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }
	
	
}