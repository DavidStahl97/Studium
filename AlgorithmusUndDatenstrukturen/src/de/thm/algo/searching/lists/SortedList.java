package de.thm.algo.searching.lists;

import java.util.Collections;

import de.thm.algo.searching.common.Element;

/**
 * Represents a sorted list of elements.
 * Note that insert operations are slow, namely O(n),
 * while find operations are fast, namely O(log n).
 */
public class SortedList extends UnsortedList {

	@Override
	public void insert(Element e) {
		super.insert(e);

		// Swaps the last element of the list with its predecessor
		// until the sort order is restored.
		for (int i = list.size()-1; i >= 1; i--) {
			if (list.get(i).compareTo(list.get(i-1).toString()) < 0) {
				Collections.swap(list, i, i-1);
			} else {
				break;
			}
		}
	}

	@Override
	public Element find(String id) {
		return binarySearch(id, 0, list.size()-1);
	}
	
	private Element binarySearch(final String id, final int left, final int right) {
		if (left > right) return null;
		final int middle = (left + right) / 2;
		final Element element = list.get(middle);
		final int comparison = element.compareTo(id);
		if (comparison == 0) {
			return element;
		} else if (comparison < 0) {
			return binarySearch(id, middle+1, right);
		} else {
			return binarySearch(id, left, middle-1);
		}
	}

}
