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
	
	protected TransitionFunction function;
	
	protected State currentState;
	protected State start;
	
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
		
		var configuration = getCurrentConfiguration(currentState, word, currentCellIndex);
		showCurrentConfiguration(configuration);
		
		while(true) {			
			var domainList = nextDomainList(currentState, getInputCell());
			var transition = getTransition(domainList);
			
			if(transition == null) {
				if(terminate()) return returnResult();
				else {
					throw new RuntimeException("Der Automat darf noch nicht terminieren");
				}
			}
			
			processFunction(transition.getDomain(), transition.getImage());
			currentState = transition.getImage().getState();
			
			configuration = getCurrentConfiguration(currentState, word, currentCellIndex);
			showCurrentConfiguration(configuration);
		}
	}
	
	protected void initialize() {
		currentState = start;
		currentCellIndex = 0;
		Configuration.intitialStepCount();
	}
	
	protected boolean terminate() {
		return readWord();
	}
	
	protected boolean accepted() {
		return readWord() && currentState.isAcceptedEndState();
	}
	
	private boolean readWord() {
		return currentCellIndex >= word.length();
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
		return accepted() ? "Das Wort ist Element der Sprache." : "Das Wort ist nicht Element der Sprache.";
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
	
	protected void showCurrentConfiguration(Configuration configuration) {
		System.out.println(configuration);
	}
}
