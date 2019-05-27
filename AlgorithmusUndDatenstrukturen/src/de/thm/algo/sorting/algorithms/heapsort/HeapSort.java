package de.thm.algo.sorting.algorithms.heapsort;

import de.thm.algo.sorting.algorithms.AbstractSort;
import de.thm.algo.sorting.data.SortableElements;

public class HeapSort extends AbstractSort {

	@Override
	public void sort(SortableElements e) {
		
		for(int i = (e.size() - 1) / 2; i >= 0; i--) {
			decrease(e, i, e.size() - 1);
		}
		
		for(int i = e.size() - 1; i > 0; i--) {
			e.swap(i, 0);
			decrease(e, 0, i - 1);
		}
		
	}
	
	private void decrease(SortableElements e, int i, int m) {
		int j;
		
		while(2 * i <= m) {
			j = i * 2;
			if(j < m  && e.compare(j, j + 1) < 0) {
				j++;
			}
			
			if(e.compare(i, j) < 0) {
				
				e.swap(i, j);
				i = j;
				
			} else return;
		}
	}

}
