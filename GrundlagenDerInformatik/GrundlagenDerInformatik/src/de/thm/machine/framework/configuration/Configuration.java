package de.thm.machine.framework.configuration;

import java.util.ArrayList;
import java.util.List;

import de.thm.machine.framework.Util;
import de.thm.machine.framework.tupleElements.State;

public class Configuration {
	
	private static int STEP;
	
	protected State state;
	protected String word;
	protected int cellIndex;
	
	public Configuration(State state, String word, int cellIndex) {
		this.state = state;
		this.word = word;
		this.cellIndex = cellIndex;
	}
	
	public int getCellIndex() {
		return cellIndex;
	}
	
	public State getState() {
		return state;
	}
	
	protected List<String> captureCurrentConfiguration(State state, String word, int cellIndex) {
		var array = new ArrayList<String>();	
		array.add(state.toString());
		array.add(getUpcommingInput(word, cellIndex));		
		return array;
	}
	
	private String getUpcommingInput(String word, int cellIndex) {
		var input = word.substring(cellIndex);
		return input.isEmpty() ? Character.toString(Util.EMPTY) : input;
	}
	
	@Override
	public String toString() {
		var parameters = captureCurrentConfiguration(state, word, cellIndex);
		var string = STEP + ". " + Util.toTupleString(parameters.toArray());
		STEP++;
		return string;
	}
	
	public static void intitialStepCount() {
		STEP = 1;
	}
	
	public static int getStepCount() {
		return STEP;
	}
}
