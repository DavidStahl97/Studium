package de.thm.algo.searching;

import java.util.*;

import de.thm.algo.searching.common.*;
import de.thm.algo.searching.lists.*;
import de.thm.algo.searching.trees.*;
import de.thm.algo.searching.hashing.*;


/**
 * Contains the main test program using data that has been collected by a webcrawler.
 * Performs insert and find experiments with all implemented search data structures.
 */
public class WebCrawlerTest {
	
	/** First command-line argument: path to the folder that contains all input files. */
	static String filePath = ".";
	
	/** 
	 * Second command-line argument: "t" (= true) if the comparatively slow list implementations 
	 * (UnsortedList and SortedList) should be included in the experiments.
	 */
	static boolean includeLists = false;
	
	/** 
	 * Third command-line argument: "t" (= true) if the input should be inserted in sorted order.
	 * (Useful in order to demonstrate that the binary search tree degenerates.)
	 */
	static boolean useSortedInserts = false;
	
	/**
	 * Fourth command-line argument: "t" (= true) if detailed tests should be performed and printed.
	 */
	static boolean debug = false;
	
	
	/** Auxiliary data structure to read (and sort) the input from disk. */
	final static AVLTree elementsSorted = new AVLTree();
	
	/** A sorted or unsorted list containing all elements in order to test the "insert" operation. */
	final static List<Element> elementsToInsert = new ArrayList<>();
	
	/** A unsorted list (with a different order than elementsToInsert) in order to test the "find" operation. */
	final static List<Element> elementsToFind = new ArrayList<>();


	public static void main(String[] args) {
		// read and process command-line arguments
		if (args.length >= 1) filePath = args[0];
		if (args.length >= 2 && args[1].equals("t")) includeLists = true;
		if (args.length >= 3 && args[2].equals("t")) useSortedInserts = true;
		if (args.length >= 4 && args[3].equals("t")) debug = true;
		
		// read the input from disk
		readOnceFromFiles();
		
		// perform experiments
		insertAndFindExperiments();
	}
	
	private static void insertAndFindExperiments() {
		final ArrayList<SearchDataStructure> dataStructures = new ArrayList<>();
		if (includeLists) {
			dataStructures.add(new UnsortedList());
			dataStructures.add(new SortedList());
		}
		dataStructures.add(new BinarySearchTree());
		dataStructures.add(new AVLTree());
		dataStructures.add(new LinkedListHashTable(elementsToInsert.size()));
		dataStructures.add(new LinearProbingHashTable(elementsToInsert.size()));
		
		// EXERCISE: add TreeMapAdapter
		//dataStructures.add(new TreeMapAdapter());
		
		// EXERCISE: add HashMapAdapter
		//dataStructures.add(new HashMapAdapter(elementsToInsert.size()));
		
		for (SearchDataStructure dataStructure : dataStructures) {
			System.out.println(dataStructure.getClass().getSimpleName());
			
			performExperiment(dataStructure, "insert", new Experiment() {				
				@Override
				public void run(SearchDataStructure dataStructure) {
					for (Element e : elementsToInsert) dataStructure.insert(e);					
				}
			});
			
			performExperiment(dataStructure, "find", new Experiment() {				
				@Override
				public void run(SearchDataStructure dataStructure) {
					for (Element e : elementsToFind) dataStructure.find(e.toString());					
				}
			});
			
			if (dataStructure instanceof BinarySearchTree) {
				System.out.println("height: " + ((BinarySearchTree)dataStructure).determineHeight());
			}
			if (debug) {
				testSearch(dataStructure);
				if (dataStructure instanceof IterableSearchDataStructure) {					
					printContents((IterableSearchDataStructure) dataStructure);
				}
			}
		}
	}	
	
	private static void readOnceFromFiles() {
		WebCrawlerFileReader reader = new WebCrawlerFileReader(filePath, elementsSorted);
		reader.read();
		
		elementsSorted.iterator().forEachRemaining(elementsToInsert::add);
		elementsToFind.addAll(elementsToInsert);
		if (!useSortedInserts) Collections.shuffle(elementsToInsert);
		Collections.shuffle(elementsToFind);
	}
	
	private static void performExperiment(SearchDataStructure dataStructure, String experimentName, Experiment experimentCode) {
		final long startTimeNs = System.nanoTime();
		experimentCode.run(dataStructure);
		final long elapsedTimeMs = (System.nanoTime() - startTimeNs) / 1000000;
		System.out.println(experimentName + " (" + elapsedTimeMs + " ms).");
	}
	
	private static void testSearch(final SearchDataStructure dataStructure) {
		final String[] testData = {"Dijkstra", "Hochschule", "THM", "Friedberg", "Wetzlar", "StudiumPlus", "Algorithmus", "Datenstruktur"};
		for (String test : testData) {
			Element e = dataStructure.find(test);
			System.out.print("Search '" + test + "': ");
			if (e == null) {
				System.out.println("not found.");
			} else {
				System.out.println(e.getFirstExtras());
			}
		}
	}
	
	private static void printContents(final IterableSearchDataStructure dataStructure) {
		final Iterator<Element> it = dataStructure.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	private interface Experiment {
		void run(SearchDataStructure dataStructure);
	}

}
