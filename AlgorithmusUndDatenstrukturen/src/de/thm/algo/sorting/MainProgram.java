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
import de.thm.algo.sorting.algorithms.heapsort.HeapSort;
import de.thm.algo.sorting.algorithms.heapsort.PrimitiveHeapSort;
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
		
		var tester = SimulationBuilder.create(args);
		tester.run();
	}

}
