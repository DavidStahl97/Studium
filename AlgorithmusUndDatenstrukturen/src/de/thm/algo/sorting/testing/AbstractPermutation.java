package de.thm.algo.sorting.testing;

import de.thm.algo.sorting.data.PermutableElements;

/**
 * Abstract super class of various permutations.
 */
public abstract class AbstractPermutation {
	public abstract void permute(PermutableElements e);
	
	@Override
	public String toString() {		
		return getClass().getSimpleName();
	}
}
