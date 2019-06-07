package formaleSprache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Kellerautomat extends Automat {
	
	private enum State { A, B };
	private enum KellerAlphabet { KLAMMER }
	
	private final static List<Character> OPERATIONS = new ArrayList<Character>(Arrays.asList(new Character[]{
			'+', '-', '*', '/' 
		}));
	
	private final static List<Character> NUMBERS = new ArrayList<Character>(Arrays.asList(new Character[] {
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
		}));
	
	private final static char KLAMMER_AUF = '(';
	private final static char KLAMMER_ZU = ')';
	
	private final Stack<KellerAlphabet> stack = new Stack<KellerAlphabet>();
	
	@Override
	public boolean isInLanguage(String word) {
		
		State state = State.A;
		
		char[] characters = word.toCharArray();
		
		for(char c : characters) {
			
			if(state == State.B) {
				if(!OPERATIONS.contains(c)) {
					if(c == KLAMMER_AUF || c == KLAMMER_ZU) {
						return false;
					}
					
					state = State.A;
				} else {
					return false;
				}
			}
			
			if(OPERATIONS.contains(c)) {
				state = State.B;
				continue;
			}
			
			if(c == KLAMMER_AUF) {
				stack.push(KellerAlphabet.KLAMMER);
				continue;
			}
			
			if(c == KLAMMER_ZU) {
				if(stack.empty()) return false;
				
				stack.pop();
				continue;
			}
			
			if(NUMBERS.contains(c) == false) return false; 
		}
		
		return stack.empty();		
	}
	
	
	
}
