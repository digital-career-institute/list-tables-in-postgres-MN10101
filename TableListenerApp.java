package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableListenerApp {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Establish a connection to the database
			connection = DciDbConnector.connect();
			if (connection != null) {
				System.out.println("Connection successful");
				
				// Get DatabaseMetaData
				DatabaseMetaData metaData = connection.getMetaData();
				
				// Get tables
				ResultSet resultSet = metaData.getTables(null, null, "%", new String[] { "TABLE" });
				
				// Display the list of tables
				System.out.println("List of Tables:");
				while (resultSet.next()) {
					String tableName = resultSet.getString("test");
					System.out.println(tableName);
				}
				resultSet.close();
			} else {
				System.out.println("Connection failed");
			}
		} catch (SQLException e) {
			// Handle exceptions
			System.out.println(e);
		} finally {
			// Close the connection in the finally block
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
}
