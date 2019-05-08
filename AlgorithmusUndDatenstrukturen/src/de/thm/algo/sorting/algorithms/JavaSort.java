package de.thm.algo.sorting.algorithms;

import java.util.Arrays;

import de.thm.algo.sorting.data.*;

/**
 * Adapter for the default sorting algorithm of the Java API (Arrays.sort). 
 */
public class JavaSort extends AbstractSort {

	@Override
	public void sort(SortableElements e) {
		// We must cast since Arrays.sort expects a raw array to be sorted.
		// That means we cannot work with the SortableElements interface.
		if (e instanceof NormalElements) {
			NormalElements normalElements = (NormalElements) e;
			Arrays.sort(normalElements.getElements());
		}
		if (e instanceof IntElements) {
			IntElements intElements = (IntElements) e;
			Arrays.sort(intElements.getElements());
		}
	}

}
