import java.util.Random;
public class StartAdventure {
private double playerHealth;
private double monsterHealth;
private double heal;

	
	public StartAdventure(double health){//constructor to define playerhealth, monsterhealth, and the heal value
		
		playerHealth = health;
		monsterHealth = 50;
		heal = 15;
	}
	
	
	public String getJurassicLocation(){//getters for each location
		return "Jurassic Era";
	}
	
	public String getEgyptLocation(){
		return "Ancient Egypt";
	}
	public String getRenaissanceLocation(){
		return "Renaissance";
	}
	public String getIndustrialLocation(){
		return "Industrial Age";
	}
	public String getInformationLocation(){
		return "Information Age";
	}
	public String attack(){//getters for attack/heal
		return "attack";
	}
	public String heal(){
		return "heal";
	}
	public String timeSlash(){//getters for attack type
		return "time slash";
	}
	public String timeFlame(){
		return "time flame";
	}
	public String timeBomb(){
		return "time bomb";
	}
	
	
	public void playerHeal(){//player heal method that increases the player health by the heal amount
		playerHealth = playerHealth + heal;
	}
	public void resetMonsterHealth(){//resets the monster health after each adventure
		this.monsterHealth = 50;
	}
	public void monsterHealthReduce(double attackValue){//reduces the monsters health when the player attacks
	
		monsterHealth = monsterHealth-attackValue;
		
	}
	public void monsterHealthGain(double health){//this allows us to give the harder monsters extra health when they spawn
		this.monsterHealth = monsterHealth + health;
	}
	public void playerHealthReduce(double attackValue){//this method reduces the players health when the monster attacks
		
		playerHealth = playerHealth-attackValue;
		
	}
	public double wrongAnswer(double health){
		health = health-25;
		return health;
	}
	public void setMonsterHealth(double monsterHealth){
		this.monsterHealth = monsterHealth;
	}
	public double getPlayerHealth(){//getters for playerhealth and monsterhealth
		return playerHealth;
	}
	
	public double getMonsterHealth(){
		return monsterHealth;
	}
	
	public int randomNumber100(){//random number methods to generate random numbers for monster attacks
		Random rand1 = new Random();
	int  attack = rand1.nextInt(100) + 1;
	return attack;
	}
	public int randomNumber25(){
		Random rand2 = new Random();	
		int  attack = rand2.nextInt(25) + 1;
		return attack;
	}
	public int randomNumber50(){
		Random rand2 = new Random();	
		int  attack = rand2.nextInt(50) + 1;
		return attack;
	}
	
}
