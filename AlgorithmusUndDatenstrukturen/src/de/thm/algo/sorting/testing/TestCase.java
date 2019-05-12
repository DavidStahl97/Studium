package de.thm.algo.sorting.testing;

import java.util.ArrayList;
import java.util.Arrays;

import de.thm.algo.log.CsvWriter;
import de.thm.algo.log.ILogger;
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
	
	private ILogger logger;
	
	public TestCase(PermutableElements elements, AbstractSort sorter, AbstractPermutation permutation, int noOfElements, ILogger logger) {
		this.elements = elements;
		this.sorter = sorter;
		this.permutation = permutation;
		this.noOfElements = noOfElements;
		this.logger = logger;
	}

	void run() {	
		elements.init(noOfElements);
		assert elements.areSorted();
		permutation.permute(elements);
		
		String[] startString = { 
			elements.toString(), 
			sorter.toString(),
			permutation.toString(),
			Integer.toString(noOfElements) 
		};		
		logger.write(CsvWriter.getString(Arrays.asList(startString)));
		
		final long startTimeNs = System.nanoTime();
		
		sorter.sort(elements);
		
		final long elapsedTimeMs = (System.nanoTime() - startTimeNs) / 1000000;
		final int pivotComparisons = (sorter instanceof QuickSort) ? ((QuickSort)sorter).getPivotComparisons() : 0;
		
		String[] endString = { 
			Long.toString(elements.getNumberOfComparisons()),
			Long.toString(elapsedTimeMs),
			Integer.toString(pivotComparisons)
		};
		logger.writeLine("," + CsvWriter.getString(Arrays.asList(endString)));
		
		assert elements.areSorted();		
	}

}
