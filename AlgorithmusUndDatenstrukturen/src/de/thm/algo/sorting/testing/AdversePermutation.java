package de.thm.algo.sorting.testing;

import de.thm.algo.sorting.data.PermutableElements;

/**
 * Permutation that is adverse to Quicksort's pivot method "middle".
 */
public class AdversePermutation extends AbstractPermutation {

	@Override
	public void permute(PermutableElements e) {
		final int n = e.size();
		int a[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = i;
		}		
		for (int i = 0; i < n; i++) {
			int p = (i + (n-1)) / 2;
			e.setKey(a[p], i);
			a[p] = a[n-1];
			a[n-1] = a[i];
		}
	}

}
