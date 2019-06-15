package de.thm.machine.framework.machines;

import java.util.List;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.Image;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class FiniteStateMachine {
	
	private List<TransitionFunction> functions;
	
	private State currentState;
	private State start;
	
	protected int currentCellIndex;
	protected String word;
	
	public FiniteStateMachine(List<TransitionFunction> functions, State start) {
		this.functions = functions;
		this.start = start;
	}
	
	public String start(String word) {
		currentState = start;
		currentCellIndex = 0;
		this.word = word;
		Configuration.intitialStepCount();
		
		showCurrentConfiguration();
		
		while(true) {			
			var domain = nextDomain(currentState, getInputCell());
			var image = getImage(domain);
			
			if(image == null) return returnResult();
			
			processFunction(image);
			currentState = image.getState();
			
			showCurrentConfiguration();
		}
	}
	
	protected Domain nextDomain(State currentState, Character cell) {
		return new Domain(currentState, cell);
	}
	
	protected void processFunction(Image image) {
		currentCellIndex++;
	}
	
	protected String returnResult() {
		return currentState.isAcceptedEndState() ? "Das Wort ist Element der Sprache." : "Das Wort ist nicht Element der Sprache.";
	}
	
	protected Character getInputCell() {
		if(currentCellIndex >= word.length()) return null;
		return word.charAt(currentCellIndex);
	}
	
	protected Configuration getCurrentConfiguration(State state, String word, int cellIndex) {
		return new Configuration(state, word, cellIndex);
	}
	
	private void showCurrentConfiguration() {
		System.out.println(getCurrentConfiguration(currentState, word, currentCellIndex));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private Image getImage(Domain domain) {	
		for(var f : functions) {
			if(f.equals(domain)) return f.getImage();
		}
		
		return null;
	}
}
