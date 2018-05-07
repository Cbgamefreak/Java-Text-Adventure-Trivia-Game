import java.util.ArrayList;
//superclass for eras
public class Eras {

	private int difficultyLevel;
	
	public Eras() { //basic constructors to be used in subclass methods
	
		difficultyLevel = 1; 
	}
	
	public Eras(int diffLevel) { 
		
		difficultyLevel = diffLevel;
		
	}
	public String displayQuestion() { //subclass methods to be overridden
		
		
		return "Question";
	}
	
	public String checkQuestion(String input) {
		String qAnswer = "Answer";
		if (input.compareToIgnoreCase(qAnswer)==0) { 
			return "Correct";				
		} else { 
			return "incorrect"; 
		}  

	 // can use this in main method to see if user can progress
	}
}
