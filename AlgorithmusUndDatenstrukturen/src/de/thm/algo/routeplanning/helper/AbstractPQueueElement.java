package de.thm.algo.routeplanning.helper;

/**
 * Abstract base class of any element that should be stored in a PQueue.
 * Remembers the index of an element within the data structure in order to support the decreaseKey-operation.
 * Furthermore, ensures that comparisons are suported.
 */
public abstract class AbstractPQueueElement<E> implements Comparable<E> {
	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}	
}
