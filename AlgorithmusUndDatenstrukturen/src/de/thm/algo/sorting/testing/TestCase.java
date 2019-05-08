package de.thm.algo.sorting.testing;

import de.thm.algo.sorting.algorithms.AbstractSort;
import de.thm.algo.sorting.algorithms.QuickSort;
import de.thm.algo.sorting.data.*;

/**
 * Represents a single test case.
 */
public class TestCase {
	private PermutableElements elements;
	private AbstractSort sorter;
	private AbstractPermutation permutation;
	private int noOfElements;
	
	public TestCase(PermutableElements elements, AbstractSort sorter, AbstractPermutation permutation, int noOfElements) {
		this.elements = elements;
		this.sorter = sorter;
		this.permutation = permutation;
		this.noOfElements = noOfElements;
	}

	void run() {	
		elements.init(noOfElements);
		assert elements.areSorted();
		permutation.permute(elements);
		
		System.out.print(elements + ";" + sorter + ";" + permutation + ";" + noOfElements + ";");
		final long startTimeNs = System.nanoTime();
		sorter.sort(elements);
		final long elapsedTimeMs = (System.nanoTime() - startTimeNs) / 1000000;
		final int pivotComparisons = (sorter instanceof QuickSort) ? ((QuickSort)sorter).getPivotComparisons() : 0;
		System.out.println(elements.getNumberOfComparisons() + ";" + elapsedTimeMs + ";" + pivotComparisons);
		assert elements.areSorted();		
	}

}
