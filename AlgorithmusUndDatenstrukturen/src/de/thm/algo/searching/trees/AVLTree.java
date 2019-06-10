package de.thm.algo.searching.trees;

import de.thm.algo.searching.common.Element;

/**
 * A straightforward AVL tree implementation based on the implementation of a binary search tree.
 */
public class AVLTree extends BinarySearchTree {
	
	@Override
	public void insert(Element e) {
		final AVLNode newNode = new AVLNode(e);
		insert(newNode);
		ensureAVLproperty(newNode);
	}
	
	/**
	 * Traverses the path from the newly added node (a leaf) up to the root.
	 * Updates all subtree height data along its way.
	 * Checks whether the AVL property is violated. If so, an appropriate rotation operation is invoked.
	 */
	private void ensureAVLproperty(final AVLNode newNode) {
		newNode.setSubtreeHeight(new int[] {0, 0});
		AVLNode current = (AVLNode) newNode.getParent();
		while (current != null) {
			int[] currentHeights = determineSubtreeHeights(current);
			
			// We consider both cases:
			// Case 1: The left subtree is much higher than the right one (high = LEFT, low = RIGHT).
			// Case 2: The right subtree is much higher than the left one (high = RIGHT, low = LEFT).
			for (int high = LEFT; high <= RIGHT; high++) {
				final int low = 1 - high; // low = opposite of high
				if (currentHeights[high] - currentHeights[low] > 1) { // AVL property violated?
					rotate(current, high, low); // rotate
					
					// subtree height might change due to rotation => update
					currentHeights[high] = determineSubtreeHeight(current.getChild(high));
				}
			}
			current.setSubtreeHeight(currentHeights);
			current = (AVLNode) current.getParent();
		}
	}


	/**
	 * Perform the appropriate rotation (left / right / left-right / right-left).
	 * @param current the node where the AVL property is violated
	 * @param high the child index (LEFT or RIGHT) of the higher subtree of 'current'
	 * @param low the opposite of high
	 */
	private void rotate(final AVLNode current, final int high, final int low) {
		AVLNode child = (AVLNode) current.getChild(high);
		final AVLNode parent = (AVLNode) current.getParent();
		
		int[] childHeights = determineSubtreeHeights(child);		
		if (childHeights[low] > childHeights[high]) {
			// first part of a double rotation
			final AVLNode grandchild = (AVLNode) child.getChild(low);
			child.setChild(low, grandchild.getChild(high));
			childHeights[low] = determineSubtreeHeight(child.getChild(low));
			child.setSubtreeHeight(childHeights);
			grandchild.setChild(high, child);
			current.setChild(high, grandchild);
			child = grandchild;
		}

		// single rotation or second part of a double rotation
		current.setChild(high, child.getChild(low));
		child.setChild(low, current);
		if (parent == null) {
			root = child;
			child.makeRoot();
		} else {
			if (parent.getChild(LEFT) == current) {
				parent.setChild(LEFT, child);
			} else {
				parent.setChild(RIGHT, child);
			}
		}
	}
	

	/**
	 * Returns the height of a subtree.
	 * @param node the root of the considered subtree.
	 * @return the height of the considered subtree.
	 */
	private int determineSubtreeHeight(final BasicNode node) {
		return node == null ? 0 : ((AVLNode)node).getSubtreeHeight();
	}
	
	/**
	 * Returns the heights of both children's subtrees.
	 * @param node the node whose children are considered
	 * @return an array that contains the height of the left child's subtree and of the right child's subtree
	 */
	private int[] determineSubtreeHeights(final BasicNode node) {
		return new int[] {determineSubtreeHeight(node.getChild(LEFT)), 
						  determineSubtreeHeight(node.getChild(RIGHT))};
	}

	@Override
	public int determineHeight() {
		return determineSubtreeHeight(root);
	}
	
	
	/** Represents a node in an AVL tree. */
	private static class AVLNode extends BinarySearchTree.BasicNode {
		
		private int subtreeHeight = 0;

		public AVLNode(String id) {
			super(id);
		}

		public AVLNode(Element e) {
			super(e);
		}

		public int getSubtreeHeight() {
			return subtreeHeight;
		}

		/**
		 * Sets the height of the subtree rooted at this node
		 * based on the heights of both children's subtrees.
		 */
		public void setSubtreeHeight(int[] subtreeHeights) {
			this.subtreeHeight = 1 + Math.max(subtreeHeights[LEFT], subtreeHeights[RIGHT]);
		}

	}
	
}
