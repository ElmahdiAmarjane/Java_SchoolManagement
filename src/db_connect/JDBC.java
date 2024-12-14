package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

   
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_ecole";
    private static final String USER = "root";
    private static final String PASSWORD = "";  
    
    public static void main(String[] args) {
        
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Connected to the database!");
        }
    }

    
    public static Connection getConnection() {
    	
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}