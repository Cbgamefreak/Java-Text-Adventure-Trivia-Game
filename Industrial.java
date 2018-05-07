//Name: Chad Butler, Christine Tully, Alyssa Ramella, Kiran Arshi, Zahra Faruqi
// This creates the Industrial class
import java.util.ArrayList;
public class Industrial extends Eras {//subclass of eras
	
	
	private int difficultyLevel;
	
	public Industrial() { 
	
		difficultyLevel = 1; 
	}
	/**
	 * Constructor assigns value of difflevel to difficulty level 
	 * @param diffLevel
	 */
	
	public Industrial(int diffLevel) { 
		
		difficultyLevel = diffLevel;
		
	}
	// display questions to be answered by user based on difficulty level
	public String displayQuestion() { 
		ArrayList<String> questions = new ArrayList();
		questions.add("The industrial revolution is said to have started in what country? ");
		questions.add("Who was the inventor of the cotton gin?");
		questions.add("What state did orville wright fly the first plane?");
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
		answers.add("England");
		answers.add("Eli Whitney");
		answers.add("North Carolina");
		String qAnswer = answers.get(difficultyLevel); 
		
		if (input.compareToIgnoreCase(qAnswer)==0) { 
			return "Correct";				
		} else { 
			return "incorrect"; 
		}  

	 // can use this in main method to see if user can progress
	}

}