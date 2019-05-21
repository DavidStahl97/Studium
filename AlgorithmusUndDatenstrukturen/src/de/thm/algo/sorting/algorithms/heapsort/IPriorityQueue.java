package de.thm.algo.sorting.algorithms.heapsort;

public interface IPriorityQueue
{
	/** Prints all elements (not necessarily in the right order). */
	void print();
	
	/** Returns the element with the smallest priority value and removes it from the data structure. */
	PriorityElement deleteMin();
	
	/** Inserts the given element into the data structure. */
	void insert(PriorityElement e);

	void decreaseKey(int index, int priority);
}
