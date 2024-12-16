package controllers;

import dao.EtudiantDao;
import modules.Etudiant;
import modules.User;

public class UpdateEtudiant {

	Etudiant etudiant=new Etudiant();
	EtudiantDao etudiantDao=new EtudiantDao();
	
	public boolean updateEtudiant(){
		
		etudiant.setCne("modi");
		etudiant.setType_bac("modi");
		etudiant.setNote_bac(11.0);
		etudiant.setType_bac2("modi");
		etudiant.setNote_bac2(40.00);
		etudiant.setFilier_titel("d");
		etudiant.setImageBac("modi");
		etudiant.setImageBac2("modi");
		etudiant.setImageS1("modi");
		etudiant.setImageS2("modi");
		etudiant.setImageS3("modi");
		etudiant.setImageS4("modi");
		etudiant.setCni_user("acd");
		
		return etudiantDao.updateEtudiant(etudiant);
	}
	
}
