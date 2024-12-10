package services;

import java.util.List;

import modules.Etudiant;

public interface IEtudiantServices {

	boolean insertEtudiant(Etudiant etudiante);
	boolean updateEtudiant(Etudiant etudiante);
	List<Etudiant> selectAllEtudiantsFilier(String filier_titel);
	List<Etudiant> selectAllEtudiants();
	Etudiant selectEtudiantByCni(String cni);
	Etudiant selectEtudiantByCne(String cne);
}