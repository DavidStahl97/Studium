package de.thm.algo.sorting.data;

/**
 * Defines all methods that are needed to create and permute an Elements instance
 * in order to create the input for test cases.
 */
public interface PermutableElements extends SortableElements {
	/**
	 * Initializes an Elements instance by creating n elements with ascending keys from 0 to n-1.
	 * @param n the number of elements.
	 */
	void init(int n);
	
	/**
	 * Returns the key of the i-th element.
	 */
	int getKey(int i);
	
	/**
	 * Sets a new key for the i-th element.
	 */
	void setKey(int i, int key);
	
	/**
	 * Returns true iff the elements are sorted (in ascending order).
	 */
	boolean areSorted();
	
	/**
	 * Returns the number of comparisons, i.e., the number of invocations of the compare methods,
	 * since the last call of init.
	 */
	long getNumberOfComparisons();
}
