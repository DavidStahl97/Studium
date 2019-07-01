package de.thm.machine.framework.tupleElements;

public class Transition {
	
	private Image image;
	private Domain domain;
	
	public Transition(Domain domain, Image image) {
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
	
	@Override
	public String toString() {
		return domain.toString() + " --> " + image.toString();
	}
	
}
