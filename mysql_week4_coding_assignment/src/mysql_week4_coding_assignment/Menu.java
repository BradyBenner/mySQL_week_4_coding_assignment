package mysql_week4_coding_assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private shipDao shipDao = new shipDao();
	
	private List<String> instructions = Arrays.asList(
				"1. List ships",
				"2. Create a ship",
				"3. Delete a ship",
				"4. Change a ship"
			
			);
	public void run() {
	boolean done = false;
	while(!done) {
		
		printMenu();
		
		try {
			
			Integer choice = getSelection("Enter a menu number or press <Enter> to quit");
			
			if(choice == null) {
				done = true;
			} else
				switch(choice) {
				case 1: 
					listShips();
					break;
				case 2: 
					createShip();
					break;
				case 3: 
					deleteShip();
					break;
				case 4: changeShip();
				break;
				
				default: 
					System.out.println(choice+ " is not a good selection. Try again. \n");
					break;
				}
			
			
		}
		
		catch (Exception e) {
			
			System.out.println("\n"+e.getMessage()+ " Try again");
			
		}
		
	}
	System.out.println("Goodbye");
	
			
	
	
	
	
	
	
	
	
	
	/*String connectionString = "jdbc:mysql://localhost:3306/mysql_week4_coding_assignment_db";
	
	try {
		Connection conn = DriverManager.getConnection(connectionString, "root", "root");
		System.out.println("connected successfully");
		/*PreparedStatement stmt=conn.prepareStatement("insert into spaceships values(?,?,?)");  
		stmt.setInt(1,1);//1 specifies the first parameter in the query  
		stmt.setString(2,"First");  
		stmt.setDouble(3, 2.03);
		 
		PreparedStatement stmt=conn.prepareStatement("delete from spaceships where ship_id=1"); 
		int i=stmt.executeUpdate();  
		System.out.println(i+" records changed");  
		  
		conn.close();  
		
	}
	catch (SQLException e) {
		System.out.println("Error connecting to db");
		e.printStackTrace();

}
*/
}

private  void printMenu() {
	// TODO Auto-generated method stub
	for(String line:instructions) {
		System.out.println(line);
	}
	
}

private  void changeShip() {
	// TODO Auto-generated method stub
	System.out.println("picked modify");
    listShips();
    Integer id = getSelection("Enter a Ship ID to change");

    if (id != null) {
      String name = getStringSelection("Enter the new Ship name");
      Double speed = Double.parseDouble(getStringSelection("Enter new Ship speed"));
      

      if (name != null) {
        shipDao.changeShip(id, name, speed);
        System.out.println("Ship name changed to " + name + " and speed to "+ String.valueOf(speed)+" for ID=" + id);
      }
    }

	
}

private void deleteShip() {
    Integer id = getSelection("Enter a Ship ID to delete");
    shipDao.deleteShip(id);

  
    System.out.println("Ship with ID=" + id + " was deleted.");
  }


private void createShip() {
    String name = getStringSelection("Enter a Ship name");
    Double speed = Double.parseDouble(getStringSelection("Enter new Ship speed"));
    shipDao.createShip(name,speed);
    System.out.println("Ship " + name + " created!");
  }


private  void listShips() {
	// TODO Auto-generated method stub
	System.out.println("picked list");
	  
		    List<Ship> ships = shipDao.listShips();
		    System.out.println("All ships:");
		    for (Ship ship : ships) {
		      System.out.println("   " + ship);
		    }
		  

	
}

private  Integer getSelection(String prompt) {
	// TODO Auto-generated method stub
	String selection = getStringSelection(prompt);
	
	if(selection==null) return null;
	
	try {
		return Integer.valueOf(selection);
	}
	catch (NumberFormatException e) {
		throw new IllegalStateException(selection + " is not a good selection");
		
	}
}

private  String getStringSelection(String prompt) {
	// TODO Auto-generated method stub
	System.out.println("\n"+ prompt+ ":");
	String selection= scanner.nextLine();
	
	return selection.isBlank()?null:selection.trim();
}

}
