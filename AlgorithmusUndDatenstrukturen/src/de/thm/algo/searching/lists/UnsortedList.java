package de.thm.algo.searching.lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.thm.algo.searching.common.Element;
import de.thm.algo.searching.common.IterableSearchDataStructure;

/**
 * Represents an unsorted list of elements.
 * Note that insert operations are fast, namely O(1),
 * while find operations are slow, namely O(n).
 */
public class UnsortedList implements IterableSearchDataStructure {

	protected final List<Element> list;
	
	public UnsortedList() {
		list = new ArrayList<>();
	}

	@Override
	public void insert(Element e) {
		list.add(e);
	}

	@Override
	public Element find(String id) {
		// linear search
		for (Element e : list) {
			if (e.compareTo(id) == 0) return e;
		}
		return null;
	}

	@Override
	public Iterator<Element> iterator() {
		return list.iterator();
	}	

}
