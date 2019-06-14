package de.thm.automat.framework;

import java.util.List;

import de.thm.automat.framework.tupleElements.Domain;
import de.thm.automat.framework.tupleElements.Image;
import de.thm.automat.framework.tupleElements.State;
import de.thm.automat.framework.tupleElements.TransitionFunction;

public class FiniteStateMaschine {
	
	private List<TransitionFunction> functions;
	
	private State currentState;
	private State start;
	
	private int currentCellIndex;
	private String input;
	
	public FiniteStateMaschine(List<TransitionFunction> functions, State start) {
		this.functions = functions;
		this.start = start;
	}
	
	public String start(String input) {
		currentState = start;
		currentCellIndex = 0;
		this.input = input;
		
		printConfiguration();
		
		while(true) {			
			var domain = nextDomain(currentState, getInputCell());
			var image = getImage(domain);
			
			if(image == null) return returnResult();
			
			currentState = image.getState();
			processImage(image);
			
			printConfiguration();
		}
	}
	
	protected Domain nextDomain(State currentState, Character cell) {
		return new Domain(currentState, cell);
	}
	
	protected void processImage(Image image) {
		currentCellIndex++;
	}
	
	protected String returnResult() {
		return currentState.isAcceptedEndState() ? "Das Wort ist Element der Sprache." : "Das Wort ist nicht Element der Sprache.";
	}
	
	protected Character getInputCell() {
		if(currentCellIndex >= input.length()) return null;
		return input.charAt(currentCellIndex);
	}
	
	protected void printConfiguration() {
		var relation = "(" + currentState + ", " + input.substring(currentCellIndex) + ") ->";
		System.out.println(relation);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private Image getImage(Domain domain) {	
		for(var f : functions) {
			if(f.equals(domain)) return f.getImage();
		}
		
		return null;
	}
}
