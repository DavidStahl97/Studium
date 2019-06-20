package de.thm.algo.correctness;

import java.util.Arrays;

public class Main {
	
	enum Tag { MONTAG, DIENSTAG }
	
	public static void main(String[] args) {
		
		var s = Tag.MONTAG.name();
		
		System.out.println(s);
		
		System.out.println(sum(-4));
		System.out.println(recursiveSum(-4));
	}
	
	private static int sum(int n) {
		boolean minus = n < 0;
		n = (n < 0) ? -n : n;
		int ergebnis = (n * (n + 1)) / 2;

		return minus ? -ergebnis : ergebnis;
	}
	
	
	private static int recursiveSum(int n) {
		if(n == 0) return n;
		
		int n1 = (n < 0) ? n + 1 : n - 1;
		
		return n + recursiveSum(n1);
	}
}
