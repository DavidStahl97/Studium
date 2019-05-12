package de.thm.algo.sorting.algorithms;

import de.thm.algo.sorting.data.SortableElements;

public class SelectionSort extends AbstractSort {

	@Override
	public void sort(SortableElements e) {

		for(int i = 0; i < e.size() - 1; i++) {
			int min = i;
			
			for(int j = i + 1; j < e.size(); j++) {
				
				if(e.compare(min, j) > 0) {
					min = j;
				}
				
			}
			
			if(i != min) {
				e.swap(i, min);
			}
		}
		
	}

}
