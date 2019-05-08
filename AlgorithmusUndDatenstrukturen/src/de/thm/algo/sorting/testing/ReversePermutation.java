package de.thm.algo.sorting.testing;

import de.thm.algo.sorting.data.PermutableElements;

public class ReversePermutation extends AbstractPermutation {

	@Override
	public void permute(PermutableElements e) {
		final int n = e.size();
		for (int i = 0; i < n / 2; i++) {
			e.swap(i, n - i - 1);
		}
	}
	

}
