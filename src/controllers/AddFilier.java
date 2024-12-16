package controllers;

import dao.FilierDao;
import modules.Filier;

public class AddFilier {

	FilierDao filierDao=new FilierDao();
	Filier filier=new Filier();
	
	public boolean ajouterFilier() {
		
		filier.setTitel("DSIC");
		filier.setProgrammeId(0);
		
		return filierDao.addFilier(filier);
	}
}
