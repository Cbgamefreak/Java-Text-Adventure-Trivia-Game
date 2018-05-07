
import java.util.Random;
import java.util.Scanner;
public class PlayGame {
	private static double health = 100;
	private static String name;
	private static String location;
	private static int playerTurn = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		//System.out.println("Please enter the number of players (1 or 2)");
		//playerCount = in.nextInt();
		System.out.println("Hello and welcome to Mr. Books Time Travel Adventure. You need to travel throughout the different eras and collect the pieces to repair your time machine!");
		System.out.println("Please enter a name for your character");
		name = in.nextLine();
	
		
		Player firstPlayer = new Player(health,name,location);
		//Player secondPlayer = new Player(health2,name2,location);
			StartAdventure firstAdventure = new StartAdventure(firstPlayer.getPlayerHealth());//creates a new player and new adventure object, sets the player to the jurassic location.
			firstPlayer.setPlayerLocation(firstAdventure.getJurassicLocation());
			System.out.println("Your name is  " + firstPlayer.getPlayerName());
			while (playerTurn >= 0 && playerTurn < 25){//playerTurn keeps track of the players point in the game throughout playtime, this allows you to revert to any part of the game for playback or testing and helps iteration
				while (playerTurn ==0){
					System.out.println("Hello and welcome to the " + firstAdventure.getJurassicLocation());
					System.out.println("There is a Tyrannosaurus Rex chasing after you!!!!");
					playerTurn =1;
				}
				
				while (playerTurn ==1){
					
					if (firstPlayer.getPlayerHealth() < 0){
						System.out.println("Game Over");	
							System.exit(0);	
					}
					
					playerTurn = 2;
					while (playerTurn == 2)	{//asks the user to input a value, either attack pr heal
						System.out.println("What do you want to do? (attack/heal)");
						String input1 = in.nextLine();
						input1.toLowerCase();					
						if (((input1.compareTo(firstAdventure.attack()) ==0) ||(input1.compareTo(firstAdventure.heal()) ==0)) &&  (playerTurn == 2)){
							
								if (input1.compareTo(firstAdventure.attack()) ==0){//if the player inputs attack then he may choose to use the three attacks
									System.out.println("What do you want to do? (time slash/time flame/time bomb)");
									String input2 = in.nextLine();
									input2.toLowerCase();
									while (playerTurn ==2){
										if ((input2.compareTo(firstAdventure.timeSlash()) ==0)){//each attack iterates the same code but generates different random numbers from the StartAventure Class. It then passes these values back to the player class to store
											int  playerAttack = firstAdventure.randomNumber100();
											System.out.println("You hit the T-Rex for " + playerAttack + " damage");
											firstAdventure.monsterHealthReduce(playerAttack);	
											int  monsterAttack = firstAdventure.randomNumber25();//the monster gets a turn to attack 
											firstAdventure.playerHealthReduce(monsterAttack);//this reduces the players 
											firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
											System.out.println("The T-Rex hit you for " + monsterAttack + " damage");
											playerTurn = 1;
											break;
										}
										if ((input2.compareTo(firstAdventure.timeFlame()) == 0)){//code is almost identical here, bunch of places to shorten it but I dont have time
											int  playerAttack = firstAdventure.randomNumber50();
											System.out.println("You hit the T-Rex for " + playerAttack + " damage");
											firstAdventure.monsterHealthReduce(playerAttack);	
											int  monsterAttack = firstAdventure.randomNumber25();
											firstAdventure.playerHealthReduce(monsterAttack);
											firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
											System.out.println("The T-Rex hit you for " + monsterAttack + " damage");
											playerTurn = 1;
											break;
										}
										if ((input2.compareTo(firstAdventure.timeBomb()) == 0)){//and here
											int  playerAttack = firstAdventure.randomNumber100();
											System.out.println("You hit the T-Rex for " + playerAttack + " damage");
											firstAdventure.monsterHealthReduce(playerAttack);	
											int  monsterAttack = firstAdventure.randomNumber50();
											firstAdventure.playerHealthReduce(monsterAttack);
											firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
											System.out.println("The T-Rex hit you for " + monsterAttack + " damage");
											playerTurn = 1;
											break;
										}
										else if ((input2.compareTo("time slash") !=0) ||(input2.compareTo("time flame") !=0) || (input2.compareTo("time bomb") !=0)){//this catches an incorrect input by the user
											System.out.println("That is an incorrect input");
											playerTurn = 1;
										}
									}
								System.out.println("Your health is " + firstPlayer.getPlayerHealth());//prints out health information after each attack
								System.out.println("The T-Rex health is  " + firstAdventure.getMonsterHealth());
							}
							if (input1.compareTo(firstAdventure.heal()) ==0){//this loop allows the player to heal, but still allows the monster to attack, the player is healed for 15 health using the heal method
								firstAdventure.playerHeal();
								playerTurn = 1;
								System.out.println("You healed yourself for 15 health");
								firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
								int  monsterAttack = firstAdventure.randomNumber25();
								firstAdventure.playerHealthReduce(monsterAttack);
								firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
								System.out.println("The T-Rex hit you for " + monsterAttack + " damage");
								System.out.println("Your health is " + firstPlayer.getPlayerHealth());
								System.out.println("The T-Rex health is  " + firstAdventure.getMonsterHealth());
							}
							if (firstPlayer.getPlayerHealth() < 1){//if the players health drops below 1, he dies and the game is over
								System.out.println("Game Over");
								
									System.exit(0);
							}
						}
					else if ((input1.compareTo(firstAdventure.attack()) !=0) ||(input1.compareTo(firstAdventure.heal()) !=0)){//catches an incorrect input for attack and heal inputs
						System.out.println("That is an incorrect input");
						
					}
					}
					if (firstAdventure.getMonsterHealth() < 1){//this is the win condition for the monster battle, it sets health to full and itterates to the next piece of code
						System.out.println("Congrats you killed the T-Rex!!!!");
						System.out.println("You regained a piece of your time machine, and your health has been restored");
						firstPlayer.setPlayerHealth(health);
						System.out.println("However, before you advance, you must prove your knowledge of this era. ");	
						playerTurn = 4;
					}				
				}			
			int diffLevelNumber = 0;
			while ((diffLevelNumber < 1 || diffLevelNumber > 3) && playerTurn == 4){//loops the try catch method while the difficutly level entered is not between 1 and 3	
				diffLevelNumber = tryCatch();
			}	
			Eras newEra = new Eras(diffLevelNumber);//creates a new Era superclass object
			Eras jurassicEra = new Jurassic(diffLevelNumber);//creates a new era object for this era
			String jurassicQuestion = jurassicEra.displayQuestion();//gets the question for this era
			while (playerTurn == 5){
				System.out.println(jurassicQuestion);//prints out the question for this era and asks the user for their input
				System.out.println("Please enter an answer(remember: spelling counts!):");
				String jurassicAnswerInput = in.nextLine();
				jurassicAnswerInput = jurassicAnswerInput.toLowerCase();
				String jurassicResponse = jurassicEra.checkQuestion(jurassicAnswerInput);//sets the answer to lowercase and checks the response
				System.out.println(jurassicResponse);
				if (jurassicResponse.compareToIgnoreCase("incorrect")==0){//if the response is incorrect the player loses 25 health and can try again
					System.out.println("You lost 25 health");
					double newHealth = firstAdventure.wrongAnswer(firstPlayer.getPlayerHealth());
					firstPlayer.setPlayerHealth(newHealth);
					if (firstPlayer.getPlayerHealth() < 1){//if the player falls below 1 health they lose
						System.out.println("Game Over");
						System.exit(0);
					}
					else if (firstPlayer.getPlayerHealth() > 1) {//otherwise it prints out their new health
						System.out.println("You now only have " + newHealth + "health");	
						playerTurn = 5;
						
					}	
				}
				if(jurassicResponse.compareToIgnoreCase("correct")==0){//if the response matches the response in the era class the player completes this round and may continue
					System.out.println("Congrats you completed this era!!!!");	
					playerTurn = 7;
					continue;					
				}
				
			}		
			while (playerTurn == 7){//sets the player to the next era after they finished the previous one
			firstPlayer.setPlayerLocation(firstAdventure.getEgyptLocation());
			System.out.println("Hello and welcome to the " + firstAdventure.getEgyptLocation());
			playerTurn =8;
			diffLevelNumber = 0;//resets difficulty level
			}
			// TODO Auto-generated method stub
			while ((diffLevelNumber < 1 || diffLevelNumber > 3) && playerTurn == 8){//loops the try catch method while the difficutly level entered is not between 1 and 3		
				diffLevelNumber = tryCatch();
			}	
			
			Eras egyptEra = new Egypt(diffLevelNumber);//creates a new era object and pulls the question from that subclass
			String egyptQuestion = egyptEra.displayQuestion();
			while (playerTurn == 9){
				System.out.println(egyptQuestion);
				System.out.println("Please enter an answer(remember: spelling counts!):");
				String egyptAnswerInput = in.nextLine();
				egyptAnswerInput = egyptAnswerInput.toLowerCase();
				String egyptResponse = egyptEra.checkQuestion(egyptAnswerInput);
				System.out.println(egyptResponse);
				if (egyptResponse.compareToIgnoreCase("incorrect")==0){
					System.out.println("You lost 25 health");
					double newHealth = firstPlayer.getPlayerHealth() - 25;
					firstPlayer.setPlayerHealth(newHealth);
					if (firstPlayer.getPlayerHealth() < 1){
						System.out.println("Game Over");
						System.exit(0);
					}
					else if (firstPlayer.getPlayerHealth() > 1) {
						System.out.println("You now only have " + newHealth + " health");
						playerTurn = 9;			
					}	

				}
				if(egyptResponse.compareToIgnoreCase("correct")==0){
					playerTurn = 11;
					System.out.println("Congrats you completed the Question");
					System.out.println("You magically regained 15 health!!");
					System.out.println("But you still cant progress, King Tut is blocking your Path!!");
					firstAdventure.playerHeal();
					firstAdventure.resetMonsterHealth();
					firstAdventure.monsterHealthGain(25);
					continue;
					
				}
			}
			
			while (playerTurn ==11){								
				if (firstPlayer.getPlayerHealth() < 0){
						System.out.println("Game Over");	
							System.exit(0);	
					}
					
					playerTurn = 12;
					while (playerTurn == 12)	{//asks the user to input a value, either attack pr heal
						System.out.println("What do you want to do? (attack/heal)");
						String input1 = in.nextLine();
						input1.toLowerCase();					
						if (((input1.compareTo(firstAdventure.attack()) ==0) ||(input1.compareTo(firstAdventure.heal()) ==0)) &&  (playerTurn == 12)){
							
								if (input1.compareTo(firstAdventure.attack()) ==0){//if the player inputs attack then he may choose to use the three attacks
									System.out.println("What do you want to do? (time slash/time flame/time bomb)");
									String input2 = in.nextLine();
									input2.toLowerCase();
									while (playerTurn ==12){
										if ((input2.compareTo(firstAdventure.timeSlash()) ==0)){//each attack iterates the same code but generates different random numbers from the StartAventure Class. It then passes these values back to the player class to store
											int  playerAttack = firstAdventure.randomNumber50();
											System.out.println("You hit King Tut for " + playerAttack + " damage");
											firstAdventure.monsterHealthReduce(playerAttack);	
											int  monsterAttack = firstAdventure.randomNumber25();//the monster gets a turn to attack 
											firstAdventure.playerHealthReduce(monsterAttack);//this reduces the players 
											firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
											System.out.println("King Tuthit you for " + monsterAttack + " damage");
											playerTurn = 11;
											break;
										}
										if ((input2.compareTo(firstAdventure.timeFlame()) == 0)){//code is almost identical here
											int  playerAttack = firstAdventure.randomNumber100();
											System.out.println("You hit King Tut for " + playerAttack + " damage");
											firstAdventure.monsterHealthReduce(playerAttack);	
											int  monsterAttack = firstAdventure.randomNumber25();
											firstAdventure.playerHealthReduce(monsterAttack);
											firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
											System.out.println("King Tut you for " + monsterAttack + " damage");
											playerTurn = 11;
											break;
										}
										if ((input2.compareTo(firstAdventure.timeBomb()) == 0)){//and here
											int  playerAttack = firstAdventure.randomNumber100();
											System.out.println("You hit King Tut for " + playerAttack + " damage");
											firstAdventure.monsterHealthReduce(playerAttack);	
											int  monsterAttack = firstAdventure.randomNumber50();
											firstAdventure.playerHealthReduce(monsterAttack);
											firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
											System.out.println("King Tut hit you for " + monsterAttack + " damage");
											playerTurn = 11;
											break;
										}
										else if ((input2.compareTo(firstAdventure.timeSlash()) !=0) ||(input2.compareTo(firstAdventure.timeFlame()) !=0) || (input2.compareTo(firstAdventure.timeBomb()) !=0)){//this catches an incorrect input by the user
											System.out.println("That is an incorrect input");
											playerTurn = 11;
										}
									}
								System.out.println("Your health is " + firstPlayer.getPlayerHealth());//prints out health information after each attack
								System.out.println("King Tut's health is  " + firstAdventure.getMonsterHealth());
							}
							if (input1.compareTo(firstAdventure.heal()) ==0){//this loop allows the player to heal, but still allows the monster to attack, the player is healed for 15 health using the heal method
								firstAdventure.playerHeal();
								playerTurn = 11;
								System.out.println("You healed yourself for 15 health");
								firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
								int  monsterAttack = firstAdventure.randomNumber25();
								firstAdventure.playerHealthReduce(monsterAttack);
								firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
								System.out.println("King Tut hit you for " + monsterAttack + " damage");
								System.out.println("Your health is " + firstPlayer.getPlayerHealth());
								System.out.println("King Tut's health is  " + firstAdventure.getMonsterHealth());
							}
						}
					else if ((input1.compareTo(firstAdventure.attack()) !=0) ||(input1.compareTo(firstAdventure.heal()) !=0)){//catches an incorrect input for attack and heal inputs
						System.out.println("That is an incorrect input");
						
					}
					}
					if (firstAdventure.getMonsterHealth() < 1){//this is the win condition for the monster battle, it sets health to full and itterates to the next piece of code
						System.out.println("Congrats you killed the King Tut!!!!");
						System.out.println("You regained a piece of your time machine, and your health has been restored");
						firstPlayer.setPlayerHealth(health);
						System.out.println("However, before you advance, you must prove your knowledge of this era. ");	
						playerTurn = 13;
					}				
				}	
				while (playerTurn == 13){//
					firstPlayer.setPlayerLocation(firstAdventure.getRenaissanceLocation());//sets player location to new era and introduces them
					System.out.println("Hello and welcome to the " + firstAdventure.getRenaissanceLocation());
					playerTurn =14;
					diffLevelNumber = 0;
					}
				while ((diffLevelNumber < 1 || diffLevelNumber > 3) && playerTurn == 14){//resets difficulty level and asks them to pic a new one		
						diffLevelNumber = tryCatch();
				}	
				Eras renaissanceEra = new Renaissance(diffLevelNumber);//creates a new era object and gets the question from that subclass
				String renaissanceQuestion = renaissanceEra.displayQuestion();
				while (playerTurn == 15){//asks the question and asks for an input
					System.out.println(renaissanceQuestion);
					System.out.println("Please enter an answer(remember: spelling counts!):");
					String renaissanceAnswerInput = in.nextLine();
					renaissanceAnswerInput = renaissanceAnswerInput.toLowerCase();//sets input to lower case and checks it with the checkQuestion subclass
					String renaissanceResponse = renaissanceEra.checkQuestion(renaissanceAnswerInput);
					System.out.println(renaissanceResponse);
					if (renaissanceResponse.compareToIgnoreCase("incorrect")==0){//if the response is incorrect the player loses 25 health
						System.out.println("You lost 25 health");
						double newHealth = firstAdventure.wrongAnswer(firstPlayer.getPlayerHealth());
						firstPlayer.setPlayerHealth(newHealth);
						if (firstPlayer.getPlayerHealth() < 1){//if they fall below 1 health they lose the game
							System.out.println("Game Over");
							System.exit(0);
						}
						else if (firstPlayer.getPlayerHealth() > 1) {//otherwise it sets their health to the new health
							System.out.println("You now only have " + newHealth + "health");
							
							playerTurn = 15;
							
						}	
					}
					if(renaissanceResponse.compareToIgnoreCase("correct")==0){//if the response is correct the user completes the era and their health is reset to full
						System.out.println("Congrats you completed this era!!!!");	
						firstPlayer.setPlayerHealth(health);
						playerTurn = 16;
											
					}
				
				}
				while (playerTurn == 16){//these loops will eventually allow the user to teleport back to various locations
					firstPlayer.setPlayerLocation(firstAdventure.getIndustrialLocation());//sets player location to new era and introduces them
					System.out.println("Hello and welcome to the " + firstAdventure.getIndustrialLocation());
					playerTurn =17;
					diffLevelNumber = 0;
				}	
				while ((diffLevelNumber < 1 || diffLevelNumber > 3) && playerTurn == 17){//loops the try catch method while the difficulty level entered is not between 1 and 3	
					diffLevelNumber = tryCatch();
				}	
				Eras industrialEra = new Industrial(diffLevelNumber);//creates a new era object for this era
				String industrialQuestion = industrialEra.displayQuestion();//gets the question for this era
				while (playerTurn == 18){
					System.out.println(industrialQuestion);//prints out the question for this era and asks the user for their input
					System.out.println("Please enter an answer(remember: spelling counts!):");
					String industrialAnswerInput = in.nextLine();
					industrialAnswerInput = industrialAnswerInput.toLowerCase();
					String industrialResponse = industrialEra.checkQuestion(industrialAnswerInput);//sets the answer to lowercase and checks the response
					System.out.println(industrialResponse);
					if (industrialResponse.compareToIgnoreCase("incorrect")==0){//if the response is incorrect the player loses 25 health and can try again
						System.out.println("You lost 25 health");
						double newHealth = firstAdventure.wrongAnswer(firstPlayer.getPlayerHealth());
						firstPlayer.setPlayerHealth(newHealth);
						if (firstPlayer.getPlayerHealth() < 1){//if the player falls below 1 health they lose
							System.out.println("Game Over");
							System.exit(0);
						}
						else if (firstPlayer.getPlayerHealth() > 1) {//otherwise it prints out their new health
							System.out.println("You now only have " + newHealth + "health");	
							playerTurn = 18;
							
						}	
					}
					if(industrialResponse.compareToIgnoreCase("correct")==0){//if the response matches the response in the era class the player completes this round and may continue
						System.out.println("Congrats you completed this era!!!!");	
						playerTurn = 19;
						continue;					
					}
				}
				while (playerTurn == 19){//these loops will eventually allow the user to teleport back to various locations
					firstPlayer.setPlayerLocation(firstAdventure.getInformationLocation());//sets player location to new era and introduces them
					System.out.println("Hello and welcome to the " + firstAdventure.getInformationLocation());
					playerTurn =20;
					diffLevelNumber = 0;
				}	
				while ((diffLevelNumber < 1 || diffLevelNumber > 3) && playerTurn == 20){//loops the try catch method while the difficulty level entered is not between 1 and 3	
					diffLevelNumber = tryCatch();
				}	
				Eras informationEra = new Information(diffLevelNumber);//creates a new era object for this era
				String informationQuestion = informationEra.displayQuestion();//gets the question for this era
				while (playerTurn == 21){
					System.out.println(informationQuestion);//prints out the question for this era and asks the user for their input
					System.out.println("Please enter an answer(remember: spelling counts!):");
					String informationAnswerInput = in.nextLine();
					informationAnswerInput = informationAnswerInput.toLowerCase();
					String informationResponse = informationEra.checkQuestion(informationAnswerInput);//sets the answer to lowercase and checks the response
					System.out.println(informationResponse);
					if (informationResponse.compareToIgnoreCase("incorrect")==0){//if the response is incorrect the player loses 25 health and can try again
						System.out.println("You lost 25 health");
						double newHealth = firstAdventure.wrongAnswer(firstPlayer.getPlayerHealth());
						firstPlayer.setPlayerHealth(newHealth);
						if (firstPlayer.getPlayerHealth() < 1){//if the player falls below 1 health they lose
							System.out.println("Game Over");
							System.exit(0);
						}
						else if (firstPlayer.getPlayerHealth() > 1) {//otherwise it prints out their new health
							System.out.println("You now only have " + newHealth + "health");	
							playerTurn = 21;
							
						}	
					}
					if(informationResponse.compareToIgnoreCase("correct")==0){//if the response matches the response in the era class the player completes this round and may continue
						System.out.println("Congrats you completed this question!!!!");	
						System.out.println("OH NO, Theres a robot army attacking you!!!!");
						System.out.println("You dont have time to heal before the attack!!!!");
						firstAdventure.resetMonsterHealth();
						firstAdventure.monsterHealthGain(50);
						playerTurn = 22;
						continue;					
					}
				}
				while (playerTurn ==22){								
					if (firstPlayer.getPlayerHealth() < 0){
							System.out.println("Game Over");	
								System.exit(0);	
						}
						
						playerTurn = 23;
						while (playerTurn == 23)	{//asks the user to input a value, either attack pr heal
							System.out.println("What do you want to do? (attack/heal)");
							String input1 = in.nextLine();
							input1.toLowerCase();					
							if (((input1.compareTo(firstAdventure.attack()) ==0) ||(input1.compareTo(firstAdventure.heal()) ==0)) &&  (playerTurn == 23)){
								
									if (input1.compareTo(firstAdventure.attack()) ==0){//if the player inputs attack then he may choose to use the three attacks
										System.out.println("What do you want to do? (time slash/time flame/time bomb)");
										String input2 = in.nextLine();
										input2.toLowerCase();
										while (playerTurn ==23){
											if ((input2.compareTo(firstAdventure.timeSlash()) ==0)){//each attack iterates the same code but generates different random numbers from the StartAventure Class. It then passes these values back to the player class to store
												int  playerAttack = firstAdventure.randomNumber100();
												System.out.println("You destroyed " + playerAttack + " robots");
												firstAdventure.monsterHealthReduce(playerAttack);	
												int  monsterAttack = firstAdventure.randomNumber50();//the monster gets a turn to attack 
												firstAdventure.playerHealthReduce(monsterAttack);//this reduces the players 
												firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
												System.out.println("The robot army hit you for " + monsterAttack + " damage");
												playerTurn = 22;
												break;
											}
											if ((input2.compareTo(firstAdventure.timeFlame()) == 0)){//code is almost identical here
												int  playerAttack = firstAdventure.randomNumber50();
												System.out.println("You destroyed " + playerAttack + " robots");
												firstAdventure.monsterHealthReduce(playerAttack);	
												int  monsterAttack = firstAdventure.randomNumber25();
												firstAdventure.playerHealthReduce(monsterAttack);
												firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
												System.out.println("The robot army you for " + monsterAttack + " damage");
												playerTurn = 22;
												break;
											}
											if ((input2.compareTo(firstAdventure.timeBomb()) == 0)){//and here
												int  playerAttack = firstAdventure.randomNumber100();
												System.out.println("You destroyed " + playerAttack + " robots");
												firstAdventure.monsterHealthReduce(playerAttack);	
												int  monsterAttack = firstAdventure.randomNumber25();
												firstAdventure.playerHealthReduce(monsterAttack);
												firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
												System.out.println("The robot army hit you for " + monsterAttack + " damage");
												playerTurn = 22;
												break;
											}
											else if ((input2.compareTo(firstAdventure.timeSlash()) !=0) ||(input2.compareTo(firstAdventure.timeFlame()) !=0) || (input2.compareTo(firstAdventure.timeBomb()) !=0)){//this catches an incorrect input by the user
												System.out.println("That is an incorrect input");
												playerTurn = 22;
											}
										}
									System.out.println("Your health is " + firstPlayer.getPlayerHealth());//prints out health information after each attack
									System.out.println(" The robot army has   " + firstAdventure.getMonsterHealth());
								}
								if (input1.compareTo(firstAdventure.heal()) ==0){//this loop allows the player to heal, but still allows the monster to attack, the player is healed for 15 health using the heal method
									firstAdventure.playerHeal();
									playerTurn = 22;
									System.out.println("You healed yourself for 15 health");
									firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
									int  monsterAttack = firstAdventure.randomNumber25();
									firstAdventure.playerHealthReduce(monsterAttack);
									firstPlayer.setPlayerHealth(firstAdventure.getPlayerHealth());
									System.out.println("The robot army hit you for " + monsterAttack + " damage");
									System.out.println("Your health is " + firstPlayer.getPlayerHealth());
									System.out.println("The robot army health is  " + firstAdventure.getMonsterHealth());
								}
							}
						else if ((input1.compareTo(firstAdventure.attack()) !=0) ||(input1.compareTo(firstAdventure.heal()) !=0)){//catches an incorrect input for attack and heal inputs
							System.out.println("That is an incorrect input");
							
						}
						}
						if (firstAdventure.getMonsterHealth() < 1){//this is the win condition for the monster battle, it sets health to full and itterates to the next piece of code
							System.out.println("Congrats you destroyed the robot army!!!!");
							System.out.println("You regained all the pieces of your time machine and made it back to your time era!! Congratulations, "+ firstPlayer.getPlayerName() + " you won!");
							firstPlayer.setPlayerHealth(health);	
							playerTurn = 24;
						}				
					}			
			while (playerTurn == 24){//win state which then asks if the player wants to play again 
				System.out.println("The cake is a lie");
				System.out.println("Do you want to play again? (y) (n)");
				String playAgain = in.nextLine();
				if (playAgain.compareToIgnoreCase("y") == 0){// if thet user says yes than it resets playerTurn
					playerTurn = 0;
			
				}
				else if (playAgain.compareToIgnoreCase("n") == 0){//otherwise it exits the vm
					System.exit(0);
				}
				
			}
	
			//end
		}
		in.close();//close scanner
			
	}
		
	

	
	 static int tryCatch(){//method to use as a try catch for difficulty input in eras. I TRIED to use professor Matos code here but it was not looping correctly and closing the scanner in this method causes the program to crashing giving me a no such element exception. 
		 Scanner in = new Scanner(System.in);
		 int diffLevelNumber = 0;
		 while ((diffLevelNumber < 1 || diffLevelNumber > 3)){	//which the input is not between 1 and 3 it asks the user for an input	
				try {   		
				   System.out.println("Please enter the difficulty level for this Era (1, 2 or 3): ");   
				   String diffLevel = in.nextLine();//takes in the string and parses it as an integer 
				   diffLevelNumber = Integer.parseInt(diffLevel);
				   
				   if (diffLevelNumber < 1 || diffLevelNumber > 3){//if its not between 1 and 3 it throws an error
						System.err.println("That is not a valid number");
					}
				   else if (diffLevelNumber > 0 && diffLevelNumber < 4){//otherwise it sets the difficulty level and adds one to the player turn
					   System.out.println("You choose difficutly level  " + diffLevelNumber);
					   playerTurn++;
					   continue;
				   }
				}
				catch(Exception a){  //catches non integer inputs
					System.err.println("That is not a valid number"); 
				}
			
		}
		return diffLevelNumber;//returns the input
	  
	
	}		

	

}
	
	
	
	
