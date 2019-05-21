package de.thm.algo.sorting.data;

import de.thm.algo.sorting.Config;

/**
 * A straightforward Elements implementation which basically just keeps an array of Element-objects.
 */
public class NormalElements extends AbstractElements {
	
	protected Element[] elements;
	protected Element remembered;
	
	protected void allocateElementList(int n) {
		elements = new Element[n];
	}
	
	protected void 

	@Override
	public void init(int n) {
		super.init(n);
		allocateElementList(n);
		long timestamp = System.nanoTime();
		for (int i = 0; i < n; i++) {
			elements[i] = new Element(i);
			if (((i+1) % 10000000 == 0)) {
				long current = System.nanoTime();
				System.out.println((i+1) + " elements created (" + (current - timestamp)/1000000 + " ms)");
				timestamp = current;
			}
		}
	}
	
	@Override
	public int getKey(int i) {
		return elements[i].getKey();
	}

	@Override
	public void setKey(int i, int key) {
		elements[i].setKey(key);
	}

	@Override
	public int size() {
		return elements.length;
	}

	@Override
	public void swap(int i, int j) {
		final Element tmp = elements[i];
		elements[i] = elements[j];
		elements[j] = tmp;
	}

	@Override
	public int compare(int i, int j) {
		if (Config.COUNT_COMPARISONS) numberOfComparisons++;
		return elements[i].compareTo(elements[j]);
	}
	

	@Override
	public void remember(int i) {
		remembered = elements[i];		
	}

	@Override
	public void restore(int i) {
		elements[i] = remembered;
	}

	@Override
	public int compare(int i) {
		if (Config.COUNT_COMPARISONS) numberOfComparisons++;
		return elements[i].compareTo(remembered);
	}

	@Override
	public void copy(int source, int target) {
		elements[target] = elements[source];
	}

	/** Used only by Java Sort. */
	public Element[] getElements() {
		return elements;
	}	

}
