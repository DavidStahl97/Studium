package de.thm.algo.sorting.algorithms;

import de.thm.algo.sorting.data.SortableElements;

/**
 * Abstract super class of all implemented sorting algorithms.
 */
public abstract class AbstractSort {

	public abstract void sort(SortableElements e);
	
	@Override
	public String toString() {		
		return getClass().getSimpleName();
	}

}
