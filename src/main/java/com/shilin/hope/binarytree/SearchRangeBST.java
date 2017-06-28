package com.shilin.hope.binarytree;

import java.util.ArrayList;

/*
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.
 * 
 * If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
 * 
 * */
public class SearchRangeBST {
	/**
	 * @param root:
	 *            The root of the binary search tree.
	 * @param k1
	 *            and k2: range k1 to k2.
	 * @return: Return all keys that k1<=key<=k2 in ascending order.
	 */
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		// write your code here

		ArrayList<Integer> result = new ArrayList<Integer>();

		return searchRangeHelper(result, root, k1, k2);
	}

	private ArrayList<Integer> searchRangeHelper(ArrayList<Integer> result, TreeNode root, int k1, int k2) {
		if (root == null) {
			return result;
		}

		searchRangeHelper(result, root.left, k1, k2);

		if (root.val >= k1 && root.val <= k2) {
			result.add(root.val);
		} else if (root.val > k2) {
			return result;
		}

		searchRangeHelper(result, root.right, k1, k2);

		return result;

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
