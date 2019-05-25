package de.thm.algo.sorting.algorithms.selectionsort;

import de.thm.algo.sorting.algorithms.AbstractSort;
import de.thm.algo.sorting.data.SortableElements;

public class SelectionSort extends AbstractSort {

	@Override
	public void sort(SortableElements e) {
		sort(e, 0, e.size() - 1);
	}
	
	public void sort(SortableElements e, int left, int right) {
		for(int i = left; i < right; i++) {
			int min = i;
			
			for(int j = i + 1; j <= right; j++) {
				
				if(e.compare(min, j) > 0) {
					min = j;
				}
				
			}
			
			e.swap(i, min);
		}		
	}

}
