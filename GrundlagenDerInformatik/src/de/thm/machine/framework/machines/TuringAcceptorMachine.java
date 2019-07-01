package de.thm.machine.framework.machines;

import java.util.List;

import de.thm.machine.framework.Util;
import de.thm.machine.framework.configuration.Configuration;
import de.thm.machine.framework.configuration.TuringConfiguration;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.Image;
import de.thm.machine.framework.tupleElements.ReadDirection;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.Transition;
import de.thm.machine.framework.tupleElements.TransitionFunction;
import de.thm.machine.framework.tupleElements.TuringImage;

public class TuringAcceptorMachine extends FiniteStateMachine {

	public TuringAcceptorMachine(TransitionFunction function, State start) {
		super(function, start);
	}
	
	@Override
	protected void processFunction(Domain domain, Image image) {
		var turingImage = (TuringImage)image;
		
		writeOutput(turingImage.getOutput());
		setNextCellIndex(turingImage.getReadDirection());
	}
	
	@Override
	protected Configuration getCurrentConfiguration(State state, String word, int cellIndex) {
		return new TuringConfiguration(state, word, cellIndex);
	}
	
	@Override
	protected boolean terminate() {
		return true;
	}
	
	private void setNextCellIndex(ReadDirection direction) {
		switch(direction) {
			
			case RIGHT:
				currentCellIndex++;
				if(currentCellIndex >= word.length()) {
					word += Util.SPACE;
				}
				break;
				
			case LEFT:
				currentCellIndex--;
				if(currentCellIndex < 0) {
					word = Util.SPACE + word;
					currentCellIndex = 0;
				}
				break;
				
			default:
				break;
		}
	}
	
	private void writeOutput(Character output) {
		var builder = new StringBuilder(word);
		builder.setCharAt(currentCellIndex, output);
		word = builder.toString();
	}

}
