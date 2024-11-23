package controllers;

import dao.ProfesseurDao;
import dao.UserDao;
import modules.Professeur;
import modules.User;

public class AddProfesseur {

	//User user = new User();
	Professeur professeur = new Professeur();
	ProfesseurDao professeurDao = new ProfesseurDao();
	UserDao userDao = new UserDao();
    
    public boolean insertEtudiant() {
    	professeur=new Professeur("a", "xxx", "xxx", "xxx", "Professeur", "xxx", "xxx", "xxx", "xxx", 0, "xxx", "xxx", "xxx", "xxx", "xxx");
    	professeur.setImage("dddd");
    	
    	//return professeurDao.insertProfesseur(professeur);

        if (userDao.insertUser(professeur)) {
        	return professeurDao.insertProfesseur(professeur);
        }else {
        	return false;
        }
    	
    	
    	//return userDao.insertUser(professeur);
    }
}
