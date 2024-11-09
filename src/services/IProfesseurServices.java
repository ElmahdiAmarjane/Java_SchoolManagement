package services;

import java.util.List;

import modules.Absence;
import modules.Etudiant;
import modules.Professeur;

public interface IProfesseurServices {

	boolean insertProfesseur(Professeur professeur);
	boolean deleteProfesseur(String cni);
	boolean updateProfesseur(Professeur professeur);
	
	boolean absence(Absence absence);
	
}
