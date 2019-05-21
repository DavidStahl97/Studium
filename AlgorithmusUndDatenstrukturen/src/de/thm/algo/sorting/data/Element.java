package de.thm.algo.sorting.data;

/**
 * Represents a single Element consisting of
 * a key (that is used for sorting) and
 * some dummy data to simulate real additional data.
 */
public class Element implements Comparable<Element> {
	
	protected int key;
		
	@SuppressWarnings("unused")
	private long someDummyData = 0; // to make the example more realistic
	
	public Element(int key) {
		this.key = key;
	}

	int getKey() {
		return key;
	}

	void setKey(int key) {
		this.key = key;
	}

	@Override
	public int compareTo(Element o) {
		return key - o.getKey();
	}	
	

}
