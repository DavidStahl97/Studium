package de.thm.algo.correctness;

public class MinAlgorithmus {
	
	public static void main(String[] args) {
		int[] array = { 1, 2, -1, 3, 0 };
		
		int min = min(array, 0, array.length - 1);
		int recursiveMin = recursiveMin(array, 0, array.length - 1);
		System.out.println(min);
		System.out.println(recursiveMin);
	}
	
	private static int min(int[] array, int start, int end) {
		
		int x = Integer.MAX_VALUE;
		
		for(int i = start; i <= end; i++) {
			if(array[i] < x) {
				x = array[i];
			}
		}
		
		return x;
	}
	
	private static int recursiveMin(int[] array, int start, int end) {
		return recursiveMin(array, 0, array.length - 1, Integer.MAX_VALUE);
	}
	
	private static int recursiveMin(int[] array, int start, int end, int x) {
		if(start > end) return x;
		
		if(array[start] < x) x = array[start];
		
		return recursiveMin(array, start + 1, end, x);
	}
	
}
