//Name: Chad Butler, Christine Tully, Alyssa Ramella, Kiran Arshi, Zahra Faruqi
// This creates the Jurassic class
import java.util.ArrayList;
public class Egypt extends Eras{
	
	
	private int difficultyLevel;
	
	public Egypt() { 
	
		difficultyLevel = 1; 
	}
	/**
	 * Constructor assigns value of difflevel to difficulty level 
	 * @param diffLevel
	 */
	
	public Egypt(int diffLevel) { 
		
		difficultyLevel = diffLevel;
		
	}
	// display questions to be answered by user based on difficulty level
	public String displayQuestion() { 
		ArrayList<String> questions = new ArrayList();
		questions.add("What was an Egyptian king called?");
		questions.add("Much of egypt is a desert, but which desert is it?");
		questions.add("The Christian cross was developed from what ancient Egyptian symbol?");
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
		answers.add("Pharoah");
		answers.add("Sahara");
		answers.add("Ankh");
		String qAnswer = answers.get(difficultyLevel); 
		
		if (input.compareToIgnoreCase(qAnswer)==0) { 
			return "Correct";				
		} else { 
			return "incorrect"; 
		}  

	 // can use this in main method to see if user can progress
	}

}