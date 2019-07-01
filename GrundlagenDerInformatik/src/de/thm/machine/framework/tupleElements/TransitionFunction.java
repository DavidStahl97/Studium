package de.thm.machine.framework.tupleElements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransitionFunction {
	
	private List<Transition> elements;
	
	public TransitionFunction() {
		elements = new ArrayList<Transition>();
	}
	
	public void add(Domain domain, Image image) {
		elements.add(new Transition(domain, image));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public List<Transition> getImages(List<Domain> domain) {
		return elements.stream()
				       .filter(e -> domain.contains(e))
				       .collect(Collectors.toList());
	}

}