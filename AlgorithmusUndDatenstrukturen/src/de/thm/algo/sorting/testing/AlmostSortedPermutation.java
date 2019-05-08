package de.thm.algo.sorting.testing;

import de.thm.algo.sorting.data.PermutableElements;

/**
 * A permutation where only 10% of the elements are not sorted.
 */
public class AlmostSortedPermutation extends RandomPermutation {

	@Override
	public void permute(PermutableElements e) {
		permuteWithRatio(e, 0.1);	
	}

	

}
