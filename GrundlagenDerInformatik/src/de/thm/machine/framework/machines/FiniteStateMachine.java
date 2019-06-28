package de.thm.machine.framework.machines;

import java.util.List;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.Image;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class FiniteStateMachine implements IMachine {
	
	private List<TransitionFunction> functions;
	
	private State currentState;
	private State start;
	
	protected int currentCellIndex;
	protected String word;
	
	public FiniteStateMachine(List<TransitionFunction> functions, State start) {
		this.functions = functions;
		this.start = start;
	}
	
	@Override
	public String start(String word) {
		this.word = word;
		initialize();
		
		showCurrentConfiguration();
		
		while(true) {			
			var domain = nextDomain(currentState, getInputCell());
			var image = getImage(domain);
			
			if(image == null) return returnResult();
			
			processFunction(domain, image);
			currentState = image.getState();
			
			showCurrentConfiguration();
		}
	}
	
	protected void initialize() {
		currentState = start;
		currentCellIndex = 0;
		Configuration.intitialStepCount();
	}
	
	protected Domain nextDomain(State currentState, Character cell) {
		return new Domain(currentState, cell);
	}
	
	protected void processFunction(Domain domain, Image image) {
		if(domain.getInput() != null)
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
