//Name: Chad Butler, Christine Tully, Alyssa Ramella, Kiran Arshi, Zahra Faruqi
// This creates the Renaissance class
import java.util.ArrayList;
public class Renaissance extends Eras {//subclass of eras
	
	
	private int difficultyLevel;
	
	public Renaissance() { 
	
		difficultyLevel = 1; 
	}
	
	/**
	 * Constructor assigns value of difflevel to difficulty level 
	 * @param diffLevel
	 */
	
	public Renaissance(int diffLevel) { 
		
		difficultyLevel = diffLevel;
		
	}
	// display questions to be answered by user based on difficulty level
	public String displayQuestion() { 
		ArrayList<String> questions = new ArrayList();
		questions.add("Who painted the sistine chapel?");
		questions.add("Whose 95 theses started the Reformation? ");
		questions.add("Which family became the greatest patrons of the arts during the Renaissance?");
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
		answers.add("Michael Angelo");
		answers.add("Martin Luther");
		answers.add("Medici Family");
		String qAnswer = answers.get(difficultyLevel); 
		
		if (input.compareToIgnoreCase(qAnswer)==0) { 
			return "Correct";				
		} else { 
			return "incorrect"; 
		}  

	 // can use this in main method to see if user can progress
	}

}