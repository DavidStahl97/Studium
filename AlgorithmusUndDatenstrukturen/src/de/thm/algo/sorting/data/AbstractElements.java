package de.thm.algo.sorting.data;

/**
 * Abstract super class of various Elements implementations.
 */
public abstract class AbstractElements implements PermutableElements {
	
	protected long numberOfComparisons;

	
	@Override
	public void init(int n) {
		numberOfComparisons = 0;		
	}

	@Override
	public long getNumberOfComparisons() {
		return numberOfComparisons;
	}
	
	@Override
	public boolean areSorted() {
		for (int i = 0; i < size(); i++) {
			if (getKey(i) != i) return false;
		}
		return true;
	}
	
	@Override
	public String toString() {		
		return getClass().getSimpleName();
	}
	
}
