package de.thm.algo.sorting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import de.thm.algo.log.ConsoleLogger;
import de.thm.algo.log.FileLogger;
import de.thm.algo.log.ILogger;
import de.thm.algo.sorting.algorithms.*;
import de.thm.algo.sorting.algorithms.insertionsort.*;
import de.thm.algo.sorting.algorithms.quicksort.OptimizedQuickSort;
import de.thm.algo.sorting.algorithms.quicksort.QuickSort;
import de.thm.algo.sorting.algorithms.selectionsort.SelectionSort;
import de.thm.algo.sorting.data.*;
import de.thm.algo.sorting.testing.*;

/**
 * Runs test cases specified by command-line arguments.
 * Consider using the following JVM arguments:
 * -ea to enable assertions
 * -Xms6g -Xmx6g to reserve a sufficient amount of memory
 * -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining to analyze inlining behavior
 */
public class MainProgram {
	
	private static AbstractPermutation[] allBasicPermutations = {
			new RandomPermutation(), 
			new ReversePermutation(), 
			new AlmostSortedPermutation()};
	
	private static AbstractPermutation[] allPermutations = {
			new RandomPermutation(), 
			new ReversePermutation(), 
			new AlmostSortedPermutation(),
			new AdversePermutation()};
	
	public static void main(String[] args) {
		
		if(args.length < 1) {
			System.out.println("Dateiname angeben!");
			return;
		}
		
		List<String[]> parameters = null;
		try {
			parameters = readArguments(args[0]);
		} catch (IOException e) {
			System.out.println("Fehler beim Lesen der Datei!");
		}
		
		for(var p : parameters) {
			start(p);
		}
	}
	
	private static List<String[]> readArguments(String fileName) throws IOException {
		
		var parameters = new ArrayList<String[]>();
		
		Files.lines(Paths.get(fileName)).forEach(line -> {
			parameters.add(line.split(" "));
		});
		
		return parameters;
	}
	
	private static void start(String[] args) {
		if (args.length < 6) return;
		
		PermutableElements[] elements = new PermutableElements[] {new NormalElements(), new FastElements()};
		if (args[0].equals("N")) elements = new PermutableElements[] {new NormalElements()};
		if (args[0].equals("F")) elements = new PermutableElements[] {new FastElements()};
		if (args[0].equals("I")) elements = new PermutableElements[] {new IntElements()};
		//if (args[0].equals("P")) elements = new PermutableElements[] {new PriorityElements()};
		
		ArrayList<AbstractSort> sorters = new ArrayList<>();
		if (args[1].contains("In")) sorters.add(new InsertionSort());
		if (args[1].contains("If")) sorters.add(new FastInsertionSort());
		if (args[1].contains("Im")) sorters.add(new FastInsertionSortWithMark());
		
		if (args[1].contains("S")) sorters.add(new SelectionSort());
		
		if (args[1].contains("Qm1f"))  sorters.add(new QuickSort(QuickSort.PivotMethod.MIDDLE, false));
		if (args[1].contains("Qm1t"))  sorters.add(new QuickSort(QuickSort.PivotMethod.MIDDLE, true));
		if (args[1].contains("Qt1t"))  sorters.add(new QuickSort(QuickSort.PivotMethod.MEDIAN_OF_THREE, true));
		if (args[1].contains("Qt1o"))  sorters.add(new OptimizedQuickSort());
		if (args[1].contains("Qt1f"))  sorters.add(new QuickSort(QuickSort.PivotMethod.MEDIAN_OF_THREE, false));
		if (args[1].contains("Qr1t"))  sorters.add(new QuickSort(QuickSort.PivotMethod.RANDOM, true));
		
		//if(args[1].contains("H")) sorters.add(new HeapSort());
		
		if (args[1].contains("J")) sorters.add(new JavaSort());
		
		
		AbstractPermutation[] permutations = new AbstractPermutation[0];
		if (args[2].equals("A")) permutations = allPermutations;
		if (args[2].equals("B")) permutations = allBasicPermutations;
		if (args[2].equals("R")) permutations = new AbstractPermutation[] {new RandomPermutation()};
		
		int minN = Integer.parseInt(args[3]) * 1000;
		int stepN = Integer.parseInt(args[4]) * 1000;
		int maxN = Integer.parseInt(args[5]) * 1000;
		
		ILogger logger = (args.length >= 7) ? new FileLogger(args[6]) : new ConsoleLogger();
		
		TestCases tc = new TestCases(elements, sorters.toArray(new AbstractSort[0]), permutations, minN, stepN, maxN, logger);
		tc.run();
	}	
}
