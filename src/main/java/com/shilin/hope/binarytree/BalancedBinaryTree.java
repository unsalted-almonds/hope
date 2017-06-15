package com.shilin.hope.binarytree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author Shilin
 *
 */
public class BalancedBinaryTree {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: True if this Binary tree is Balanced, or false.
	 */
	public boolean isBalanced(TreeNode root) {
		// write your code here
		return isBalancedHelper(root);
	}

	private boolean isBalancedHelper(TreeNode subTree) {

		if (isLeaf(subTree)) {
			return true;
		} else if (subTree.left == null) {
			return isLeaf(subTree.right) ? true : false;
		} else if (subTree.right == null) {
			return isLeaf(subTree.left) ? true : false;
		}

		return isBalancedHelper(subTree.left) && isBalancedHelper(subTree.right);

	}

	private boolean isLeaf(TreeNode node) {
		if (node == null || (node.left == null && node.right == null)) {
			return true;
		} else {
			return false;
		}
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
