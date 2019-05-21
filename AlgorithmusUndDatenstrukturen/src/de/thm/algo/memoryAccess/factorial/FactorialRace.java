package de.thm.algo.memoryAccess.factorial;

public class FactorialRace {
	
	private static final int N = 70;
	
	public static void main(String[] args) {
		
		System.out.print("Zeit der iterativen Berechnung der Fakultät: ");
		long time = measureComputingFactorial(new IterativelyFactorialCalculator());
		System.out.println(time);
		
		System.out.print("Zeit der rekursiven Berechnung der Fakultät: ");
		time = measureComputingFactorial(new RecursivelyFactorialCalculator());
		System.out.println(time);
	}
	
	private static long measureComputingFactorial(IFactorialCalculator calculator) {
		final long startTimeNs = System.nanoTime();	
		
		for(int i = 0; i < 100 * 1000 * 1000; i++) {
			calculator.compute(N);
		}
		
		final long elapsedTimeMs = (System.nanoTime() - startTimeNs) / 1000000;
		return elapsedTimeMs;
	}
	
}
