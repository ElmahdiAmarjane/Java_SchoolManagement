package services;

import javafx.event.ActionEvent;
import modules.Etudiant;
import modules.User;

public interface IUserServices {
	
	User login(User user);
	boolean deleteUser(String cni);
	boolean updateUser(User user);
	
	
	
}