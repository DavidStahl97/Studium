package formaleSprache;

public class DeterministicAutomat extends Automat {
	
	private enum State { A, B }
	
	public boolean isInLanguage(String word) {
		
		if(word.length() < 2) return false;

		char[] characters = word.toCharArray();
		
		if(characters[0] != 'a' || characters[characters.length - 1] != 'b') 
			return false;		
		
		State state = State.A;
		
		for(int i = 1; i < characters.length - 1; i++) {
			
			if(state == State.A) {
				if(characters[i] == 'b') 
					state = State.B;
			}
			else if(characters[i] == 'a') {
				return false;
			}
			
		}
		
		return true;
	}
	
}
