package de.thm.david.stahl.priorityQueue;

import de.thm.david.stahl.priorityQueue.common.*;
import de.thm.david.stahl.priorityQueue.cycle.PriorityQueueCycle;
import de.thm.david.stahl.priorityQueue.heap.PriorityQueueHeap;

public class Main
{
    public static void main(String[] args) {
        System.out.println(" Priority Queue Cyclic:");
        IPriorityQueue pq = new PriorityQueueHeap(10);
        fillPriorityQueue(pq);

        pq.print();
        
        testDeleteMin(pq);
        testDeleteMin(pq);
        testDeleteMin(pq);
        testDeleteMin(pq);
    }
    
    private static void testDeleteMin(IPriorityQueue pq) {
    	System.out.println();
    	pq.print();
    	System.out.println();
    	
    	pq.deleteMin();
    	System.out.println();
    	pq.print();
    	System.out.println();
    }
    
    private static void fillPriorityQueue(IPriorityQueue pq) {
        String[] testLetters = {"D", "i", "e", "s", "<Leer>", "t", "n", "T"};
        int[] frequencies = {1, 3, 3, 3, 3, 2, 1, 1};

        // insert leaves
        for (int i = 0; i < testLetters.length; i++)
        {
            pq.insert(new Element(testLetters[i], frequencies[i]));
        }

        pq.print();

        pq.insert(new Element("David", 1));
    }
}
