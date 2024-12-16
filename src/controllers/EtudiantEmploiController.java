package controllers;

import dao.EmploiDao;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import modules.Emploi;
import java.util.List;

public class EtudiantEmploiController {

    EmploiDao empoiDao = new EmploiDao();
    Emploi emploi;
    
    @FXML 
    private Pane emploiTempsPane;

    @FXML
    private TextArea Lundi_8_10, Lundi_10_12, Lundi_2_4, Lundi_4_6;
    @FXML
    private TextArea Mardi_8_10, Mardi_10_12, Mardi_2_4, Mardi_4_6;
    @FXML
    private TextArea Mercredi_8_10, Mercredi_10_12, Mercredi_2_4, Mercredi_4_6;
    @FXML
    private TextArea Jeudi_8_10, Jeudi_10_12, Jeudi_2_4, Jeudi_4_6;
    @FXML
    private TextArea Vendredi_8_10, Vendredi_10_12, Vendredi_2_4, Vendredi_4_6;

    public void initialize() {

        try {
            emploi = empoiDao.selectEmploiEtudiant("Ingenierie Logicielle");
            System.out.println(emploi.getDate());

            // Helper function to set the TextArea content safely
            setTextContent(Lundi_8_10, listToArray(emploi.getH_8_10_element_lundi()), listToArray(emploi.getH_8_10_salle_lundi()),listToArray(emploi.getH_8_10_salle_lundi()));
            setTextContent(Lundi_10_12, listToArray(emploi.getH_10_12_element_lundi()), listToArray(emploi.getH_10_12_salle_lundi()),listToArray(emploi.getH_10_12_salle_lundi()));
            setTextContent(Lundi_2_4, listToArray(emploi.getH_2_4_element_lundi()), listToArray(emploi.getH_2_4_salle_lundi()),listToArray(emploi.getH_2_4_salle_lundi()));
            setTextContent(Lundi_4_6, listToArray(emploi.getH_4_6_element_lundi()), listToArray(emploi.getH_4_6_salle_lundi()),listToArray(emploi.getH_4_6_salle_lundi()));

            // MARDI
            setTextContent(Mardi_8_10, listToArray(emploi.getH_8_10_element_mardi()), listToArray(emploi.getH_8_10_salle_mardi()),listToArray(emploi.getH_8_10_salle_mardi()));
            setTextContent(Mardi_10_12, listToArray(emploi.getH_10_12_element_mardi()), listToArray(emploi.getH_10_12_salle_mardi()),listToArray(emploi.getH_10_12_salle_mardi()));
            setTextContent(Mardi_2_4, listToArray(emploi.getH_2_4_element_mardi()), listToArray(emploi.getH_2_4_salle_mardi()),listToArray(emploi.getH_2_4_salle_mardi()));
            setTextContent(Mardi_4_6, listToArray(emploi.getH_4_6_element_mardi()), listToArray(emploi.getH_4_6_salle_mardi()),listToArray(emploi.getH_4_6_salle_mardi()));

            // MERCREDI
            setTextContent(Mercredi_8_10, listToArray(emploi.getH_8_10_element_mercredi()), listToArray(emploi.getH_8_10_salle_mercredi()),listToArray(emploi.getH_8_10_salle_mercredi()));
            setTextContent(Mercredi_10_12, listToArray(emploi.getH_10_12_element_mercredi()), listToArray(emploi.getH_10_12_salle_mercredi()),listToArray(emploi.getH_10_12_salle_mercredi()));
            setTextContent(Mercredi_2_4, listToArray(emploi.getH_2_4_element_mercredi()), listToArray(emploi.getH_2_4_salle_mercredi()),listToArray(emploi.getH_2_4_salle_mercredi()));
            setTextContent(Mercredi_4_6, listToArray(emploi.getH_4_6_element_mercredi()), listToArray(emploi.getH_4_6_salle_mercredi()),listToArray(emploi.getH_4_6_salle_mercredi()));

            // JEUDI
            setTextContent(Jeudi_8_10, listToArray(emploi.getH_8_10_element_jeudi()), listToArray(emploi.getH_8_10_salle_jeudi()),listToArray(emploi.getH_8_10_salle_jeudi()));
            setTextContent(Jeudi_10_12, listToArray(emploi.getH_10_12_element_jeudi()), listToArray(emploi.getH_10_12_salle_jeudi()),listToArray(emploi.getH_10_12_salle_jeudi()));
            setTextContent(Jeudi_2_4, listToArray(emploi.getH_2_4_element_jeudi()), listToArray(emploi.getH_2_4_salle_jeudi()),listToArray(emploi.getH_2_4_salle_jeudi()));
            setTextContent(Jeudi_4_6, listToArray(emploi.getH_4_6_element_jeudi()), listToArray(emploi.getH_4_6_salle_jeudi()),listToArray(emploi.getH_4_6_salle_jeudi()));

            // VENDREDI
            setTextContent(Vendredi_8_10, listToArray(emploi.getH_8_10_element_vendredi()), listToArray(emploi.getH_8_10_salle_vendredi()),listToArray(emploi.getH_8_10_salle_vendredi()));
            setTextContent(Vendredi_10_12, listToArray(emploi.getH_10_12_element_vendredi()), listToArray(emploi.getH_10_12_salle_vendredi()),listToArray(emploi.getH_10_12_salle_vendredi()));
            setTextContent(Vendredi_2_4, listToArray(emploi.getH_2_4_element_vendredi()), listToArray(emploi.getH_2_4_salle_vendredi()),listToArray(emploi.getH_2_4_salle_vendredi()));
            setTextContent(Vendredi_4_6, listToArray(emploi.getH_4_6_element_vendredi()), listToArray(emploi.getH_4_6_salle_vendredi()),listToArray(emploi.getH_4_6_salle_vendredi()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert List<String> to String[]
    private String[] listToArray(List<String> list) {
        return list.toArray(new String[0]);
    }

    // Helper method to set content in TextArea fields safely
    private void setTextContent(TextArea textArea, String[] elements, String[] rooms, String[] profs) {
        // Clear the TextArea before setting new text
        //textArea.clear();

        // Iterate over the elements and rooms to set the text
        for (String element : elements) {
            if (element != null && !element.equals("null ( null )") && !element.isEmpty()) {
                textArea.appendText(element + "\n");
            }else {
            	textArea.appendText(" ");
            }
        }

        for (String room : rooms) {
            if (room != null && !room.isEmpty()) {
                textArea.appendText(room + "\n");
            }else {
            	 textArea.appendText(" ");
            }
        }
        
        for(String prof:profs) {
        	if (prof != null && !prof.isEmpty()) {
                textArea.appendText(prof + "\n");
            }else {
            	 textArea.appendText(" ");
            }
        }
    }
}