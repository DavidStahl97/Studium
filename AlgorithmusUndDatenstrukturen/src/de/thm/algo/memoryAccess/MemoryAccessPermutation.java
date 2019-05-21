package de.thm.algo.memoryAccess;

import java.util.Random;

public class MemoryAccessPermutation {
	
	private static final int arraySize = 100 * 1000 * 1000;
	
	private static int[] sortedPermutation;
	private static int[] randomPermutation;
	private static int[] numbers;
	
	public static void main(String[] main) {
		
		populateData();
		
		System.out.println("Sortierte Permutation:");
		measure(sortedPermutation);
		
		System.out.println();
		
		System.out.println("Zufällige Permutation:");
		measure(randomPermutation);
	}
	
	private static void measure(int[] permutation) {
		final long startTimeNs = System.nanoTime();
		
		int sum = calculateSum(permutation);
		
		final long elapsedTimeMs = (System.nanoTime() - startTimeNs) / 1000000;
		
		System.out.println("Summe: " + sum + " , Zeit: " + elapsedTimeMs);
	}
	
	private static int calculateSum(int[] permutation) {
		int sum = 0;
		for(var index : permutation) {
			sum += numbers[index];
		}
		
		return sum;
	}

	private static void populateData() {
		
		sortedPermutation = new int[arraySize];
		randomPermutation = new int[arraySize];
		numbers = new int[arraySize];
		
		var random = new Random();
		
		for(int i = 0; i < arraySize; i++) {
			sortedPermutation[i] = i;
			randomPermutation[i] = i;
			numbers[i] = random.nextInt(10);
		}
		
		shuffle(randomPermutation);
	}
	
	private static void shuffle(int[] a) {
		var random = new Random(0);
		for(int i = a.length; i > 1; i--) {
			swap(a, i-1, random.nextInt(i));
		}
	}
	
	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
}
