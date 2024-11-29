package services;

import java.util.List;

import modules.Annonce;


public interface IAnnonceServices {

	boolean addAnnonce(Annonce annonce);
	boolean supprimerAnnonce(Annonce annonce);
	boolean updateAnnonce(Annonce annonce);
	List<Annonce> selectAllAnnonce();
}