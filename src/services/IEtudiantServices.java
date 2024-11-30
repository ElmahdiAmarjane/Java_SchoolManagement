package services;

import java.util.List;

import modules.Etudiant;

public interface IEtudiantServices {

	boolean insertEtudiant(Etudiant etudiante);
	boolean updateEtudiant(Etudiant etudiante);
	List<Etudiant> selectAllEtudiants(String filier_titel);
	Etudiant selectEtudiant(String cni);
}
