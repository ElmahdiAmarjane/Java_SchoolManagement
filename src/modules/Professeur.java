package modules;

public class Professeur extends User{

	private int id;
	private int rip;
	private String doctorant_type;
	private String doctorant_mention;
	private String faculter;
	private String cni_user;
	private String cv;
	
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
			String dateNaissance,
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
		this.faculter=faculter;
		this.cni_user=cni_user;
		this.cv=cv;
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


	public String getFaculter() {
		return faculter;
	}


	public void setFaculter(String faculter) {
		this.faculter = faculter;
	}


	public String getCni_user() {
		return cni_user;
	}


	public void setCni_user(String cni_user) {
		this.cni_user = cni_user;
	}


	public String getCv() {
		return cv;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}
}
