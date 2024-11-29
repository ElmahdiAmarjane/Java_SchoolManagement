package controllers;

import java.util.ArrayList;
import java.util.List;

import dao.AnnonceDao;
import dao.FilierDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modules.Annonce;
import modules.Filier;

public class AnnonceController {
	
	private AnnonceDao annonceDao = new AnnonceDao() ;
	private Annonce annonce;
	private  List<Annonce> annonces;


	////////////////////
	@FXML private ScrollPane annoncesScrollPane;
	@FXML private AnchorPane annoncesListAnchorPane;
	@FXML private AnchorPane annoncesAddAnchorPane;
	
	
	 @FXML
	 public void initialize() {
		 
	     if (annoncesScrollPane != null) {
	         // Create and configure the GridPane
	         GridPane gridPane = new GridPane();
	         gridPane.setHgap(10);
	         gridPane.setVgap(10);
	         gridPane.setPadding(new Insets(10));

	         // Add widgets to the GridPane
	         addWidgetsToGridPane(gridPane);

	         // Wrap GridPane in a VBox (to prevent sizing issues)
	         VBox container = new VBox(gridPane);
	         container.setPadding(new Insets(10));
	         ////////////////

	         // Set the container as ScrollPane content
	         annoncesScrollPane.setContent(container);

	         // Configure ScrollPane
	         annoncesScrollPane.setFitToWidth(true);
	         annoncesScrollPane.setPannable(true);
	     } else {
	         System.out.println("ScrollPane is not initialized");
	     }
	 }

	 private void addWidgetsToGridPane(GridPane gridPane) {
	     AnnonceWidgetController loader = new AnnonceWidgetController();
	     try {
	         int col = 0, row = 0;
	         annonces = new ArrayList<>();

	         annonces = annonceDao.selectAllAnnonce();
	         if (!annonces.isEmpty()) {
	             for (Annonce annonce : annonces) {
	                 Pane widget1 = loader.loadAnnonceWidget(
	                     annonce.getTitle(),
	                     annonce.getContenu(),
	                    annonce.getDateAnnonce().toString()
	                 );

	                 // Add the widget to the gridPane
	                 gridPane.add(widget1, col, row++);

	                 // Center the widget in the grid
	                 GridPane.setHalignment(widget1, HPos.CENTER);
	                 GridPane.setValignment(widget1, VPos.CENTER);
	             }
	         }

	         // Set a fixed height for each row
	         for (int i = 0; i <= row; i++) {
	             RowConstraints rowConstraints = new RowConstraints();
	             rowConstraints.setPrefHeight(200); // Set fixed height for rows
	             rowConstraints.setVgrow(Priority.NEVER); // Prevent resizing
	             gridPane.getRowConstraints().add(rowConstraints);
	         }
	      // Set a fixed width for each column
	         for (int i = 0; i <= col; i++) {
	             ColumnConstraints columnConstraints = new ColumnConstraints();
	             columnConstraints.setPrefWidth(900); // Set fixed width for columns
	             columnConstraints.setHgrow(Priority.NEVER); // Prevent resizing
	             gridPane.getColumnConstraints().add(columnConstraints);
	         }


	     } catch (Exception e) {
	         e.printStackTrace();
	     }
	 }

	 public void setAnnoncesListToFront() {
		 annoncesListAnchorPane.toFront();
	 }
	
	 public void setAnnonceAddAnchorPaneToFront() {
		 annoncesAddAnchorPane.toFront();
		 
	 }
	 public void setFAnnoncesDetailsToFront() {
		 
	 }
	
	
	

}
