package mysql_week4_coding_assignment;

import java.sql.*;
import java.sql.DriverManager;
public final class singletonConnection {
	//this class creates and returns the singleton connection required to talk to the db
	private final static String URL = "jdbc:mysql://localhost:3306/mysql_week4_coding_assignment_db";
	private final static String USER = "root";
	private final static String PASSWORD = "root";
	
	private Connection connection;
	private static final singletonConnection INSTANCE = new singletonConnection();
	
	private singletonConnection() {
		System.out.println("Creating connection");
	}
	public static singletonConnection instance() {
		
		return INSTANCE;
		
	}
	
	public Connection getConnection() {
		if(connection == null) {
			
			try {
				
				connection = DriverManager.getConnection(URL,USER,PASSWORD);
				System.out.println("Successfully created connection");
				
			} catch(SQLException e)
			{
				
			e.printStackTrace();}
			}
		return connection;
	}
	
}
