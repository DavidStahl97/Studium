package de.thm.algo.sorting;


import de.thm.algo.log.ConsoleLogger;
import de.thm.algo.log.FileLogger;
import de.thm.algo.log.ILogger;
import de.thm.algo.sorting.algorithms.AbstractSort;
import de.thm.algo.sorting.algorithms.JavaSort;
import de.thm.algo.sorting.algorithms.heapsort.HeapSort;
import de.thm.algo.sorting.algorithms.heapsort.PrimitiveHeapSort;
import de.thm.algo.sorting.algorithms.insertionsort.FastInsertionSort;
import de.thm.algo.sorting.algorithms.insertionsort.FastInsertionSortWithMark;
import de.thm.algo.sorting.algorithms.insertionsort.InsertionSort;
import de.thm.algo.sorting.algorithms.quicksort.OptimizedQuickSort;
import de.thm.algo.sorting.algorithms.quicksort.QuickSort;
import de.thm.algo.sorting.algorithms.selectionsort.SelectionSort;
import de.thm.algo.sorting.data.*;
import de.thm.algo.sorting.testing.*;

public class SimulationBuilder {
	
	private static final int PERMUTATION_ELEMENTS_ARG = 0;
	private static final int ALGORITHM_ARG = 1;
	private static final int PERMTUATION_ARG = 2;
	private static final int MINIMUM_ARG = 3;
	private static final int STEP_ARG = 4;
	private static final int MAXIMUM_ARG = 5;
	
	private static AbstractPermutation[] allBasicPermutations = {
			new RandomPermutation(), 
			new ReversePermutation(), 
			new AlmostSortedPermutation()};
	
	private static AbstractPermutation[] allPermutations = {
			new RandomPermutation(), 
			new ReversePermutation(), 
			new AlmostSortedPermutation(),
			new AdversePermutation()};
	
	public static TestCases create(String[] args) {
		
		var elements = getElements(args[PERMUTATION_ELEMENTS_ARG]);
		var algo = getAlgorithm(args[ALGORITHM_ARG]);
		var permutations = getPermutations(args[PERMTUATION_ARG]);
		
		int minN = Integer.parseInt(args[MINIMUM_ARG]) * 1000;
		int stepN = Integer.parseInt(args[STEP_ARG]) * 1000;
		int maxN = Integer.parseInt(args[MAXIMUM_ARG]) * 1000;
		
		var logger = (args.length >= 7) ? new FileLogger(args[6]) : new ConsoleLogger();
		
		return new TestCases(elements, algo, permutations, minN, stepN, maxN, logger);
	}
	
	private static PermutableElements[] getElements(String arg) {
		PermutableElements list = null;
		
		switch (arg) {
			case "N": 
				list = new NormalElements(); 
				break;
			case "F": 
				list = new FastElements(); 
				break;
			case "I":
				list = new IntElements(); 
				break;
		}
		
		return new PermutableElements[] { list };
	}
	
	private static AbstractSort[] getAlgorithm(String arg) {
		AbstractSort algo = null;
		
		switch(arg) {
			case "In": 
				algo = new InsertionSort(); 
				break;
			case "If": 
				algo = new FastInsertionSort(); 
				break;
			case "Im": 
				algo = new FastInsertionSortWithMark(); 
				break;
			
			case "S": 
				algo = new SelectionSort(); 
				break;
			
			case "Qm1f": 
				algo = new QuickSort(QuickSort.PivotMethod.MIDDLE, false);
				break;
			case "Qm1t": 
				algo = new QuickSort(QuickSort.PivotMethod.MIDDLE, true); 
				break;
			case "Qt1t": 
				algo = new QuickSort(QuickSort.PivotMethod.MEDIAN_OF_THREE, true);
				break;
			case "Qt1o": 
				algo = new OptimizedQuickSort();
				break;
			case "Qt1f": 
				algo = new QuickSort(QuickSort.PivotMethod.MEDIAN_OF_THREE, false);
				break;
			case "Qr1t": 
				algo = new QuickSort(QuickSort.PivotMethod.RANDOM, true);
				break;
			
			case "PH": 
				algo = new PrimitiveHeapSort();
				break;
			case "H": 
				algo = new HeapSort();
				break;
				
			case "J": 
				algo = new JavaSort();
				break;
		}
		
		return new AbstractSort[] { algo };
	}
 	
	private static AbstractPermutation[] getPermutations(String arg) {
		AbstractPermutation[] permutations = null;
		switch(arg) {
			case "A": 
				permutations = allPermutations;
				break;
			case "B": 
				permutations = allBasicPermutations;
				break;
			case "R": 
				permutations = new AbstractPermutation[] {new RandomPermutation()};
				break;
		}
		
		return permutations;
	}
}
