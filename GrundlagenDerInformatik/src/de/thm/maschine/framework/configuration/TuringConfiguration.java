package de.thm.maschine.framework.configuration;

import java.util.ArrayList;
import java.util.List;

import de.thm.maschine.framework.Util;
import de.thm.maschine.framework.tupleElements.State;

public class TuringConfiguration extends Configuration {

	public TuringConfiguration(State state, String word, int cellIndex) {
		super(state, word, cellIndex);
	}
	
	@Override
	protected List<String> captureCurrentConfiguration(State state, String word, int cellIndex) {
		var array = new ArrayList<String>();
		array.add(getLeftPart(word, cellIndex));
		array.add(state.toString());
		array.add(getRightPart(word, cellIndex));
		return array;
	}
	
	private String getLeftPart(String word, int cellIndex) {
		if(cellIndex == 0) return Character.toString(Util.EMPTY);
		return word.substring(0, cellIndex);
	}
	
	private String getRightPart(String word, int cellIndex) {
		return word.substring(cellIndex, word.length());
	}
}
