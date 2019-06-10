package de.thm.algo.searching.hashing;

import de.thm.algo.searching.common.Element;

/**
 * A closed hash table implementation that uses linear probing.
 */
public class LinearProbingHashTable extends AbstractHashTable {
	
	private final Element[] table;

	/**
	 * @param expectedNumberOfElements number of elements that are presumably inserted into this data structure
	 */
	public LinearProbingHashTable(int expectedNumberOfElements) {
		// aim for a fill ratio of 50%
		super(2 * expectedNumberOfElements);
		table = new Element[getTableSize()];
	}

	@Override
	public void insert(Element e) {
		table[probe(e.toString())] = e;
	}

	@Override
	public Element find(String id) {
		return table[probe(id)];
	}
	
	private int probe(String id) {
		int index = hash(id);
		while ((table[index] != null) && (table[index].compareTo(id) != 0)) index = (index + 1) % getTableSize();
		return index;
	}

}
