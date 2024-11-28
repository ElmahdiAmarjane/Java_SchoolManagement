package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.ElementDao;
import dao.EmploiDao;
import dao.FilierDao;
import dao.ProfesseurDao;
import dao.SalleDao;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import modules.Element;
import modules.Emploi;
import modules.Filier;
import modules.Professeur;
import modules.Salle;

public class EmploiController {

	
	ElementDao elementDao=new ElementDao();
	ProfesseurDao professeurDao=new ProfesseurDao();
	SalleDao salleDao=new SalleDao();
	EmploiDao emploiDao=new EmploiDao();
	Emploi emploi=new Emploi();
	FilierDao filierDao=new FilierDao();
	
	List<Element> elements;
	List<Professeur> professeurs;
	List<Salle> salles;
	List<Filier> filiers;
    LocalDate localDate = LocalDate.now(); // Replace with your actual date

	
	 @FXML
	 private Pane emploiTempsProfBtn;
	 @FXML
	 private AnchorPane emploiTempsProfGrid;
	 
	 @FXML
	 private Pane emploiTempsFilliereBtn;
	 @FXML
	 private AnchorPane emploiTempsFilliereGrid;
	 @FXML
	 private ImageView goBackToMainEmploiTempsBtn;
	 @FXML
	 private AnchorPane emploisChoose;
	 
	 @FXML
	 private ComboBox<String> filier_titel;
	 //LUNDI
	 @FXML 
	 private ComboBox<String> Lundi_matiere_8_10_L1,Lundi_salle_8_10_L1,Lundi_prof_8_10_L1,Lundi_matiere_8_10_L2,Lundi_salle_8_10_L2,Lundi_prof_8_10_L2;
	 @FXML 
	 private ComboBox<String> Lundi_matiere_10_12_L1,Lundi_salle_10_12_L1,Lundi_prof_10_12_L1,Lundi_matiere_10_12_L2,Lundi_salle_10_12_L2,Lundi_prof_10_12_L2;
	 @FXML 
	 private ComboBox<String> Lundi_matiere_2_4_L1,Lundi_salle_2_4_L1,Lundi_prof_2_4_L1,Lundi_matiere_2_4_L2,Lundi_salle_2_4_L2,Lundi_prof_2_4_L2;
	 @FXML 
	 private ComboBox<String> Lundi_matiere_4_6_L1,Lundi_salle_4_6_L1,Lundi_prof_4_6_L1,Lundi_matiere_4_6_L2,Lundi_salle_4_6_L2,Lundi_prof_4_6_L2;
	
	 //MARDI
	 @FXML 
	 private ComboBox<String> Mardi_matiere_8_10_L1,Mardi_salle_8_10_L1,Mardi_prof_8_10_L1,Mardi_matiere_8_10_L2,Mardi_salle_8_10_L2,Mardi_prof_8_10_L2;
	 @FXML 
	 private ComboBox<String> Mardi_matiere_10_12_L1,Mardi_salle_10_12_L1,Mardi_prof_10_12_L1,Mardi_matiere_10_12_L2,Mardi_salle_10_12_L2,Mardi_prof_10_12_L2;
	 @FXML 
	 private ComboBox<String> Mardi_matiere_2_4_L1,Mardi_salle_2_4_L1,Mardi_prof_2_4_L1,Mardi_matiere_2_4_L2,Mardi_salle_2_4_L2,Mardi_prof_2_4_L2;
	 @FXML 
	 private ComboBox<String> Mardi_matiere_4_6_L1,Mardi_salle_4_6_L1,Mardi_prof_4_6_L1,Mardi_matiere_4_6_L2,Mardi_salle_4_6_L2,Mardi_prof_4_6_L2;
	 
