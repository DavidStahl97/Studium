package de.thm.algo.memoryAccess.factorial;

public class RecursivelyFactorialCalculator implements IFactorialCalculator{

	@Override
	public double compute(int n) {
		if(n == 1) return 1;
		return n * compute(n - 1);
	}

}
