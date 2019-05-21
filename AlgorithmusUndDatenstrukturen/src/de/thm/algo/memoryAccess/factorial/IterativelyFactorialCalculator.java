package de.thm.algo.memoryAccess.factorial;

public class IterativelyFactorialCalculator implements IFactorialCalculator {

	@Override
	public double compute(int n) {
		double result = 1.0;
		for(int i = n; i > 1; i--) {
			result *= i;
		}
		
		return result; 
	}

}
