package de.thm.algo.sorting.algorithms.heapsort;

import de.thm.algo.sorting.algorithms.AbstractSort;
import de.thm.algo.sorting.data.NormalElements;
import de.thm.algo.sorting.data.SortableElements;

public class PrimitiveHeapSort extends AbstractSort {	
	
	@Override
	public void sort(SortableElements e) {
		var elements = (NormalElements)e;
		var heap = new PriorityQueueHeap(elements.size());
		
		fillHeap(elements, heap);
		sortList(elements, heap);
	}
	
	private void fillHeap(NormalElements elements, PriorityQueueHeap heap) {
		for(var e : elements.getElements()) {
			heap.insert(e);
		}
	}
	
	private void sortList(NormalElements elements, PriorityQueueHeap heap) {
		int i = 1;
		while(heap.getSize() > 0) {
			var e = heap.deleteMin();
			elements.setKey(elements.size() - i, e.getKey());
		}
	}

}