	 //MERCREDI
	 @FXML 
	 private ComboBox<String> Mercredi_matiere_8_10_L1,Mercredi_salle_8_10_L1,Mercredi_prof_8_10_L1,Mercredi_matiere_8_10_L2,Mercredi_salle_8_10_L2,Mercredi_prof_8_10_L2;
	 @FXML 
	 private ComboBox<String> Mercredi_matiere_10_12_L1,Mercredi_salle_10_12_L1,Mercredi_prof_10_12_L1,Mercredi_matiere_10_12_L2,Mercredi_salle_10_12_L2,Mercredi_prof_10_12_L2;
	 @FXML 
	 private ComboBox<String> Mercredi_matiere_2_4_L1,Mercredi_salle_2_4_L1,Mercredi_prof_2_4_L1,Mercredi_matiere_2_4_L2,Mercredi_salle_2_4_L2,Mercredi_prof_2_4_L2;
	 @FXML 
	 private ComboBox<String> Mercredi_matiere_4_6_L1,Mercredi_salle_4_6_L1,Mercredi_prof_4_6_L1,Mercredi_matiere_4_6_L2,Mercredi_salle_4_6_L2,Mercredi_prof_4_6_L2;
	 
	 //JEUDI
	 @FXML 
	 private ComboBox<String> Jeudi_matiere_8_10_L1, Jeudi_salle_8_10_L1, Jeudi_prof_8_10_L1, Jeudi_matiere_8_10_L2, Jeudi_salle_8_10_L2, Jeudi_prof_8_10_L2;
	 @FXML 
	 private ComboBox<String>  Jeudi_matiere_10_12_L1, Jeudi_salle_10_12_L1, Jeudi_prof_10_12_L1, Jeudi_matiere_10_12_L2, Jeudi_salle_10_12_L2, Jeudi_prof_10_12_L2;
	 @FXML 
	 private ComboBox<String>  Jeudi_matiere_2_4_L1, Jeudi_salle_2_4_L1, Jeudi_prof_2_4_L1, Jeudi_matiere_2_4_L2, Jeudi_salle_2_4_L2, Jeudi_prof_2_4_L2;
	 @FXML 
	 private ComboBox<String>  Jeudi_matiere_4_6_L1, Jeudi_salle_4_6_L1, Jeudi_prof_4_6_L1, Jeudi_matiere_4_6_L2, Jeudi_salle_4_6_L2, Jeudi_prof_4_6_L2;
	 
	 //VENDREDI
	 @FXML 
	 private ComboBox<String> Vendredi_matiere_8_10_L1,Vendredi_salle_8_10_L1,Vendredi_prof_8_10_L1,Vendredi_matiere_8_10_L2,Vendredi_salle_8_10_L2,Vendredi_prof_8_10_L2;
	 @FXML 
	 private ComboBox<String> Vendredi_matiere_10_12_L1,Vendredi_salle_10_12_L1,Vendredi_prof_10_12_L1,Vendredi_matiere_10_12_L2,Vendredi_salle_10_12_L2,Vendredi_prof_10_12_L2;
	 @FXML 
	 private ComboBox<String> Vendredi_matiere_2_4_L1,Vendredi_salle_2_4_L1,Vendredi_prof_2_4_L1,Vendredi_matiere_2_4_L2,Vendredi_salle_2_4_L2,Vendredi_prof_2_4_L2;
	 @FXML 
	 private ComboBox<String> Vendredi_matiere_4_6_L1,Vendredi_salle_4_6_L1,Vendredi_prof_4_6_L1,Vendredi_matiere_4_6_L2,Vendredi_salle_4_6_L2,Vendredi_prof_4_6_L2;
	 
	 
	 
	 public void initialize() {
		 initializeComboBox();
	 }
	 
