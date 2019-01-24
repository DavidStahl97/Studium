package de.thm.david.stahl.priorityQueue.heap;

import de.thm.david.stahl.priorityQueue.common.IPriorityQueue;
import de.thm.david.stahl.priorityQueue.common.Element;

/** Represents a priority queue,
 * implemented as a binary heap.
 */
public class PriorityQueueHeap implements IPriorityQueue
{
	
	/** Array containing the elements of the heap. */
	private Element[] elements;
	
	/** Current size of the data structure (number of contained elements). */
	private int size;
	
	
	public PriorityQueueHeap(int capacity)
	{
		assert capacity > 0;
		elements = new Element[capacity];
		size = 0;
	}

	@Override
	public void print()
	{
		// print heap level by level
		int levelSize = 1;
		int lastLevelIndex = 0;
		for (int i = 0; i < size; i++) {
			System.out.print(elements[i] + "  ");
			if (i == lastLevelIndex) {
				// current level completed => new line
				System.out.println("");
				levelSize *= 2;
				lastLevelIndex += levelSize;
			}
		}
		System.out.println("");
	}
	
	/** Auxiliary function. Swaps the two elements at the
	   given positions. */
	private void swap(int i, int j)
	{
		Element tmp = elements[i];
		elements[i] = elements[j];
		elements[j] = tmp;
	}

	@Override
	public Element deleteMin()
	{
		assert size > 0;
		// retrieve and remove min element
		Element min = elements[0];
		elements[0] = elements[size-1];
		size--;
		
		// sift down new root element in order to restore heap property
		int i = 0;
		int leftChild = 2*i+1;
		int rightChild = leftChild+1;
		while (leftChild < size) {
			int minChild = leftChild;
			if ((rightChild < size) && (elements[rightChild].getPriority() < elements[leftChild].getPriority())) minChild = rightChild;
			if (elements[minChild].getPriority() >= elements[i].getPriority()) break;
			swap(i, minChild);
			i = minChild;
			leftChild = 2*i+1;
			rightChild = leftChild+1;
		}
		
		return min;
	}

	@Override
	public void insert(Element e)
	{
		assert size < elements.length;
		// add new element to the end
		elements[size] = e;
		size++;
		
		// sift up new element in order to restore heap property
		int i = size - 1;
		int parent = (i-1)/2;
		while (i > 0) {
			if (elements[i].getPriority() >= elements[parent].getPriority()) break;
			swap(i, parent);
			i = parent;
			parent = (i-1)/2;
		}
	}
}
