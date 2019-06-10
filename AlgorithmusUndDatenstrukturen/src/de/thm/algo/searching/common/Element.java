package de.thm.algo.searching.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an element that can be inserted into search data structures.
 * The key of the element is its String ID. Furthermore, extra data can be
 * stored in a List of String objects.
 */
public class Element implements Comparable<String> {
	
	private final String id;
	private final List<String> extras;

	public Element(String id) {
		this.id = id;
		this.extras = new ArrayList<>();
	}
	
	/** Creates a SHALLOW copy of the given Element. */
	public Element(Element e) {
		this.id = e.id;
		this.extras = e.extras;
	}

	@Override
	public String toString() {
		return id;
	}
	
	@Override
	public int compareTo(String other) {
		return id.compareTo(other);
	}
	
	public void addExtra(String extra) {
		extras.add(extra);
	}
	
	/** Returns all extra data (separated by commas) as a single String. */
	public String getAllExtras() {
		return String.join(", ", extras);
	}
	
	/** Returns the total number of extra entries and the first three ones. */
	public String getFirstExtras() {		
		return "#extras = " 
				+ extras.size() 
				+ " (" 
				+ String.join(", ", extras.subList(0, Math.min(3, extras.size()))) 
				+ ")";
	}

}
