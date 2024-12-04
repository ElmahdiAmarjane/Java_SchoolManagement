package modules;

import java.util.Date;

public class Course {
	private int id;
    private String title, description, files, type;
    private Date datePublication;

    public Course() {
    	
    }
    public Course(int id,String title, String description, String files, String type,Date datePublication) {
    	this.id = id;
        this.title = title;
        this.description = description;
        this.files = files;
        this.type = type;
        this.datePublication=datePublication;
    }
    public Course(String title, String description, String files, String type , Date datePublication) {
        this.title = title;
        this.description = description;
        this.files = files;
        this.type = type;
        this.datePublication=datePublication;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getFiles() { return files; }
    public String getType() { return type; }
    public Date getDatePublication() { return datePublication; }
    
    public void setId(int id) {this.id = id;}
    public void setTitle(String title) { this.title = title;}
    public void setDescription(String description) {this.description = description;}
    public void setFiles(String files) { this.files = files;}
    public void setType(String type) {this.type = type;}
    public void setDatePublication(Date datePub) {this.datePublication = datePub;}
}