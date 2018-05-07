//Name: Chad Butler, Christine Tully, Alyssa Ramella, Kiran Arshi, Zahra Faruqi
// This creates the Jurassic class
import java.util.ArrayList;
public class Jurassic extends Eras {
	
	// declare instance variables
	private int difficultyLevel;
	// default constructor sets difficultyLevel
	public Jurassic() { 
	
		difficultyLevel = 1; 
	}
	/**
	 * Constructor assigns value of difflevel to difficulty level 
	 * @param diffLevel
	 */
	public Jurassic(int diffLevel) { 
		
		difficultyLevel = diffLevel;
		
	}
// display questions to be answered by user based on difficulty level
	public String displayQuestion() { 
		ArrayList<String> questions = new ArrayList();
		questions.add("True or false? Birds evolved from dinosaurs.");
		questions.add("What was The Flintstones’ pet dinosaur called?");
		questions.add("Who was Jurassic Park written by?");
		difficultyLevel = difficultyLevel-1; 
		
		return questions.get(difficultyLevel);
	}
/** 
 * Method receives input and checks if user is correct
 * @param input
 * @return "correct" or "incorrect" 
 */
	public String checkQuestion(String input) {
		ArrayList<String> answers = new ArrayList();
		answers.add("True");
		answers.add("Dino");
		answers.add("Michael Christon");
		String qAnswer = answers.get(difficultyLevel); 
		
		if (input.compareToIgnoreCase(qAnswer)==0) { 
			return "Correct";				
		} else { 
			return "incorrect"; 
		}  

	 // can use this in main method to see if user can progress
	}

}