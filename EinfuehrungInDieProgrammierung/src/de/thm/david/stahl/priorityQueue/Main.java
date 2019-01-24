package de.thm.david.stahl.priorityQueue;

import de.thm.david.stahl.priorityQueue.common.*;
import de.thm.david.stahl.priorityQueue.cycle.PriorityQueueCycle;
import de.thm.david.stahl.priorityQueue.heap.PriorityQueueHeap;

public class Main
{
    public static void main(String[] args) {
        System.out.println(" Priority Queue Cyclic:");
        IPriorityQueue pq = new PriorityQueueCycle(10);
        fillPriorityQueue(pq);

        testDecreaseKey(pq);
    }

    private static void fillPriorityQueue(IPriorityQueue pq)
    {
        String[] testLetters = {"D", "i", "e", "s", "<Leer>", "t", "n", "T"};
        int[] frequencies = {1, 3, 3, 3, 3, 2, 1, 1};

        for(int i = 0; i < 5; i++)
        {
            Element e = pq.deleteMin();
            pq.insert(e);
        }

        // insert leaves
        for (int i = 0; i < testLetters.length; i++) pq.insert(new Element(testLetters[i], frequencies[i]));
        pq.print();
    }

    private static void testDecreaseKey(IPriorityQueue pq)
    {
        pq.decreaseKey(1, 0);
        pq.print();
    }
}
