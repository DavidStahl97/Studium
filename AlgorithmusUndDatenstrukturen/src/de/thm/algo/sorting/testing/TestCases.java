package de.thm.algo.sorting.testing;

import java.util.ArrayList;
import java.util.Arrays;

import de.thm.algo.log.CsvWriter;
import de.thm.algo.log.ILogger;
import de.thm.algo.sorting.Config;
import de.thm.algo.sorting.algorithms.AbstractSort;
import de.thm.algo.sorting.data.PermutableElements;

/**
 * Represents a series of test cases using all possible combinations of the input.
 */
public class TestCases {
	private ArrayList<TestCase> testCases = new ArrayList<>();


	public TestCases(PermutableElements[] elements, 
			AbstractSort[] sorters, AbstractPermutation[] permutations, 
			int minN, int stepN, int maxN,
			ILogger logger) {
		for (PermutableElements e : elements) {
			for (AbstractSort s : sorters) {
				for (AbstractPermutation p : permutations) {
					for (int n = minN; n <= maxN; n+=stepN) {
						testCases.add(new TestCase(e, s, p, n, logger));
					}
				}
			}
		}
	}
	
	public void run() {
		for (int i = 0; i < Config.REPETITIONS; i++) {
			testCases.forEach(testCase -> testCase.run());
		}
	}

}
