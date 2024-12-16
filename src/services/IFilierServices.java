package services;

import java.util.List;

import modules.Filier;

public interface IFilierServices {

	boolean addFilier(Filier filier);
	boolean supprimerFilier(Filier filier);
	boolean updateFilier(Filier filier);
	List<Filier> selectAllFilier();
	
}
