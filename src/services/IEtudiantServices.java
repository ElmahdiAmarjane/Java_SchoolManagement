package services;

import modules.Etudiant;

public interface IEtudiantServices {

	boolean insertEtudiant(Etudiant etudiante);
	boolean deleteEtudiant(String cni);
	boolean updateEtudiant(Etudiant etudiante);
}
