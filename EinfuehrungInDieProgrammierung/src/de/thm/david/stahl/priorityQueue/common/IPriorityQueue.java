package de.thm.david.stahl.priorityQueue.common;

public interface IPriorityQueue
{
	/** Prints all elements (not necessarily in the right order). */
	void print();
	
	/** Returns the element with the smallest priority value and removes it from the data structure. */
	Element deleteMin();
	
	/** Inserts the given element into the data structure. */
	void insert(Element e);

	//void decreaseKey(int index, int priority);
}
