package de.thm.algo.searching.common;

public interface SearchDataStructure {
	/** 
	 * Inserts the given element or a shallow copy of the given element.
	 */
	void insert(Element e);
	
	/** 
	 * Returns the contained Element with the given ID or
	 * null if no matching Element has been found.
	 */
	Element find(String id);
}
