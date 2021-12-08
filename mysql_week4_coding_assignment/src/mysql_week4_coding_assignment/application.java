package mysql_week4_coding_assignment;

import java.sql.*;
public class application {

	public static void main(String[] args) {
		
		System.out.println("starting menu application");
	//	new Menu().run();
		

		

		String connectionString = "jdbc:mysql://localhost:3306/mysql_week4_coding_assignment_db";

			

			try {

				Connection conn = DriverManager.getConnection(connectionString, "root", "root");

				System.out.println("connected successfully");

				

				 String sql = "SELECT * FROM spaceships";

			    



			    PreparedStatement stmt = conn.prepareStatement(sql);

			



			      ResultSet rs = stmt.executeQuery();

			      

			        while (rs.next()) {

			          System.out.println(String.valueOf(rs.getInt(1))+ rs.getString(2)+String.valueOf(rs.getDouble(3)));

			   

			        }

			      

		



			

				  

				conn.close();  

				

			}

			catch (SQLException e) {

				System.out.println("Error");

				e.printStackTrace();



		}
	
	}
}
