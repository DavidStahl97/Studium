package de.thm.algo.sorting.algorithms;

import java.util.Random;

import de.thm.algo.sorting.Config;
import de.thm.algo.sorting.data.SortableElements;

/**
 * Various variants of Quicksort.
 * Without Insertion Sort fallback and without advanced pivot methods.
 */
public class QuickSort extends AbstractSort {
	
	public enum PivotMethod {MIDDLE, MEDIAN_OF_THREE, RANDOM};
	
	private Random random = new Random();
	
	private final PivotMethod pivotMethod;
	private final boolean iterativeVariant;
	private int pivotComparisons;
	
	private int[] tasks = new int[100];
	private int noOfTasks = 0;
	
	public QuickSort(PivotMethod pivotMethod, boolean iterativeVariant) {
		this.pivotMethod = pivotMethod;
		this.iterativeVariant = iterativeVariant;
	}
	

	public int getPivotComparisons() {
		return pivotComparisons;
	}

	@Override
	public String toString() {
		return super.toString() + "(" 
				+ pivotMethod 
				+ (iterativeVariant ? ",Iterative" : "")
				+ ")";
	}

	@Override
	public void sort(SortableElements e) {
		pivotComparisons = 0;
		random.setSeed(0);
		if (iterativeVariant) {
			sortIterative(e);
		} else {
			sort(e, 0, e.size()-1);
		}
	}
	
	/**
	 * Iterative Quicksort implementation.
	 */
	protected void sortIterative(final SortableElements e) {
		int left = 0;
		int right = e.size() - 1;
		while (true) {
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
	
	/**
	 * (Normal) recursive Quicksort implementation.
	 */
	protected void sort(final SortableElements e, final int left, final int right) {
		if (left >= right) return;

		final int p = pivot(e, left, right);
		final int i = partition(e, left, right, p);
		
		sort(e, left, i-1);
		sort(e, i+1, right);
	}
	
	private int pivot(final SortableElements e, final int left, final int right) {
		int p = 0;
		switch (pivotMethod) {
		case MIDDLE:
			p = pivotMiddle(left, right);
			break;
		case MEDIAN_OF_THREE:
			p = pivotMedianOfThree(e, left, right);
			break;
		case RANDOM:
			p = pivotRandom(left, right);
			break;
		}
		return p;
	}

	private int pivotMiddle(final int left, final int right) {
		return (left + right) / 2;
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
	
	private int pivotRandom(final int left, final int right) {
		final int p = (int)(random.nextDouble() * (right+1 - left)) + left;
		assert (p >= left) && (p <= right);
		return p;
	}
	
	private int partition(final SortableElements e, final int left, final int right, final int p) {
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
