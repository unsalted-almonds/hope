package com.shilin.hope.linkedlist;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * 2 1->2->3 => / \ 1 3
 * 
 * @author Shilin
 *
 */
public class SortedListToBalancedBST {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @return: a tree node
	 * 
	 *          An empty tree is height-balanced. A non-empty binary tree T is
	 *          balanced if: 1) Left subtree of T is balanced 2) Right subtree
	 *          of T is balanced 3) The difference between heights of left
	 *          subtree and right subtree is not more than 1.
	 */
	public TreeNode sortedListToBST(ListNode head) {
		// write your code here
		if (head == null) {
			return null;
		}

		return getRoot(head);
	}

	private TreeNode getRoot(ListNode list) {

		if (list == null) {
			return null;
		}

		if (list.next == null) {
			return new TreeNode(list.val);
		}

		Integer mid = getLength(list) / 2;
		Integer i = 0;
		ListNode leftHead = list;

		while (i++ < mid - 1) {
			list = list.next;
		}

		TreeNode root = new TreeNode(list.next.val);

		ListNode rightHead = list.next.next;
		list.next = null;

		root.left = getRoot(leftHead);
		root.right = getRoot(rightHead);
		return root;
	}

	private Integer getLength(ListNode list) {
		Integer length = 0;

		while (list != null) {
			length++;
			list = list.next;
		}

		return length;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
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
