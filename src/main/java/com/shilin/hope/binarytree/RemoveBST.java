package com.shilin.hope.binarytree;

/*
 * Given a root of Binary Search Tree with unique value for each node. Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.
 * */
public class RemoveBST {
	/**
	 * @param root:
	 *            The root of the binary search tree.
	 * @param value:
	 *            Remove the node with given value.
	 * @return: The root of the binary search tree after removal.
	 */
	public TreeNode removeNode(TreeNode root, int value) {
		// write your code here
		TreeNode dummy = new TreeNode(-1);
		dummy.right = root;

		TreeNode parent = findParent(dummy, value);
		// not found
		if (parent == null) {
			return dummy.right;
		}

		TreeNode node = null;

		// node has at most one child
		if (parent.left != null && parent.left.val == value) {
			node = parent.left;
			if (node.left == null) {
				parent.left = node.right;
				return dummy.right;
			} else if (node.right == null) {
				parent.left = node.left;
				return dummy.right;
			}

		} else {
			node = parent.right;
			if (node.left == null) {
				parent.right = node.right;
				return dummy.right;
			} else if (node.right == null) {
				parent.right = node.left;
				return dummy.right;
			}
		}

		// node has two children

		deleteNodeWithTwoChildren(parent, node);

		return dummy.right;
	}

	private void deleteNodeWithTwoChildren(TreeNode parent, TreeNode node) {
		// node has both left and right children
		TreeNode leftChild = node.left;
		// find greatest left child to replace

		TreeNode leftParent = node;
		while (leftChild.right != null) {
			leftChild = leftChild.right;
			leftParent = leftChild;
		}

		// remove leftChild
		// leftChild has at most one left child
		if (leftParent.left == leftChild) {
			leftParent.left = leftChild.left;
		} else {
			leftParent.right = leftChild.left;
		}

		// replace node with leftChild
		if (parent.left != null && parent.left == node) {
			parent.left = leftChild;
		} else {
			parent.right = leftChild;
		}

		leftChild.left = node.left;
		leftChild.right = node.right;

		return;
	}

	// return parent of the node if found, otherwise null
	private TreeNode findParent(TreeNode root, int value) {
		TreeNode parent = null;
		while (root != null) {
			if (root.val == value)
				return parent;
			parent = root;
			root = (root.val > value) ? root.left : root.right;
		}

		return null;
	}

	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
}