	 @FXML
	public void saveEmploiFilier() {
		
		// Lundi (Monday)
		 List<String> H_8_10_element_lundi = Arrays.asList(Lundi_matiere_8_10_L1.getValue(), Lundi_matiere_8_10_L2.getValue());
		 List<String> H_10_12_element_lundi = Arrays.asList(Lundi_matiere_10_12_L1.getValue(), Lundi_matiere_10_12_L2.getValue());
		 List<String> H_2_4_element_lundi = Arrays.asList(Lundi_matiere_2_4_L1.getValue(), Lundi_matiere_2_4_L2.getValue());
		 List<String> H_4_6_element_lundi = Arrays.asList(Lundi_matiere_4_6_L1.getValue(), Lundi_matiere_4_6_L2.getValue());

		 List<String> H_8_10_prof_lundi = Arrays.asList(Lundi_prof_8_10_L1.getValue(), Lundi_prof_8_10_L2.getValue());
		 List<String> H_10_12_prof_lundi = Arrays.asList(Lundi_prof_10_12_L1.getValue(), Lundi_prof_10_12_L2.getValue());
		 List<String> H_2_4_prof_lundi = Arrays.asList(Lundi_prof_2_4_L1.getValue(), Lundi_prof_2_4_L2.getValue());
		 List<String> H_4_6_prof_lundi = Arrays.asList(Lundi_prof_4_6_L1.getValue(), Lundi_prof_4_6_L2.getValue());

		 List<String> H_8_10_salle_lundi = Arrays.asList(Lundi_salle_8_10_L1.getValue(), Lundi_salle_8_10_L2.getValue());
		 List<String> H_10_12_salle_lundi = Arrays.asList(Lundi_salle_10_12_L1.getValue(), Lundi_salle_10_12_L2.getValue());
		 List<String> H_2_4_salle_lundi = Arrays.asList(Lundi_salle_2_4_L1.getValue(), Lundi_salle_2_4_L2.getValue());
		 List<String> H_4_6_salle_lundi = Arrays.asList(Lundi_salle_4_6_L1.getValue(), Lundi_salle_4_6_L2.getValue());

		 // Mardi (Tuesday)
		 List<String> H_8_10_element_mardi = Arrays.asList(Mardi_matiere_8_10_L1.getValue(), Mardi_matiere_8_10_L2.getValue());
		 List<String> H_10_12_element_mardi = Arrays.asList(Mardi_matiere_10_12_L1.getValue(), Mardi_matiere_10_12_L2.getValue());
		 List<String> H_2_4_element_mardi = Arrays.asList(Mardi_matiere_2_4_L1.getValue(), Mardi_matiere_2_4_L2.getValue());
		 List<String> H_4_6_element_mardi = Arrays.asList(Mardi_matiere_4_6_L1.getValue(), Mardi_matiere_4_6_L2.getValue());

		 List<String> H_8_10_prof_mardi = Arrays.asList(Mardi_prof_8_10_L1.getValue(), Mardi_prof_8_10_L2.getValue());
		 List<String> H_10_12_prof_mardi = Arrays.asList(Mardi_prof_10_12_L1.getValue(), Mardi_prof_10_12_L2.getValue());
		 List<String> H_2_4_prof_mardi = Arrays.asList(Mardi_prof_2_4_L1.getValue(), Mardi_prof_2_4_L2.getValue());
		 List<String> H_4_6_prof_mardi = Arrays.asList(Mardi_prof_4_6_L1.getValue(), Mardi_prof_4_6_L2.getValue());

		 List<String> H_8_10_salle_mardi = Arrays.asList(Mardi_salle_8_10_L1.getValue(), Mardi_salle_8_10_L2.getValue());
		 List<String> H_10_12_salle_mardi = Arrays.asList(Mardi_salle_10_12_L1.getValue(), Mardi_salle_10_12_L2.getValue());
		 List<String> H_2_4_salle_mardi = Arrays.asList(Mardi_salle_2_4_L1.getValue(), Mardi_salle_2_4_L2.getValue());
		 List<String> H_4_6_salle_mardi = Arrays.asList(Mardi_salle_4_6_L1.getValue(), Mardi_salle_4_6_L2.getValue());

		 // Mercredi (Wednesday)
		 List<String> H_8_10_element_mercredi = Arrays.asList(Mercredi_matiere_8_10_L1.getValue(), Mercredi_matiere_8_10_L2.getValue());
		 List<String> H_10_12_element_mercredi = Arrays.asList(Mercredi_matiere_10_12_L1.getValue(), Mercredi_matiere_10_12_L2.getValue());
		 List<String> H_2_4_element_mercredi = Arrays.asList(Mercredi_matiere_2_4_L1.getValue(), Mercredi_matiere_2_4_L2.getValue());
		 List<String> H_4_6_element_mercredi = Arrays.asList(Mercredi_matiere_4_6_L1.getValue(), Mercredi_matiere_4_6_L2.getValue());

		 List<String> H_8_10_prof_mercredi = Arrays.asList(Mercredi_prof_8_10_L1.getValue(), Mercredi_prof_8_10_L2.getValue());
		 List<String> H_10_12_prof_mercredi = Arrays.asList(Mercredi_prof_10_12_L1.getValue(), Mercredi_prof_10_12_L2.getValue());
		 List<String> H_2_4_prof_mercredi = Arrays.asList(Mercredi_prof_2_4_L1.getValue(), Mercredi_prof_2_4_L2.getValue());
		 List<String> H_4_6_prof_mercredi = Arrays.asList(Mercredi_prof_4_6_L1.getValue(), Mercredi_prof_4_6_L2.getValue());

		 List<String> H_8_10_salle_mercredi = Arrays.asList(Mercredi_salle_8_10_L1.getValue(), Mercredi_salle_8_10_L2.getValue());
		 List<String> H_10_12_salle_mercredi = Arrays.asList(Mercredi_salle_10_12_L1.getValue(), Mercredi_salle_10_12_L2.getValue());
		 List<String> H_2_4_salle_mercredi = Arrays.asList(Mercredi_salle_2_4_L1.getValue(), Mercredi_salle_2_4_L2.getValue());
		 List<String> H_4_6_salle_mercredi = Arrays.asList(Mercredi_salle_4_6_L1.getValue(), Mercredi_salle_4_6_L2.getValue());

		 // Jeudi (Thursday)
		 List<String> H_8_10_element_jeudi = Arrays.asList(Jeudi_matiere_8_10_L1.getValue(), Jeudi_matiere_8_10_L2.getValue());
		 List<String> H_10_12_element_jeudi = Arrays.asList(Jeudi_matiere_10_12_L1.getValue(), Jeudi_matiere_10_12_L2.getValue());
		 List<String> H_2_4_element_jeudi = Arrays.asList(Jeudi_matiere_2_4_L1.getValue(), Jeudi_matiere_2_4_L2.getValue());
		 List<String> H_4_6_element_jeudi = Arrays.asList(Jeudi_matiere_4_6_L1.getValue(), Jeudi_matiere_4_6_L2.getValue());

		 List<String> H_8_10_prof_jeudi = Arrays.asList(Jeudi_prof_8_10_L1.getValue(), Jeudi_prof_8_10_L2.getValue());
		 List<String> H_10_12_prof_jeudi = Arrays.asList(Jeudi_prof_10_12_L1.getValue(), Jeudi_prof_10_12_L2.getValue());
		 List<String> H_2_4_prof_jeudi = Arrays.asList(Jeudi_prof_2_4_L1.getValue(), Jeudi_prof_2_4_L2.getValue());
		 List<String> H_4_6_prof_jeudi = Arrays.asList(Jeudi_prof_4_6_L1.getValue(), Jeudi_prof_4_6_L2.getValue());

		 List<String> H_8_10_salle_jeudi = Arrays.asList(Jeudi_salle_8_10_L1.getValue(), Jeudi_salle_8_10_L2.getValue());
		 List<String> H_10_12_salle_jeudi = Arrays.asList(Jeudi_salle_10_12_L1.getValue(), Jeudi_salle_10_12_L2.getValue());
		 List<String> H_2_4_salle_jeudi = Arrays.asList(Jeudi_salle_2_4_L1.getValue(), Jeudi_salle_2_4_L2.getValue());
		 List<String> H_4_6_salle_jeudi = Arrays.asList(Jeudi_salle_4_6_L1.getValue(), Jeudi_salle_4_6_L2.getValue());

		 // Vendredi (Friday)
		 List<String> H_8_10_element_vendredi = Arrays.asList(Vendredi_matiere_8_10_L1.getValue(), Vendredi_matiere_8_10_L2.getValue());
		 List<String> H_10_12_element_vendredi = Arrays.asList(Vendredi_matiere_10_12_L1.getValue(), Vendredi_matiere_10_12_L2.getValue());
		 List<String> H_2_4_element_vendredi = Arrays.asList(Vendredi_matiere_2_4_L1.getValue(), Vendredi_matiere_2_4_L2.getValue());
		 List<String> H_4_6_element_vendredi = Arrays.asList(Vendredi_matiere_4_6_L1.getValue(), Vendredi_matiere_4_6_L2.getValue());

		 List<String> H_8_10_prof_vendredi = Arrays.asList(Vendredi_prof_8_10_L1.getValue(), Vendredi_prof_8_10_L2.getValue());
		 List<String> H_10_12_prof_vendredi = Arrays.asList(Vendredi_prof_10_12_L1.getValue(), Vendredi_prof_10_12_L2.getValue());
		 List<String> H_2_4_prof_vendredi = Arrays.asList(Vendredi_prof_2_4_L1.getValue(), Vendredi_prof_2_4_L2.getValue());
		 List<String> H_4_6_prof_vendredi = Arrays.asList(Vendredi_prof_4_6_L1.getValue(), Vendredi_prof_4_6_L2.getValue());

		 List<String> H_8_10_salle_vendredi = Arrays.asList(Vendredi_salle_8_10_L1.getValue(), Vendredi_salle_8_10_L2.getValue());
		 List<String> H_10_12_salle_vendredi = Arrays.asList(Vendredi_salle_10_12_L1.getValue(), Vendredi_salle_10_12_L2.getValue());
		 List<String> H_2_4_salle_vendredi = Arrays.asList(Vendredi_salle_2_4_L1.getValue(), Vendredi_salle_2_4_L2.getValue());
		 List<String> H_4_6_salle_vendredi = Arrays.asList(Vendredi_salle_4_6_L1.getValue(), Vendredi_salle_4_6_L2.getValue());

		 
		 //LUNDI
		 emploi.setH_8_10_element_lundi(H_8_10_element_lundi);
		 emploi.setH_10_12_element_lundi(H_10_12_element_lundi);
		 emploi.setH_2_4_element_lundi(H_2_4_element_lundi);
		 emploi.setH_4_6_element_lundi(H_4_6_element_lundi);

		 emploi.setH_8_10_prof_lundi(H_8_10_prof_lundi);
		 emploi.setH_10_12_prof_lundi(H_10_12_prof_lundi);
		 emploi.setH_2_4_prof_lundi(H_2_4_prof_lundi);
		 emploi.setH_4_6_prof_lundi(H_4_6_prof_lundi);

		 emploi.setH_8_10_salle_lundi(H_8_10_salle_lundi);
		 emploi.setH_10_12_salle_lundi(H_10_12_salle_lundi);
		 emploi.setH_2_4_salle_lundi(H_2_4_salle_lundi);
		 emploi.setH_4_6_salle_lundi(H_4_6_salle_lundi);
		 
		 //MARDI
		 emploi.setH_8_10_element_mardi(H_8_10_element_mardi);
		 emploi.setH_10_12_element_mardi(H_10_12_element_mardi);
		 emploi.setH_2_4_element_mardi(H_2_4_element_mardi);
		 emploi.setH_4_6_element_mardi(H_4_6_element_mardi);

		 emploi.setH_8_10_prof_mardi(H_8_10_prof_mardi);
		 emploi.setH_10_12_prof_mardi(H_10_12_prof_mardi);
		 emploi.setH_2_4_prof_mardi(H_2_4_prof_mardi);
		 emploi.setH_4_6_prof_mardi(H_4_6_prof_mardi);

		 emploi.setH_8_10_salle_mardi(H_8_10_salle_mardi);
		 emploi.setH_10_12_salle_mardi(H_10_12_salle_mardi);
		 emploi.setH_2_4_salle_mardi(H_2_4_salle_mardi);
		 emploi.setH_4_6_salle_mardi(H_4_6_salle_mardi);

		 //MERCREDI
		 emploi.setH_8_10_element_mercredi(H_8_10_element_mercredi);
		 emploi.setH_10_12_element_mercredi(H_10_12_element_mercredi);
		 emploi.setH_2_4_element_mercredi(H_2_4_element_mercredi);
		 emploi.setH_4_6_element_mercredi(H_4_6_element_mercredi);

		 emploi.setH_8_10_prof_mercredi(H_8_10_prof_mercredi);
		 emploi.setH_10_12_prof_mercredi(H_10_12_prof_mercredi);
		 emploi.setH_2_4_prof_mercredi(H_2_4_prof_mercredi);
		 emploi.setH_4_6_prof_mercredi(H_4_6_prof_mercredi);

		 emploi.setH_8_10_salle_mercredi(H_8_10_salle_mercredi);
		 emploi.setH_10_12_salle_mercredi(H_10_12_salle_mercredi);
		 emploi.setH_2_4_salle_mercredi(H_2_4_salle_mercredi);
		 emploi.setH_4_6_salle_mercredi(H_4_6_salle_mercredi);

		 //JEUDI
		 emploi.setH_8_10_element_jeudi(H_8_10_element_jeudi);
		 emploi.setH_10_12_element_jeudi(H_10_12_element_jeudi);
		 emploi.setH_2_4_element_jeudi(H_2_4_element_jeudi);
		 emploi.setH_4_6_element_jeudi(H_4_6_element_jeudi);

		 emploi.setH_8_10_prof_jeudi(H_8_10_prof_jeudi);
		 emploi.setH_10_12_prof_jeudi(H_10_12_prof_jeudi);
		 emploi.setH_2_4_prof_jeudi(H_2_4_prof_jeudi);
		 emploi.setH_4_6_prof_jeudi(H_4_6_prof_jeudi);

		 emploi.setH_8_10_salle_jeudi(H_8_10_salle_jeudi);
		 emploi.setH_10_12_salle_jeudi(H_10_12_salle_jeudi);
		 emploi.setH_2_4_salle_jeudi(H_2_4_salle_jeudi);
		 emploi.setH_4_6_salle_jeudi(H_4_6_salle_jeudi);

		 
		 //VENDREDI
		 emploi.setH_8_10_element_vendredi(H_8_10_element_vendredi);
		 emploi.setH_10_12_element_vendredi(H_10_12_element_vendredi);
		 emploi.setH_2_4_element_vendredi(H_2_4_element_vendredi);
		 emploi.setH_4_6_element_vendredi(H_4_6_element_vendredi);

		 emploi.setH_8_10_prof_vendredi(H_8_10_prof_vendredi);
		 emploi.setH_10_12_prof_vendredi(H_10_12_prof_vendredi);
		 emploi.setH_2_4_prof_vendredi(H_2_4_prof_vendredi);
		 emploi.setH_4_6_prof_vendredi(H_4_6_prof_vendredi);

		 emploi.setH_8_10_salle_vendredi(H_8_10_salle_vendredi);
		 emploi.setH_10_12_salle_vendredi(H_10_12_salle_vendredi);
		 emploi.setH_2_4_salle_vendredi(H_2_4_salle_vendredi);
		 emploi.setH_4_6_salle_vendredi(H_4_6_salle_vendredi);
         
		 emploi.setDate(localDate);
		 emploi.setCni_user("Test");
		 emploi.setFilier_titel(filier_titel.getValue());
		 
		 emploiDao.insertEmploi(emploi);
			
	}
	
