package de.thm.david.stahl.priorityQueue.cycle;

import de.thm.david.stahl.priorityQueue.common.IPriorityQueue;
import de.thm.david.stahl.priorityQueue.common.Element;

/** Represents a priority queue,
 * implemented as a sorted, cyclic array.
 */
public class PriorityQueueCycle implements IPriorityQueue
{
	/** Array containing the actual elements. */
	private Element[] elements;
	
	/** Capacity of the data structure. */
	private int capacity() { return elements.length; }
	
	/** Current size of the data structure (number of contained elements). */
	private int size;
	
	/** Position of the smallest element in the array. */
	private int first;
	
	public PriorityQueueCycle(int capacity)
	{
		assert capacity > 0;
		elements = new Element[capacity];
		first = 0;
		size = 0;
	}

	@Override
	public void print()
	{
		for (int i = 0, j = first; i < size; i++, j = (j + 1) % capacity())
		{
			System.out.println(elements[j]);
		}
	}

	@Override
	public Element deleteMin()
	{
		assert(size > 0);
		Element min = elements[first];
		first = getIncrementIndex(first);
		size--;
		return min;
	}

	/** Auxiliary function needed by "insert". Swaps the two elements at the
	   given positions. */
	private void swap(int i, int j)
	{
		Element tmp = elements[i];
		elements[i] = elements[j];
		elements[j] = tmp;
	}

	@Override
	public void insert(Element e)
	{
		assert(size < capacity());
		// first step: put new element at the end of the existing (cyclic) array
		int index = (first + size) % capacity();
		elements[index] = e;
		size++;
		// second step: iteratively, swap new element with previous element
		//              until array is sorted
		for (int i = 1; i < size; i++)
		{
			int prev = getDecrementIndex(index);

			if (elements[prev].getPriority() <= elements[index].getPriority()) break;
			swap(prev, index);
			index = prev;
		}
	}

	public void decreaseKey(int index, int priority)
	{
		assert(index < capacity());
		assert(priority >= 0);

		Element changedElement = elements[index];
		changedElement.setPriority(priority);

		while(true)
		{
			Element nextElement = elements[getDecrementIndex(index)];

			if(nextElement != null && changedElement.getPriority() < nextElement.getPriority())
			{
				elements[index] = nextElement;
			}
			else
			{
				elements[index] = changedElement;
				return;
			}

			index = getDecrementIndex(index);
		}
	}

	private int getDecrementIndex(int index)
	{
		// add 'capacity' to avoid 'negative numbers'
		return (index + capacity() - 1) % capacity();
	}

	private int getIncrementIndex(int index)
	{
		return (index + 1) % capacity();
	}
}
