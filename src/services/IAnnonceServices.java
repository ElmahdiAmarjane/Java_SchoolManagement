package services;

import java.util.List;

import modules.Annonce;


public interface IAnnonceServices {

	boolean addAnnonce(Annonce annonce);
	boolean deleteAnnonce(int idAnnonce);
	boolean updateAnnonce(Annonce annonce);
	List<Annonce> selectAllAnnonce();
}