//Name: Chad Butler, Christine Tully, Alyssa Ramella, Kiran Arshi, Zahra Faruqi
// This creates the Information class
import java.util.ArrayList;
public class Information extends Eras{//subclass of eras
	
	
	private int difficultyLevel;
	
	public Information() { 
	
		difficultyLevel = 1; 
	}
	/**
	 * Constructor assigns value of difflevel to difficulty level 
	 * @param diffLevel
	 */
	public Information(int diffLevel) { 
		
		difficultyLevel = diffLevel;
		
	}
	// display questions to be answered by user based on difficulty level
	public String displayQuestion() { 
		ArrayList<String> questions = new ArrayList();
		questions.add("What was the main new form of communication created by the internet?");
		questions.add("What type of websites are the most popular on the internet? ");
		questions.add("True or false- if facebook was a country it would be the third largest in the world");
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
		answers.add("Email");
		answers.add("Social Media");
		answers.add("True");
		String qAnswer = answers.get(difficultyLevel); 
		
		if (input.compareToIgnoreCase(qAnswer)==0) { 
			return "Correct";				
		} else { 
			return "incorrect"; 
		}  

	 // can use this in main method to see if user can progress
	}

}