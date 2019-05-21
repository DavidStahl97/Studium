package de.thm.algo.sorting.algorithms.heapsort;

import de.thm.algo.sorting.algorithms.AbstractSort;
import de.thm.algo.sorting.data.NormalElements;
import de.thm.algo.sorting.data.SortableElements;

public class HeapSort extends AbstractSort {

	@Override
	public void sort(SortableElements e) {
		
		var elements = ((PriorityElements)e).getElements();
		
		var heap = fillHeap(elements);
		sortList(heap, elements);
		
	}
	
	private IPriorityQueue fillHeap(PriorityElement[] elements) {
		var heap = new PriorityQueueHeap(elements.length);
		
		for(var e : elements) {
			heap.insert(e);
		}
		
		return heap;
	}
	
	private void sortList(IPriorityQueue heap, PriorityElement[] elements) {
		
	}

}
