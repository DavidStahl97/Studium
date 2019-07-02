package de.thm.machine.framework.machines;

import java.util.Arrays;
import java.util.List;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.Image;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.TransitionFunction;
import de.thm.machine.framework.tupleElements.Transition;

public class FiniteStateMachine implements IMachine {
	
	private TransitionFunction function;
	
	private State currentState;
	private State start;
	
	protected int currentCellIndex;
	protected String word;
	
	public FiniteStateMachine(TransitionFunction function, State start) {
		this.function = function;
		this.start = start;
	}
	
	@Override
	public String start(String word) {
		this.word = word;
		initialize();
		
		showCurrentConfiguration();
		
		while(true) {			
			var domainList = nextDomainList(currentState, getInputCell());
			var transition = getTransition(domainList);
			
			if(transition == null) {
				if(terminate()) return returnResult();
				else continue;
			}
			
			processFunction(transition.getDomain(), transition.getImage());
			currentState = transition.getImage().getState();
			
			showCurrentConfiguration();
		}
	}
	
	protected void initialize() {
		currentState = start;
		currentCellIndex = 0;
		Configuration.intitialStepCount();
	}
	
	protected boolean terminate() {
		if(currentCellIndex >= word.length()) {
			return true;
		}
		
		throw new RuntimeException("Der Automat darf erst dann terminieren, wenn das Wort komplett gelesen wurde.");
	}
	
	protected List<Domain> nextDomainList(State currentState, Character cell) {
		return Arrays.asList(
			new Domain(currentState, cell),
			// lambda transition
			new Domain(currentState, null)
		);
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
	
	protected Transition getTransition(List<Domain> domain) {
		var elments = function.getTransitions(domain);
		
		if(elments.size() > 1)
			throw new RuntimeException("Es darf höchstens ein Folgezustand geben.");
		
		if(elments.size() == 1)
			return elments.get(0);
		
		return null;
	}
	
	private void showCurrentConfiguration() {
		System.out.println(getCurrentConfiguration(currentState, word, currentCellIndex));
	}
}
