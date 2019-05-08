package de.thm.algo.sorting.testing;

import java.util.Random;

import de.thm.algo.sorting.data.PermutableElements;

public class RandomPermutation extends AbstractPermutation {
	
	private Random random = new Random();

	@Override
	public void permute(PermutableElements e) {		
		permuteWithRatio(e, 1.0);		
	}	
	
	protected void permuteWithRatio(PermutableElements e, double randomRatio) {
		random.setSeed(0);
		for (int i = e.size()-1; i > 0; i--) {
			if (randomRatio < random.nextDouble()) continue;
			final int j = (int)(random.nextDouble() * (i+1));
			e.swap(i, j);			
		}
	}

}
