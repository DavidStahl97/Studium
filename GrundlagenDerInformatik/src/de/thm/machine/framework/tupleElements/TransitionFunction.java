package de.thm.machine.framework.tupleElements;

public class TransitionFunction {
	
	private Image image;
	private Domain domain;
	
	public TransitionFunction(Domain domain, Image image) {
		this.image = image;
		this.domain = domain;
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
