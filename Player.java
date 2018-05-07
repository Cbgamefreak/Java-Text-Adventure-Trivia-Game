
public class Player {
private double health;//defines default variables for player 
private String name;
private String location;

	public Player(){//default constructor
		health = 100;
		name = "Mr Books";
		location = "spacetime";
	}
	public Player(double playerHealth, String playerName, String playerLocation){//constructor to set name health and location of player
		this.health = playerHealth;
		this.name = playerName;
		this.location = playerLocation;
		
	}
	public void setPlayerLocation(String location){//setters for location and health
		this.location = location;
	}
	
	public void setPlayerHealth(double health){
		this.health = health;
	}
	
	public double getPlayerHealth(){//getters for location and health
		return health;
	}
	
	public String getPlayerLocation(){
		return location;
	}
	public String getPlayerName(){
		return name;
	}
	
	
	

}
