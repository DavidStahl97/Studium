package de.thm.algo.sorting.data;

import de.thm.algo.sorting.Config;

/**
 * A special Elements implementation dealing just with int-Elements.
 * Rather unrealistic, but used in some experiments.
 * (Furthermore used as auxiliary data structure in the FastElements implementation.)
 */
public class IntElements extends AbstractElements {

	private int[] keys;
	private int rememberedKey;

	@Override
	public int size() {
		return keys.length;
	}

	@Override
	public void swap(int i, int j) {
		final int tmp = keys[i];
		keys[i] = keys[j];
		keys[j] = tmp;
	}

	@Override
	public int compare(int i, int j) {
		if (Config.COUNT_COMPARISONS) numberOfComparisons++;
		return keys[i] - keys[j];
	}

	@Override
	public void remember(int i) {
		rememberedKey = keys[i];
	}

	@Override
	public void restore(int i) {
		keys[i] = rememberedKey;
	}

	@Override
	public int compare(int i) {
		if (Config.COUNT_COMPARISONS) numberOfComparisons++;
		return keys[i] - rememberedKey;
	}

	@Override
	public void copy(int source, int target) {
		keys[target] = keys[source];
	}


	@Override
	public void init(int n) {
		super.init(n);
		keys = new int[n];
		for (int i = 0; i < n; i++) keys[i] = i;
	}

	@Override
	public int getKey(int i) {
		return keys[i];
	}

	@Override
	public void setKey(int i, int key) {
		keys[i] = key;
	}
	
	/** Used only by Java Sort. */
	public int[] getElements() {
		return keys;
	}

}
