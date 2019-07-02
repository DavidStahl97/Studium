package de.thm.machine.framework.machines.nondeterministic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.configuration.PushdownConfiguration;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.Image;
import de.thm.machine.framework.tupleElements.PushdownDomain;
import de.thm.machine.framework.tupleElements.PushdownImage;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.TransitionFunction;

public class NDPushdownAutomaton extends NDFiniteStateMachine {

	public NDPushdownAutomaton(TransitionFunction function, State start) {
		super(function, start);
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		currentRelation = new ConfigurationTransitionRelation(null, getStartConfiguration());
	}
	
	@Override
	protected List<ConfigurationTransitionRelation> getRelations(State state, String word, int cellIndex) {
		var stack = ((PushdownConfiguration)currentRelation.getConfiguration()).getStack();
		
		var popValue = stack.isEmpty() ? null : stack.pop();
		List<Domain> domain = Arrays.asList(
			new PushdownDomain(state, getInputCell(), popValue),
			new PushdownDomain(state, null, popValue)
		);
		
		var relations = new ArrayList<ConfigurationTransitionRelation>();
		var transitions = function.getTransitions(domain);
		for(var t : transitions) {
			@SuppressWarnings("unchecked")
			var clonedStack = (Stack<Character>)stack.clone(); 
			var configuration = new PushdownConfiguration(state, word, cellIndex, clonedStack);
			
			relations.add(new ConfigurationTransitionRelation(t, configuration));
		}
		
		return relations;
	}
	
	@Override
	protected void processFunction(Domain domain, Image image) {
		super.processFunction(domain, image);
		
		var pushdownImage = (PushdownImage)image;
		var pushValues = pushdownImage.getPushValues();
		var configuration = (PushdownConfiguration) currentRelation.getConfiguration();
		var stack = configuration.getStack();
		
		if(pushValues != null) {
			for(var value : pushValues) {
				stack.push(value);
			}
		}
	}
	
	@Override
	protected Configuration getStartConfiguration() {
		return new PushdownConfiguration(start, word, 0, new Stack<Character>());
	}
}
