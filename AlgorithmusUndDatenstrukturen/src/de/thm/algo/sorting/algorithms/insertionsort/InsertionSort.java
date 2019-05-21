package de.thm.algo.sorting.algorithms.insertionsort;

import de.thm.algo.sorting.algorithms.AbstractSort;
import de.thm.algo.sorting.data.SortableElements;

public class InsertionSort extends AbstractSort {

	@Override
	public void sort(SortableElements e) {
		sort(e, 0, e.size()-1);
	}
	
	public void sort(SortableElements e, int left, int right) {
		for (int i = left+1; i <= right; i++) {
			for (int j = i; j >= left+1; j--) {
				if (e.compare(j-1, j) > 0) {
					e.swap(j-1, j);
				} else {
					break;
				}
			}
		}
	}

}
