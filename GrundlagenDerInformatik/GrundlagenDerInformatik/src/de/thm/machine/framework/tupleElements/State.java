package de.thm.machine.framework.tupleElements;

public class State {
	
	private String name;
	private boolean acceptedEndState;
	
	public State(String name, boolean acceptedEndState) {
		this.name = name;
		this.acceptedEndState = acceptedEndState;
	}
	
	public State(String name) {
		this.name = name;
		this.acceptedEndState = false;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isAcceptedEndState() {
		return acceptedEndState;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		var state = (State)obj;
		return this.name == state.name;
	}
	
}
