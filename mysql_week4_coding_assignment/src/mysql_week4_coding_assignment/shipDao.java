package mysql_week4_coding_assignment;
import java.sql.*;
import java.util.*;
import mysql_week4_coding_assignment.Ship;

public class shipDao {
	//this has the dao functions for our application
	
	public List<Ship> listShips() {
	    String sql = "SELECT * FROM spaceships";
	    Connection conn = singletonConnection.instance().getConnection();

	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	      List<Ship> ships = new LinkedList<>();

	      try (ResultSet rs = stmt.executeQuery()) {
	      
	        while (rs.next()) {
	          Ship ship = new Ship(rs.getInt(1), rs.getString(2),rs.getDouble(3));
	          ships.add(ship);
	        }
	      }

	      return ships;
	    } catch (SQLException e) {
	      throw new IllegalStateException(e.getMessage(), e);
	    }
	  }

	  public void createShip(String name,Double speed) {
	    String sql = "INSERT INTO spaceships (name,speed) VALUES (?,?)";
	    Connection conn = singletonConnection.instance().getConnection();

	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	     
	      stmt.setString(1, name);
	      stmt.setDouble(2, speed);
	      stmt.executeUpdate();
	    } catch (SQLException e) {
	      throw new IllegalStateException(e.getMessage(), e);
	    }
	  }

	
	  public void deleteShip(Integer id) {
	    String sql = "DELETE FROM spaceships WHERE ship_id = ?";
	    Connection conn = singletonConnection.instance().getConnection();

	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	      stmt.setInt(1, id);

	    
	      if (stmt.executeUpdate() == 0) {
	        throw new IllegalArgumentException("Ship with ship_id " + id + " isn't in the database!");
	      }
	    } catch (SQLException e) {
	      throw new IllegalStateException(e.getMessage(), e);
	    }
	  }

	  
	  public void changeShip(Integer id, String name,Double speed) {
	    String sql = "UPDATE spaceships SET name = ?, speed = ? WHERE ship_id = ?";
	    Connection conn = singletonConnection.instance().getConnection();

	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	      stmt.setString(1, name);
	      stmt.setDouble(2,speed);
	      stmt.setInt(3, id);
	      

	      if (stmt.executeUpdate() == 0) {
	        throw new IllegalArgumentException("Ship with ship id " + id + " is not in the database!");
	      }
	    } catch (SQLException e) {
	      throw new IllegalStateException(e.getMessage(), e);
	    }
	  }

	
	

}
