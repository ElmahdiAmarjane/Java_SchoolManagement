package controllers;

import dao.EtudiantDao;
import dao.UserDao;
import modules.Etudiant;
import modules.User;

public class DeleteEtudiant {

	Etudiant etudiant=new Etudiant();
	//User user=new User();
	EtudiantDao etudiantDao=new EtudiantDao();
	//UserDao userDao = new UserDao();

	public boolean deleteEtudiant() {
		return etudiantDao.deleteEtudiant("ac");
	}
}
