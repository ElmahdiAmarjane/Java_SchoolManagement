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
	EmploiDao emploi=new EmploiDao();
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
	 private ComboBox<String> Lundi_8_10_element, Lundi_8_10_salle, Lundi_8_10_type;
	 @FXML 
	 private ComboBox<String> Lundi_10_12_element,Lundi_10_12_salle,Lundi_10_12_type;
	 @FXML 
	 private ComboBox<String> Lundi_14_16_element,Lundi_14_16_salle,Lundi_14_16_type;
	 @FXML 
	 private ComboBox<String> Lundi_16_18_element,Lundi_16_18_salle,Lundi_16_18_type;
	
	 //MARDI
	 @FXML 
	 private ComboBox<String> Mardi_8_10_element, Mardi_8_10_salle, Mardi_8_10_type;
	 @FXML 
	 private ComboBox<String> Mardi_10_12_element,Mardi_10_12_salle,Mardi_10_12_type;
	 @FXML 
	 private ComboBox<String> Mardi_14_16_element,Mardi_14_16_salle,Mardi_14_16_type;
	 @FXML 
	 private ComboBox<String> Mardi_16_18_element,Mardi_16_18_salle,Mardi_16_18_type;
	 
	 //MERCREDI
	 @FXML 
	 private ComboBox<String> Mercredi_8_10_element, Mercredi_8_10_salle, Mercredi_8_10_type;
	 @FXML 
	 private ComboBox<String> Mercredi_10_12_element,Mercredi_10_12_salle,Mercredi_10_12_type;
	 @FXML 
	 private ComboBox<String> Mercredi_14_16_element,Mercredi_14_16_salle,Mercredi_14_16_type;
	 @FXML 
	 private ComboBox<String> Mercredi_16_18_element,Mercredi_16_18_salle,Mercredi_16_18_type;
	 
	 //JEUDI
	 @FXML 
	 private ComboBox<String> Jeudi_8_10_element, Jeudi_8_10_salle, Jeudi_8_10_type;
	 @FXML 
	 private ComboBox<String> Jeudi_10_12_element,Jeudi_10_12_salle,Jeudi_10_12_type;
	 @FXML 
	 private ComboBox<String> Jeudi_14_16_element,Jeudi_14_16_salle,Jeudi_14_16_type;
	 @FXML 
	 private ComboBox<String> Jeudi_16_18_element,Jeudi_16_18_salle,Jeudi_16_18_type;
	 
	 //VENDREDI
	 @FXML 
	 private ComboBox<String> Vendredi_8_10_element, Vendredi_8_10_salle, Vendredi_8_10_type;
	 @FXML 
	 private ComboBox<String> Vendredi_10_12_element,Vendredi_10_12_salle,Vendredi_10_12_type;
	 @FXML 
	 private ComboBox<String> Vendredi_14_16_element,Vendredi_14_16_salle,Vendredi_14_16_type;
	 @FXML 
	 private ComboBox<String> Vendredi_16_18_element,Vendredi_16_18_salle,Vendredi_16_18_type;
	 
	 @FXML
	 ComboBox <String> list_profs;
	 
	 
	 public void initialize() {
		 initializeComboBox();
	 }
	 
	 @FXML
	public void saveEmploiFilier() {
		
		 /*
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
		 
		 */
			
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
		
		//Les Professeurs
		try {
			List<Professeur> professeurs=professeurDao.selectAllProfesseur();
			
			for(Professeur prof:professeurs) {
				list_profs.getItems().add(prof.getNom()+" "+prof.getPrenom());
			}
		}catch(Exception e) {
			System.out.print(e);
		}
		
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
				 Lundi_8_10_element.getItems().addAll(elem.getNom());
				 Lundi_10_12_element.getItems().addAll(elem.getNom());
				 Lundi_14_16_element.getItems().addAll(elem.getNom());
				 Lundi_16_18_element.getItems().addAll(elem.getNom());
				 
				//MARDI
				 Mardi_8_10_element.getItems().addAll(elem.getNom());
				 Mardi_10_12_element.getItems().addAll(elem.getNom());
				 Mardi_14_16_element.getItems().addAll(elem.getNom());
				 Mardi_16_18_element.getItems().addAll(elem.getNom());
				 
				//MERCEDI
				 Mercredi_8_10_element.getItems().addAll(elem.getNom());
				 Mercredi_10_12_element.getItems().addAll(elem.getNom());
				 Mercredi_14_16_element.getItems().addAll(elem.getNom());
				 Mercredi_16_18_element.getItems().addAll(elem.getNom());
				 
				//JUEDI
				 Jeudi_8_10_element.getItems().addAll(elem.getNom());
				 Jeudi_10_12_element.getItems().addAll(elem.getNom());
				 Jeudi_14_16_element.getItems().addAll(elem.getNom());
				 Jeudi_16_18_element.getItems().addAll(elem.getNom());
				 
				//Vendredi
				 Vendredi_8_10_element.getItems().addAll(elem.getNom());
				 Vendredi_10_12_element.getItems().addAll(elem.getNom());
				 Vendredi_14_16_element.getItems().addAll(elem.getNom());
				 Vendredi_16_18_element.getItems().addAll(elem.getNom());
				 
			 }
		 }catch(Exception e2) {
			 System.out.println(e2);
		 }
		 
		 List<String> types=List.of("CM","TD","TP");
		 			 
			//PROF
			 for(String type:types ) {
				 //LUNDI
				 Lundi_8_10_type.getItems().addAll(type);
				 Lundi_10_12_type.getItems().addAll(type);
				 Lundi_14_16_type.getItems().addAll(type);
				 Lundi_16_18_type.getItems().addAll(type);
				 
				//MARDI
				 Mardi_8_10_type.getItems().addAll(type);
				 Mardi_10_12_type.getItems().addAll(type);
				 Mardi_14_16_type.getItems().addAll(type);
				 Mardi_16_18_type.getItems().addAll(type);
				 
				//MERCREDI
				 Mercredi_8_10_type.getItems().addAll(type);
				 Mercredi_10_12_type.getItems().addAll(type);
				 Mercredi_14_16_type.getItems().addAll(type);
				 Mercredi_16_18_type.getItems().addAll(type);
				 
				//LUNDI
				 Jeudi_8_10_type.getItems().addAll(type);
				 Jeudi_10_12_type.getItems().addAll(type);
				 Jeudi_14_16_type.getItems().addAll(type);
				 Jeudi_16_18_type.getItems().addAll(type);
				 
				//LUNDI
				 Vendredi_8_10_type.getItems().addAll(type);
				 Vendredi_10_12_type.getItems().addAll(type);
				 Vendredi_14_16_type.getItems().addAll(type);
				 Vendredi_16_18_type.getItems().addAll(type);
			 }
		 
		 
		 try {
			 salles=salleDao.selectSalle();

			//SALLE
			 for(Salle salle:salles ) {
				 
				 //LUNDI
				 Lundi_8_10_salle.getItems().addAll(salle.getTitel());
				 Lundi_10_12_salle.getItems().addAll(salle.getTitel());
				 Lundi_14_16_salle.getItems().addAll(salle.getTitel());
				 Lundi_16_18_salle.getItems().addAll(salle.getTitel());
				 
				 
				//MARDI
				 Mardi_8_10_salle.getItems().addAll(salle.getTitel());
				 Mardi_10_12_salle.getItems().addAll(salle.getTitel());
				 Mardi_14_16_salle.getItems().addAll(salle.getTitel());
				 Mardi_16_18_salle.getItems().addAll(salle.getTitel());
				 
				//MERCREDI 
				 Mercredi_8_10_salle.getItems().addAll(salle.getTitel());
				 Mercredi_10_12_salle.getItems().addAll(salle.getTitel());
				 Mercredi_14_16_salle.getItems().addAll(salle.getTitel());
				 Mercredi_16_18_salle.getItems().addAll(salle.getTitel());
				 
				//JEUDI
				 Jeudi_8_10_salle.getItems().addAll(salle.getTitel());
				 Jeudi_10_12_salle.getItems().addAll(salle.getTitel());
				 Jeudi_14_16_salle.getItems().addAll(salle.getTitel());
				 Jeudi_16_18_salle.getItems().addAll(salle.getTitel());
				 
				//VENDREDI
				 Vendredi_8_10_salle.getItems().addAll(salle.getTitel());
				 Vendredi_10_12_salle.getItems().addAll(salle.getTitel());
				 Vendredi_14_16_salle.getItems().addAll(salle.getTitel());
				 Vendredi_16_18_salle.getItems().addAll(salle.getTitel());
			 }
		 }catch(Exception e) {
			 System.out.print(e);
		 }
	 }
	 
	
}