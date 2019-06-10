package de.thm.algo.searching.hashing;

import de.thm.algo.searching.common.SearchDataStructure;

/**
 * An abstract base class of LinearProbingHashTable and LinkedListHashTable
 * containing the used hash function and the logic that determines the hash table size.
 */
abstract class AbstractHashTable implements SearchDataStructure {
	
	private final int tableSize;
	
	/**
	 * Determines the next prime number >= the given minimum capacity,
	 * which is used as actual table size.
	 * @param minCapacity the minimum table size.
	 */
	public AbstractHashTable(int minCapacity) {
		this.tableSize = nextPrime(minCapacity);
	}

	public int getTableSize() {
		return tableSize;
	}

	private int nextPrime(int n) {
		while (!isPrime(n)) n++;
		return n;
	}

	private boolean isPrime(int n) {
		if (n < 2) return false;
		final int root = (int) Math.sqrt(n) + 1; // plus 1 to avoid rounding errors
		for (int d = 2; d <= root; d++) {
			if (n % d == 0) return false;
		}
		return true;
	}
	
	/** We basically use the standard hash function of Java Strings. */
	protected int hash(String id) {
		// Note that id.hashCode() may return negative numbers.
		return ((id.hashCode() % tableSize) + tableSize) % tableSize; // ensure non-negative indices
	}

}
