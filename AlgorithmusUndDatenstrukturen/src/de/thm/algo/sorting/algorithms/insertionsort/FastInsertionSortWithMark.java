package de.thm.algo.sorting.algorithms.insertionsort;

import de.thm.algo.sorting.data.SortableElements;

public class FastInsertionSortWithMark extends InsertionSort {

	@Override
	public void sort(SortableElements e, int left, int right) {
		int min = left;
		for (int i = left+1; i <= right; i++) {
			if (e.compare(i, min) < 0) min = i;
		}
		e.swap(left, min);

		for (int i = left+2; i <= right; i++) {			
			int j = i;
			e.remember(j);			
			for (; ; j--) {
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
