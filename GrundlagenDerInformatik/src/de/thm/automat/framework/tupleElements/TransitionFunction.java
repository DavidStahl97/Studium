package de.thm.automat.framework.tupleElements;

public class TransitionFunction {
	
	private Image image;
	private Domain domain;
	
	public TransitionFunction(Domain domain, Image image) {
		this.image = image;
		this.domain = domain;
	}
	
	public TransitionFunction(State state, char input, State nextState) {
		this.domain = new Domain(state, input);
		this.image = new Image(nextState);
	}

	public Image getImage() {
		return image;
	}

	public Domain getDomain() {
		return domain;
	}
	
	@Override
	public boolean equals(Object obj) {
		var domain = (Domain)obj;
		return this.domain.equals(domain);
	}
	
}
