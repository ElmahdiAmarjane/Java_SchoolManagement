package services;

import modules.Emploi;

public interface IEmploiServices {

	boolean insertEmploi(Emploi emploi);
	Emploi selectEmploiProf(String cniUser);
	Emploi selectEmploiEtudiant(String filier_titel);
}