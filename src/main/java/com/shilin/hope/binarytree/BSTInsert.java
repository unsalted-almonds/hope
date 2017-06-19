package com.shilin.hope.binarytree;


/**
 * Given a binary search tree and a new tree node, insert the node into the
 * tree. You should keep the tree still be a valid binary search tree.
 * 
 * Notice
 * 
 * You can assume there is no duplicate values in this tree + node.
 * 
 * @author Shilin
 *
 */
public class BSTInsert {
	/**
	 * @param root:
	 *            The root of the binary search tree.
	 * @param node:
	 *            insert this node into the binary search tree
	 * @return: The root of the new binary search tree.
	 */
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		// write your code here

		if (root == null) {
			return node;
		}

		if (node == null) {
			return root;
		}

		TreeNode visited = root;
		while (true) {
			if (node.val < visited.val) {
				if (visited.left == null) {
					visited.left = node;
					break;
				}
				visited = visited.left;
			} else {
				if (visited.right == null) {
					visited.right = node;
					break;
				}
				visited = visited.right;
			}
		}

		return root;
	}

	private TreeNode insertNodeRecursive(TreeNode root, TreeNode node) {
		if (node == null) {
			return root;
		}

		if (root == null) {
			return node;
		}

		if (node.val < root.val) {
			root.left = insertNodeRecursive(root.left, node);
		} else {
			root.right = insertNodeRecursive(root.right, node);
		}

		return root;

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
