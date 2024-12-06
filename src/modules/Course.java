package modules;

import java.time.LocalDate;
import java.util.Date;

public class Course {
	private int id;
    private String title, description, files, type,filier_titel,element_id;
    private LocalDate datePublication,date_limit;

    public Course() {
    	
    }
    public Course(int id,String title, String description, String files, String type,LocalDate datePublication) {
    	this.id = id;
        this.title = title;
        this.description = description;
        this.files = files;
        this.type = type;
        this.datePublication=datePublication;
    }
    public Course(String title, String description, String files, String type , LocalDate datePublication) {
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
    public LocalDate getDatePublication() { return datePublication; }
    
    public void setId(int id) {this.id = id;}
    public void setTitle(String title) { this.title = title;}
    public void setDescription(String description) {this.description = description;}
    public void setFiles(String files) { this.files = files;}
    public void setType(String type) {this.type = type;}
    public void setDatePublication(LocalDate datePub) {this.datePublication = datePub;}
    
	public String getFilier_titel() {
		return filier_titel;
	}
	public void setFilier_titel(String filier_titel) {
		this.filier_titel = filier_titel;
	}
	public String getElement_id() {
		return element_id;
	}
	public void setElement_id(String element_id) {
		this.element_id = element_id;
	}
	public LocalDate getDate_limit() {
		return date_limit;
	}
	public void setDate_limit(LocalDate date_limit) {
		this.date_limit = date_limit;
	}
    
}