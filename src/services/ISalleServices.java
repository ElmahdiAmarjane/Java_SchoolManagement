package services;

import java.util.List;

import modules.Salle;

public interface ISalleServices {

	boolean insertSalle(Salle salle);
	List<Salle> selectSalle();
}