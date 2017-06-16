package media_library.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
    private static String url = "jdbc:postgresql://localhost:5432/MediaLibrary";    
    private static String driverName = "org.postgresql.Driver";   
    private static String username = "postgres";   
    private static String password = "fipa1807";
    private static Connection con;
   

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
            	//trying to connect to database
                con = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to Database");
                
            } catch (SQLException ex) {
            	
                // log an exception. for example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
        	
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
}