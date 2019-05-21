package de.thm.algo.sorting.algorithms.insertionsort;

import de.thm.algo.sorting.data.SortableElements;

public class FastInsertionSort extends InsertionSort {

	@Override
	public void sort(SortableElements e, int left, int right) {
		for (int i = left+1; i <= right; i++) {			
			int j = i;
			e.remember(j);		
			for (; j >= left+1; j--) {
				if (e.compare(j-1) > 0) {
					e.copy(j-1, j);
				} else {
					break;
				}
			}
			e.restore(j);
		}
	}

}
