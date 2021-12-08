package mysql_week4_coding_assignment;

public class Ship {
	


	//this is the ship class which allows us to make ship objects
	private Integer ship_Id;
	private String name;
	private Double speed;
	
	public Ship(Integer ship_Id, String name, Double speed) {
		this.ship_Id = ship_Id;
		this.name = name;
		this.speed = speed;
	}
	
	  public Integer getshipId() {
		    return ship_Id;
		  }

		 
	  public String getName() {
		    return name;
		  }
	 public Double getSpeed() {
		 return speed;
	 }

		  
		  @Override
		  public String toString() {
		    return "Ship [ship_Id=" + ship_Id + ", name=" + name +",speed= "+speed +"]";
		  }


}
