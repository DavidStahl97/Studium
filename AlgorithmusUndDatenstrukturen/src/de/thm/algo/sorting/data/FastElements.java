package de.thm.algo.sorting.data;

/**
 * An Elements implementation that employs an additional array just to store copies of the keys
 * in order to accelerate access to the keys by avoiding accessing the original objects.
 */
public class FastElements extends NormalElements {
	
	private IntElements keys = new IntElements();

	@Override
	public void init(int n) {
		super.init(n);
		keys.init(n);
	}

	@Override
	public void setKey(int i, int key) {
		super.setKey(i, key);
		keys.setKey(i, key);		
	}

	@Override
	public void swap(int i, int j) {
		super.swap(i, j);
		keys.swap(i, j);
	}

	@Override
	public int compare(int i, int j) {
		return keys.compare(i, j);
	}

	@Override
	public void remember(int i) {		
		super.remember(i);
		keys.remember(i);
	}

	@Override
	public void restore(int i) {
		super.restore(i);
		keys.restore(i);
	}

	@Override
	public int compare(int i) {
		return keys.compare(i);
	}

	@Override
	public void copy(int source, int target) {
		super.copy(source, target);
		keys.copy(source, target);		
	}

	@Override
	public long getNumberOfComparisons() {
		return keys.getNumberOfComparisons();
	}
		
	
}
