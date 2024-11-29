package modules;

import java.util.Date;

public class Annonce {
	
	
	private int id;
	private int userId;
	private String title;
	private String contenu;
	private String file;
	private Date dateAnnonce;
	
	// Constructeur par défaut
    public Annonce() {
    }

    // Constructeur avec tous les attributs
    public Annonce(int id, int userId, String title, String contenu, String file, Date dateAnnonce) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.contenu = contenu;
        this.file = file;
        this.dateAnnonce = dateAnnonce;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getContenu() {
        return contenu;
    }

    public String getFile() {
        return file;
    }

    public Date getDateAnnonce() {
        return dateAnnonce;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setDateAnnonce(Date dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }

	

}
