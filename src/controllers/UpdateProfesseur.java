package controllers;

import dao.EtudiantDao;
import dao.ProfesseurDao;
import modules.Etudiant;
import modules.Professeur;

public class UpdateProfesseur {

	Professeur professeur=new Professeur();
	ProfesseurDao professeurDao=new ProfesseurDao();
	
	 public boolean updateProfesseur() {
		 
		 professeur.setRip(12345);
		 professeur.setDoctorant_type("doctorant");
		 professeur.setDoctorant_mention("Bien");
		 professeur.setFaculter("FS FES");
		 professeur.setCni_user("xx");
		 professeur.setCv("eee");
		 
		 return professeurDao.updateProfesseur(professeur);
		 
	 }
}
