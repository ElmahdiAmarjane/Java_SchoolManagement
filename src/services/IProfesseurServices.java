package services;

import modules.Etudiant;
import modules.Professeur;

public interface IProfesseurServices {

	boolean insertProfesseur(Professeur professeur);
	boolean deleteProfesseur(String cni);
	boolean updateProfesseur(Professeur professeur);
}
