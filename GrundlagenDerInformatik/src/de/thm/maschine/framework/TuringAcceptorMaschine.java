package de.thm.maschine.framework;

import java.util.List;

import de.thm.maschine.framework.configuration.Configuration;
import de.thm.maschine.framework.configuration.TuringConfiguration;
import de.thm.maschine.framework.tupleElements.Image;
import de.thm.maschine.framework.tupleElements.ReadDirection;
import de.thm.maschine.framework.tupleElements.State;
import de.thm.maschine.framework.tupleElements.TransitionFunction;
import de.thm.maschine.framework.tupleElements.TuringImage;

public class TuringAcceptorMaschine extends FiniteStateMaschine {

	public TuringAcceptorMaschine(List<TransitionFunction> functions, State start) {
		super(functions, start);
	}
	
	@Override
	protected void processImage(Image image) {
		var turingImage = (TuringImage)image;
		
		writeOutput(turingImage.getOutput());
		setNextCellIndex(turingImage.getReadDirection());
	}
	
	@Override
	protected Character getInputCell() {
		if(currentCellIndex < 0) {
			word = Util.SPACE + word;
			currentCellIndex = 0;
			return Util.SPACE;
		}
		else if(currentCellIndex >= word.length()) {
			word += Util.SPACE;
			return Util.SPACE;
		}
		else {
			return word.charAt(currentCellIndex);
		}
	}
	
	@Override
	protected Configuration getCurrentConfiguration(State state, String word, int cellIndex) {
		return new TuringConfiguration(state, word, cellIndex);
	}
	
	private void setNextCellIndex(ReadDirection direction) {
		switch(direction) {
			case RIGHT:
				currentCellIndex++;
				break;
			case LEFT:
				currentCellIndex--;
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