	public void emploiTempsProfGridToFront(){
		emploiTempsProfGrid.toFront();
		
		goBackToMainEmploiTempsBtn.setVisible(true);
	}

	
	public void emploiTempsFilliereGridToFront() {
		emploiTempsFilliereGrid.toFront();
		
		goBackToMainEmploiTempsBtn.setVisible(true);
	}
	
	
	public void goBackToMainEmploiTemps() {
		emploisChoose.toFront();
		
		goBackToMainEmploiTempsBtn.setVisible(false);
	}
	
	public void initializeComboBox() {
		try {
			filiers=filierDao.selectAllFilier();
			for(Filier filier:filiers) {
				filier_titel.getItems().add(filier.getTitel());
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
		 try {
			 elements=elementDao.selectAllElemnt();			 
			 //MATIER
			 for(Element elem:elements) {
				 //LUNDI
				 Lundi_matiere_8_10_L1.getItems().addAll(elem.getNom());
				 Lundi_matiere_8_10_L2.getItems().addAll(elem.getNom());
				 Lundi_matiere_10_12_L1.getItems().addAll(elem.getNom());
				 Lundi_matiere_10_12_L2.getItems().addAll(elem.getNom());
				 Lundi_matiere_2_4_L1.getItems().addAll(elem.getNom());
				 Lundi_matiere_2_4_L2.getItems().addAll(elem.getNom());
				 Lundi_matiere_4_6_L1.getItems().addAll(elem.getNom());
				 Lundi_matiere_4_6_L2.getItems().addAll(elem.getNom());
				 
				//MARDI
				 Mardi_matiere_8_10_L1.getItems().addAll(elem.getNom());
				 Mardi_matiere_8_10_L2.getItems().addAll(elem.getNom());
				 Mardi_matiere_10_12_L1.getItems().addAll(elem.getNom());
				 Mardi_matiere_10_12_L2.getItems().addAll(elem.getNom());
				 Mardi_matiere_2_4_L1.getItems().addAll(elem.getNom());
				 Mardi_matiere_2_4_L2.getItems().addAll(elem.getNom());
				 Mardi_matiere_4_6_L1.getItems().addAll(elem.getNom());
				 Mardi_matiere_4_6_L2.getItems().addAll(elem.getNom());
				 
				//MERCEDI
				 Mercredi_matiere_8_10_L1.getItems().addAll(elem.getNom());
				 Mercredi_matiere_8_10_L2.getItems().addAll(elem.getNom());
				 Mercredi_matiere_10_12_L1.getItems().addAll(elem.getNom());
				 Mercredi_matiere_10_12_L2.getItems().addAll(elem.getNom());
				 Mercredi_matiere_2_4_L1.getItems().addAll(elem.getNom());
				 Mercredi_matiere_2_4_L2.getItems().addAll(elem.getNom());
				 Mercredi_matiere_4_6_L1.getItems().addAll(elem.getNom());
				 Mercredi_matiere_4_6_L2.getItems().addAll(elem.getNom());
				 
				//JUEDI
				 Jeudi_matiere_8_10_L1.getItems().addAll(elem.getNom());
				 Jeudi_matiere_8_10_L2.getItems().addAll(elem.getNom());
				 Jeudi_matiere_10_12_L1.getItems().addAll(elem.getNom());
				 Jeudi_matiere_10_12_L2.getItems().addAll(elem.getNom());
				 Jeudi_matiere_2_4_L1.getItems().addAll(elem.getNom());
				 Jeudi_matiere_2_4_L2.getItems().addAll(elem.getNom());
				 Jeudi_matiere_4_6_L1.getItems().addAll(elem.getNom());
				 Jeudi_matiere_4_6_L2.getItems().addAll(elem.getNom());
				 
				//Vendredi
				 Vendredi_matiere_8_10_L1.getItems().addAll(elem.getNom());
				 Vendredi_matiere_8_10_L2.getItems().addAll(elem.getNom());
				 Vendredi_matiere_10_12_L1.getItems().addAll(elem.getNom());
				 Vendredi_matiere_10_12_L2.getItems().addAll(elem.getNom());
				 Vendredi_matiere_2_4_L1.getItems().addAll(elem.getNom());
				 Vendredi_matiere_2_4_L2.getItems().addAll(elem.getNom());
				 Vendredi_matiere_4_6_L1.getItems().addAll(elem.getNom());
				 Vendredi_matiere_4_6_L2.getItems().addAll(elem.getNom());
				 
			 }
		 }catch(Exception e2) {
			 System.out.println(e2);
		 }
		 
		 try {
			 professeurs=professeurDao.selectAllProfesseur();			 
			//PROF
			 for(Professeur prof:professeurs ) {
				 //LUNDI
				 Lundi_prof_8_10_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Lundi_prof_8_10_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Lundi_prof_10_12_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Lundi_prof_10_12_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Lundi_prof_2_4_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Lundi_prof_2_4_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Lundi_prof_4_6_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Lundi_prof_4_6_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 
				//MARDI
				 Mardi_prof_8_10_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mardi_prof_8_10_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mardi_prof_10_12_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mardi_prof_10_12_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mardi_prof_2_4_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mardi_prof_2_4_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mardi_prof_4_6_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mardi_prof_4_6_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 
				//MERCREDI
				 Mercredi_prof_8_10_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mercredi_prof_8_10_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mercredi_prof_10_12_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mercredi_prof_10_12_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mercredi_prof_2_4_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mercredi_prof_2_4_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mercredi_prof_4_6_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Mercredi_prof_4_6_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 
				//LUNDI
				 Jeudi_prof_8_10_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Jeudi_prof_8_10_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Jeudi_prof_10_12_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Jeudi_prof_10_12_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Jeudi_prof_2_4_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Jeudi_prof_2_4_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Jeudi_prof_4_6_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Jeudi_prof_4_6_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 
				//LUNDI
				 Vendredi_prof_8_10_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Vendredi_prof_8_10_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Vendredi_prof_10_12_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Vendredi_prof_10_12_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Vendredi_prof_2_4_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Vendredi_prof_2_4_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Vendredi_prof_4_6_L1.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
				 Vendredi_prof_4_6_L2.getItems().addAll(prof.getNom()+" "+prof.getPrenom());
			 }
		 }catch(Exception e) {
			 System.out.print(e);
		 }
		 
		 try {
			 salles=salleDao.selectSalle();

			//SALLE
			 for(Salle salle:salles ) {
				 //LUNDI
				 Lundi_salle_8_10_L1.getItems().addAll(salle.getTitel());
				 Lundi_salle_8_10_L2.getItems().addAll(salle.getTitel());
				 Lundi_salle_10_12_L1.getItems().addAll(salle.getTitel());
				 Lundi_salle_10_12_L2.getItems().addAll(salle.getTitel());
				 Lundi_salle_2_4_L1.getItems().addAll(salle.getTitel());
				 Lundi_salle_2_4_L2.getItems().addAll(salle.getTitel());
				 Lundi_salle_4_6_L1.getItems().addAll(salle.getTitel());
				 Lundi_salle_4_6_L2.getItems().addAll(salle.getTitel());
				 
				//MARDI
				 Mardi_salle_8_10_L1.getItems().addAll(salle.getTitel());
				 Mardi_salle_8_10_L2.getItems().addAll(salle.getTitel());
				 Mardi_salle_10_12_L1.getItems().addAll(salle.getTitel());
				 Mardi_salle_10_12_L2.getItems().addAll(salle.getTitel());
				 Mardi_salle_2_4_L1.getItems().addAll(salle.getTitel());
				 Mardi_salle_2_4_L2.getItems().addAll(salle.getTitel());
				 Mardi_salle_4_6_L1.getItems().addAll(salle.getTitel());
				 Mardi_salle_4_6_L2.getItems().addAll(salle.getTitel());
				 
				//MERCREDI 
				 Mercredi_salle_8_10_L1.getItems().addAll(salle.getTitel());
				 Mercredi_salle_8_10_L2.getItems().addAll(salle.getTitel());
				 Mercredi_salle_10_12_L1.getItems().addAll(salle.getTitel());
				 Mercredi_salle_10_12_L2.getItems().addAll(salle.getTitel());
				 Mercredi_salle_2_4_L1.getItems().addAll(salle.getTitel());
				 Mercredi_salle_2_4_L2.getItems().addAll(salle.getTitel());
				 Mercredi_salle_4_6_L1.getItems().addAll(salle.getTitel());
				 Mercredi_salle_4_6_L2.getItems().addAll(salle.getTitel());
				 
				//JEUDI
				 Jeudi_salle_8_10_L1.getItems().addAll(salle.getTitel());
				 Jeudi_salle_8_10_L2.getItems().addAll(salle.getTitel());
				 Jeudi_salle_10_12_L1.getItems().addAll(salle.getTitel());
				 Jeudi_salle_10_12_L2.getItems().addAll(salle.getTitel());
				 Jeudi_salle_2_4_L1.getItems().addAll(salle.getTitel());
				 Jeudi_salle_2_4_L2.getItems().addAll(salle.getTitel());
				 Jeudi_salle_4_6_L1.getItems().addAll(salle.getTitel());
				 Jeudi_salle_4_6_L2.getItems().addAll(salle.getTitel());
				 
				//VENDREDI
				 Vendredi_salle_8_10_L1.getItems().addAll(salle.getTitel());
				 Vendredi_salle_8_10_L2.getItems().addAll(salle.getTitel());
				 Vendredi_salle_10_12_L1.getItems().addAll(salle.getTitel());
				 Vendredi_salle_10_12_L2.getItems().addAll(salle.getTitel());
				 Vendredi_salle_2_4_L1.getItems().addAll(salle.getTitel());
				 Vendredi_salle_2_4_L2.getItems().addAll(salle.getTitel());
				 Vendredi_salle_4_6_L1.getItems().addAll(salle.getTitel());
				 Vendredi_salle_4_6_L2.getItems().addAll(salle.getTitel());
			 }
		 }catch(Exception e) {
			 System.out.print(e);
		 }
	 }
	 
	
}
