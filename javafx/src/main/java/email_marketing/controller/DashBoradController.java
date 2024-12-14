package email_marketing.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import email_marketing.App;
import email_marketing.Cookies;
import email_marketing.database.DatabaseConnection;
import email_marketing.model.User;
import email_marketing.tableSettersGetters.sendingEmailsTable;

public class DashBoradController implements Initializable {
	private User user;
	private Cookies cookie = new Cookies();

    @FXML
    private Label usernameLabel;
    @FXML
    private Label emailLabel;
	@FXML
    private Button sendingEmail_btn;
	@FXML
    private Button to_lead_page_btn, addCompagnBtn;
	@FXML
    private Button compagn_btn;
	
	@FXML
    private Button logout;

    @FXML
    private AnchorPane compagn_page;

    @FXML
    private Button leads_btn;

    @FXML
    private AnchorPane leads_page;

    @FXML
    private Button setting_btn;

    @FXML
    private AnchorPane setting_page;
    
    @FXML
    private Button minimize;
	
	@FXML
    private AnchorPane main_form;
	
	@FXML
    private Button close;
	
	 @FXML
    private TableColumn<sendingEmailsTable, Button> deleteColumn;
    @FXML
    private TableColumn<sendingEmailsTable, String> emailColumn;
    @FXML
    private TableColumn<sendingEmailsTable, Integer> maxUseColumn;
    @FXML
    private TableColumn<sendingEmailsTable, CheckBox> selectedColumn;
    @FXML
    private TableView<sendingEmailsTable> sendingEmailsTableView;

    @FXML
    private TextField delay_setting_field;
    @FXML
    private ComboBox<String> end_hour;
    @FXML
    private ComboBox<String> start_hour;
    
    @FXML
    private Label testFirld;
    @FXML
    private TextArea textAreaSendingEmails;
    @FXML
    void textAreaSendingEmailsTyped(KeyEvent event) {
    	ObservableList<CharSequence> list = textAreaSendingEmails.getParagraphs();
    	int par = list.size();
    	testFirld.setText("nbr "+par);
    }
	
	public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }
	
	public void close() {
		System.exit(0);
	}
	
	
	public void to_lead_page_btn() {
		try {
			
			Parent root = App.loadFXML("leadsMenu");
			Stage stage = new Stage();
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.initModality(Modality.APPLICATION_MODAL);
	        
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.showAndWait();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addCompagnBtn() {
		try {
			
			Parent root = App.loadFXML("addCompagn");
			Stage stage = new Stage();
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.initModality(Modality.APPLICATION_MODAL);
	        
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.showAndWait();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendingEmail_btn() {
try {
			
			Parent root = App.loadFXML("sendingEmailMenu");
			Stage stage = new Stage();
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.initModality(Modality.APPLICATION_MODAL);
	        
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.showAndWait();
}catch(Exception e) {
	e.printStackTrace();
}
			
	}
	
	public void switchPage(ActionEvent event) {
		if (event.getSource() == compagn_btn) {
			
			compagn_page();

        } else if (event.getSource() == leads_btn) {
        	

        	leads_page();

        } else if (event.getSource() == setting_btn) {
        	
        	setting_page();

        }
	}
	public void logout() {
		
		try {
			
			logout.getScene().getWindow().hide();
			Parent root = App.loadFXML("login");
			Stage stage = new Stage();
			stage.initStyle(StageStyle.TRANSPARENT);
			cookie.supprimerFichier();
	        
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void compagn_page(){
		compagn_page.setVisible(true);
		leads_page.setVisible(false);
		setting_page.setVisible(false);
		
		compagn_btn.getStyleClass().clear();
		leads_btn.getStyleClass().clear();
		setting_btn.getStyleClass().clear();

		compagn_btn.getStyleClass().add("sideBar-btn-active");
		leads_btn.getStyleClass().add("sideBar-btn");
		setting_btn.getStyleClass().add("sideBar-btn");
	}
	public void leads_page(){
		compagn_page.setVisible(false);
    	leads_page.setVisible(true);
    	setting_page.setVisible(false);
    	
    	compagn_btn.getStyleClass().clear();
		leads_btn.getStyleClass().clear();
		setting_btn.getStyleClass().clear();

    	compagn_btn.getStyleClass().add("sideBar-btn");
    	leads_btn.getStyleClass().add("sideBar-btn-active");
    	setting_btn.getStyleClass().add("sideBar-btn");
	}
	public void setting_page(){
		compagn_page.setVisible(false);
        leads_page.setVisible(false);
        setting_page.setVisible(true);
        
        compagn_btn.getStyleClass().clear();
		leads_btn.getStyleClass().clear();
		setting_btn.getStyleClass().clear();

        compagn_btn.getStyleClass().add("sideBar-btn");
        leads_btn.getStyleClass().add("sideBar-btn");
        setting_btn.getStyleClass().add("sideBar-btn-active");
        
        start_hour.getItems().addAll("08:00", "08:30", "09:00", "09:30");
    	start_hour.setValue("08:30");
    	end_hour.getItems().addAll("18:00", "18:30", "19:00");
    	end_hour.setValue("18:30");
    	
    	delay_setting_field.setText("120");
    	
    	sendingEmailsTableView.setItems(liste);
    	selectedColumn.setCellValueFactory(new PropertyValueFactory<sendingEmailsTable, CheckBox>("selected"));
    	emailColumn.setCellValueFactory(new PropertyValueFactory<sendingEmailsTable, String>("email"));
    	maxUseColumn.setCellValueFactory(new PropertyValueFactory<sendingEmailsTable, Integer>("max_use"));
    	deleteColumn.setCellValueFactory(new PropertyValueFactory<sendingEmailsTable, Button>("delete"));
	}
	
	ObservableList<sendingEmailsTable> liste = FXCollections.observableArrayList();
	
	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;
	public void getUser(User user) {
		String sql = "SELECT * FROM user WHERE email = ?";
		String email = user.getEmail();
		
		connect = DatabaseConnection.connect();
		if (connect == null) {
	        System.out.println("Failed to connect to the database.");
	        System.exit(0);
	    }else {
	    	System.out.println("connect to the database.");
	    }
		
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, email);
			
			result = prepare.executeQuery();
				if(result.next()) {
					String id = result.getString("user_id");
	                String username = result.getString("username");
	                this.user = new User(id, username, email);
				}else {
					System.out.println("Error Message");
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
    private StackPane rootPane;
	private double xOffset = 0;
	private double yOffset = 0;
    public void initialize(URL location, ResourceBundle resources) {
    	rootPane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        rootPane.setOnMouseDragged(event -> {
            Stage stage = (Stage) rootPane.getScene().getWindow();
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
        
        
        
        try {
        	getUser(cookie.chargerDonnees());
        }catch (IOException e) {
            e.printStackTrace();
        }
        usernameLabel.setText(user.getUsername());
        emailLabel.setText(user.getEmail());
        
    	compagn_page();
    	
    	
    	
    	for(int i=0; i<5; i++) {
    		CheckBox ch = new CheckBox();
    		liste.add(new sendingEmailsTable(ch, "bougaillou.ibrahim@gmail.com", 7));
    	}
    	
    }
}
