package services;

import modules.Etudiante;

public interface IEtudianteServices {

	boolean insertEtudiant(Etudiante etudiante);
	boolean deleteEtudiant(String cni);
	boolean updateEtudiant(Etudiante etudiante);
}
