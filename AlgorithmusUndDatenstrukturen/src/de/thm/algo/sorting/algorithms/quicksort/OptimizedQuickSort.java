package de.thm.algo.sorting.algorithms.quicksort;

import de.thm.algo.sorting.algorithms.selectionsort.SelectionSort;
import de.thm.algo.sorting.data.SortableElements;

public class OptimizedQuickSort extends QuickSort {
	
	private static final int BORDER = 75;
	private final SelectionSort selectionSort;
	
	public OptimizedQuickSort(PivotMethod pivotMethod, boolean iterativeVariant) {
		super(pivotMethod, iterativeVariant);
		
		selectionSort = new SelectionSort();
	}
	
	@Override
	protected void sortIterative(SortableElements e) {
		int left = 0;
		int right = e.size() - 1;
		while (true) {
			
			if(right - left < BORDER) {
				selectionSort.sort(e, left, right);
				
				if(noOfTasks > 0) {
					right = tasks[--noOfTasks];
					left = tasks[--noOfTasks];
					continue;
				}
				else break;
			}
			
			final int p = pivot(e, left, right);
			final int i = partition(e, left, right, p);
			final int leftSize = i - left;
			final int rightSize = right - i;
			
			if (leftSize > 1 && rightSize > 1) {
				// If both parts must be further sorted, we sort the smaller part
	            // during the next iteration and save the larger part for later 
	            // (add to pending tasks).
				if (leftSize <= rightSize) {					
					tasks[noOfTasks++] = i+1;
					tasks[noOfTasks++] = right;
					right = i-1;
				} else {					
					tasks[noOfTasks++] = left;
					tasks[noOfTasks++] = i-1;
					left = i+1;
				}
			} else if (leftSize > 1) { // only the left part must be further sorted
				right = i-1;
			} else if (rightSize > 1) { // only the right part must be further sorted
				left = i+1;
			} else if (noOfTasks > 0) {
				// No part must be further sorted.
				// Take a task from the stack (if available).
				right = tasks[--noOfTasks];
				left = tasks[--noOfTasks];
			} else break; // everything is sorted :-)
		}	
	}
	
}
