package de.thm.algo.searching.trees;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

import de.thm.algo.searching.common.Element;
import de.thm.algo.searching.common.IterableSearchDataStructure;

/**
 * A straightforward binary search tree implementation.
 */
public class BinarySearchTree implements IterableSearchDataStructure {
	
	private static final int MAX_CHILDREN = 2;
	protected static final int LEFT = 0;
	protected static final int RIGHT = 1;
	
	protected BasicNode root;

	@Override
	public void insert(Element e) {
		insert(new BasicNode(e));
	}
	
	protected void insert(BasicNode newNode) {
		if (root == null) {	root = newNode;	return;	}
		
		// look for the right place
		int childIndex;
		BasicNode parent, current = root;
		do {
			parent = current;
			childIndex = parent.compareTo(newNode.toString()) > 0 ? LEFT : RIGHT;
			current = parent.getChild(childIndex);
		} while (current != null);
		
		// insert new element
		parent.setChild(childIndex, newNode);
	}

	@Override
	public Element find(String id) {
		BasicNode current = root;
		while (current != null && current.compareTo(id) != 0) {
			current = current.compareTo(id) > 0 ? current.getChild(LEFT) : current.getChild(RIGHT);
		}
		return current;
	}		
	
	@Override
	public Iterator<Element> iterator() {
		return new BSTiterator();
	}

	/**
	 * Determines the height (= number of levels) of this binary search tree.
	 * A recursive implementation would be simpler; however, we could run into
	 * troubles (Stack Overflow) when the height gets big.
	 * Therefore, we provide an iterative implementation.
	 */
	public int determineHeight() {
		if (root == null) return 0;
		
		// Process the tree level by level beginning with the root.
		// This queue contains all nodes of one level.
		final Queue<BasicNode> queue = new ArrayDeque<>();
		queue.add(root);
		int height = 0;
		while (queue.size() > 0) {
			height++;
			// Remove all nodes of the current level from the queue and
			// add all children of these nodes to the queue, i.e., add all nodes of the next level.
			for (int i = queue.size(); i > 0; i--) {
				final BasicNode node = queue.remove();
				for (int c = LEFT; c <= RIGHT; c++) {
					if (node.getChild(c) != null) queue.add(node.getChild(c));
				}
			}
		}		
		return height;
	}
	
	/** Represents a node in a binary search tree. */
	protected static class BasicNode extends Element {			
		private BasicNode[] children = new BasicNode[MAX_CHILDREN];
		private BasicNode parent;
		
		public BasicNode(String id) {
			super(id);
		}
		
		public BasicNode(Element e) {
			super(e);
		}

		public BasicNode getChild(int index) {
			return children[index];
		}
		
		public void setChild(int index, BasicNode node) {
			children[index] = node;
			if (node != null) node.parent = this;
		}

		public BasicNode getParent() {
			return parent;
		}
		
		protected void makeRoot() {
			parent = null;
		}
	}
	
	private class BSTiterator implements Iterator<Element> {
		
		private BasicNode next;
		
		public BSTiterator() {
			next = root;
			descendLeft();
		}

		@Override
		public boolean hasNext() {
			return (next != null);
		}

		@Override
		public Element next() {
			final Element result = next;
			
			// Proceed to the next element:
			if (next.getChild(RIGHT) != null) {
				// Case 1: If there is a right child, go the smallest node in the right subtree.
				next = next.getChild(RIGHT);
				descendLeft();
			} else {
				// Case 2: Go upwards as long as we are the RIGHT child.
				// (In other words: stop going upwards at a parent node whose LEFT child has been visited before
				//  because then that parent and, after it, its right subtree come next.)
				// Eventually, we walk beyond the root and 'next' will be null since then no nodes are remaining.
				BasicNode child;
				do {
					child = next;
					next = next.getParent();
				} while ((next != null) && (child == next.getChild(RIGHT)));
			}
			
			return result;
		}
		
		/**
		 * Moves down to a leaf, always turning left, i.e.,
		 * goes to the smallest element in the current subtree. 
		 */
		private void descendLeft() {
			if (next == null) return;
			while (next.getChild(LEFT) != null) next = next.getChild(LEFT);
		}
		
	}

}
