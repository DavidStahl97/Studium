package de.thm.algo.searching.hashing;

import de.thm.algo.searching.common.Element;

/**
 * An open hash table implementation that uses linked lists.
 */
public class LinkedListHashTable extends AbstractHashTable {
	
	private final LinkedNode[] table;

	/**
	 * @param expectedNumberOfElements number of elements that are presumably inserted into this data structure
	 */
	public LinkedListHashTable(int expectedNumberOfElements) {
		super((int)(1.4 * expectedNumberOfElements)); // cp. HashMapAdapter
		table = new LinkedNode[getTableSize()];
	}	
	
	@Override
	public void insert(Element e) {
		final LinkedNode node = new LinkedNode(e);
		final int h = hash(node.toString());
		node.setNext(table[h]);
		table[h] = node;
	}

	@Override
	public Element find(String id) {
		final int h = hash(id);
		LinkedNode current = table[h];
		while ((current != null) && (current.compareTo(id) != 0)) current = current.getNext();
		return current;
	}




	/** Represents a node in a linked list within a hash table. */
	private static class LinkedNode extends Element {
		private LinkedNode next;

		public LinkedNode(String id) {
			super(id);
		}

		public LinkedNode(Element e) {
			super(e);
		}

		public void setNext(LinkedNode next) {
			this.next = next;
		}

		public LinkedNode getNext() {
			return next;
		}
	}

}
