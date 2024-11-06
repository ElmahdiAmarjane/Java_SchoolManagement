package controllers;

import dao.EtudiantDao;
import dao.ProfesseurDao;

public class DeleteProfesseur {

	ProfesseurDao professeurDao=new ProfesseurDao();
	
	public boolean deleteProfesseur(){
		return professeurDao.deleteProfesseur("a");
	}
}
