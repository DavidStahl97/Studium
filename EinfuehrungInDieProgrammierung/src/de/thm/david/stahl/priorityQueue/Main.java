package de.thm.david.stahl.priorityQueue;

import de.thm.david.stahl.priorityQueue.common.*;
import de.thm.david.stahl.priorityQueue.cycle.PriorityQueueCycle;
import de.thm.david.stahl.priorityQueue.heap.PriorityQueueHeap;

public class Main
{
    public static void main(String[] args) {
        System.out.println(" Priority Queue Cyclic:");
        test01(new PriorityQueueCycle(10));
        test02(new PriorityQueueCycle(8));
        //test03(new PQueueCyclic(8));

        System.out.println(" Priority Queue Heap:");
        test01(new PriorityQueueHeap(10));
        test02(new PriorityQueueHeap(8));
    }

    /* Test Case 01:
       add 10 elements in reverse order and
       remove them one by one.
    */
    private static void test01(IPriorityQueue pq) {
        System.out.println("Test 01");

        for (int i = 9; i >= 0; i--) {
            pq.insert(new Element("Element " + i, i));
        }

        for (int i = 0; i < 10; i++) {
            Element e = pq.deleteMin();
            System.out.println(e);
        }
        System.out.println("");
    }

    /* Test Case 02:
       simulate Huffman tree creation with 8 leaves.
    */
    private static void test02(IPriorityQueue pq) {
        System.out.println("Test 02");

        pq.print();

        String[] testLetters = {"D", "i", "e", "s", "<Leer>", "t", "n", "T"};
        int[] frequencies = {1, 3, 3, 3, 3, 2, 1, 1};

        // insert leaves
        for (int i = 0; i < testLetters.length; i++) pq.insert(new Element(testLetters[i], frequencies[i]));
        pq.print();

        // perform steps needed to build the Huffman tree
        for (int i = 1; i < testLetters.length; i++) {
            Element e1 = pq.deleteMin();
            Element e2 = pq.deleteMin();
            System.out.println("min elements: " + e1 + ", " + e2);
            pq.print();
            final Element newElement = new Element(e1.getId()+e2.getId(), e1.getPriority()+e2.getPriority());
            System.out.println("new element: " + newElement);
            pq.insert(newElement);
            pq.print();
        }

        System.out.println("final element: " + pq.deleteMin());
        System.out.println("");
    }

    /* Test Case 03:
       simulate Huffman tree creation with 8 leaves.
       Contains a mistake in order to demonstrate assert-statements!
    */
    private static void test03(IPriorityQueue pq) {
        System.out.println("Test 03");

        pq.print();

        String[] testLetters = {"D", "i", "e", "s", "<Leer>", "t", "n", "T"};
        int[] frequencies = {1, 3, 3, 3, 3, 2, 1, 1};

        // insert leaves
        for (int i = 0; i < testLetters.length; i++) pq.insert(new Element(testLetters[i], frequencies[i]));
        pq.print();

        // perform steps needed to build the Huffman tree
        // small mistake: <= instead of <
        for (int i = 1; i <= testLetters.length; i++) {
            Element e1 = pq.deleteMin();
            Element e2 = pq.deleteMin();
            System.out.println("min elements: " + e1 + ", " + e2);
            pq.print();
            final Element newElement = new Element(e1.getId()+e2.getId(), e1.getPriority()+e2.getPriority());
            System.out.println("new element: " + newElement);
            pq.insert(newElement);
            pq.print();
        }

        System.out.println("final element: " + pq.deleteMin());
        System.out.println("");
    }
}
