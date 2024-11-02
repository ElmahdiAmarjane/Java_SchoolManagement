package services;

import modules.Etudiant;

public interface IEtudianteServices {

	boolean insertEtudiant(Etudiant etudiante);
	boolean deleteEtudiant(String cni);
	boolean updateEtudiant(Etudiant etudiante);
}
