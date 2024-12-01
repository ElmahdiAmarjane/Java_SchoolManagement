module schoolManagement {
	requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires java.sql; 
    requires java.base; 
    requires org.json;


   // requires controlsfx;
	
	opens application to javafx.graphics, javafx.fxml;
	opens controllers to javafx.fxml;
	opens dao to javafx.fxml;
	opens modules to javafx.base;
	opens services to javafx.fxml;
	opens db_connect to javafx.fxml;
}