package de.thm.algo.sorting.data;

/**
 * Defines all methods that are needed to implement algorithms that sort an Elements instance.
 */
public interface SortableElements {
	/**
	 * Returns the number of elements.
	 */
	int size();
	
	/**
	 * Swaps the i-th and the j-th element.
	 */
	void swap(int i, int j);
	
	/**
	 * Returns an integer < 0 if "key of the i-th element < key of the j-th element".
	 * Returns 0 if the keys are equal. 
	 * Returns an integer > 0 if "key of the i-th element > key of the j-th element".
	 */
	int compare(int i, int j);
	
	/**
	 * Internally stores a copy of the i-th element.
	 */
	void remember(int i);
	
	/**
	 * Copies a previously remembered element to the i-th position.
	 */
	void restore(int i);
	
	/**
	 * Returns an integer < 0 if "key of the i-th element < key of the remembered element".
	 * Returns 0 if the keys are equal. 
	 * Returns an integer > 0 if "key of the i-th element > key of the remembered element".
	 */
	int compare(int i);
	
	/**
	 * Copies the source-element to the target position.
	 */
	void copy(int source, int target);
}
