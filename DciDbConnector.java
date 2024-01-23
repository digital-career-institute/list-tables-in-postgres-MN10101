package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DciDbConnector {
	   public static Connection connect() throws SQLException {
	        String url = "jdbc:postgresql://localhost:5432/test";
	        String user = "postgres";
	        String password = "";
	        
	        return DriverManager.getConnection(url, user, password);
	    }
}
