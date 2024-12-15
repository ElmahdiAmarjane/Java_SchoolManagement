package services;

import modules.Emploi;

public interface IEmploiServices {

	boolean insertEmploi(Emploi emploi);
	Emploi selectEmploiProf(String cni_user);
	Emploi selectEmploiEtudiant(String filier_titel);
}
