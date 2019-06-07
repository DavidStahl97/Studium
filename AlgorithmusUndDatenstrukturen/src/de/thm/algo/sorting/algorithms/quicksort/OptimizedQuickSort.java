package de.thm.algo.sorting.algorithms.quicksort;

import de.thm.algo.sorting.Config;
import de.thm.algo.sorting.algorithms.AbstractSort;
import de.thm.algo.sorting.algorithms.selectionsort.SelectionSort;
import de.thm.algo.sorting.data.SortableElements;

public class OptimizedQuickSort extends AbstractSort {
	
	private static final int BORDER = 75;
	private final SelectionSort selectionSort;
	
	public OptimizedQuickSort() {
		selectionSort = new SelectionSort();
	}
	
	public void sort(SortableElements e) {
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
			
			final int p = pivotMedianOfThree(e, left, right);
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
	
	private int pivotComparisons;
	
	protected int[] tasks = new int[100];
	protected int noOfTasks = 0;
	

	public int getPivotComparisons() {
		return pivotComparisons;
	}

	private int pivotMedianOfThree(final SortableElements e, final int left, final int right) {
		assert left < right;
		final int middle = (left + right) / 2;
		
		// sort left, middle, and right
		if (e.compare(right,  left) < 0) e.swap(right, left);
		if (e.compare(middle,  left) < 0) e.swap(middle, left);
		if (e.compare(right, middle) < 0) e.swap(right, middle);
		
		if (Config.COUNT_COMPARISONS) pivotComparisons += 3;
		
		return middle;
	}
	
	protected int partition(final SortableElements e, final int left, final int right, final int p) {
		e.swap(p, right);

		int i = left;
		int j = right-1;
		while (true) {
			while (e.compare(i, right) < 0) i++;
			while ((j > i) && (e.compare(j, right) >= 0)) j--;
			if (i >= j) break;			
			e.swap(i, j);
		}
		e.swap(i, right);
		return i;
	}
	
}
