package com.shilin.hope.linkedlist;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative. Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.
 * 
 * @author Shilin
 *
 */
public class RotateList {
	/**
	 * @param head:
	 *            the List
	 * @param k:
	 *            rotate to the right k places
	 * @return: the list after rotation
	 */
	public ListNode rotateRight(ListNode head, int k) {
		// write your code here

		if (head == null || head.next == null || k == 0) {
			return head;
		}

		ListNode node = head;
		Integer l = 0;
		while (node != null) {
			l++;
			node = node.next;
		}

		k = k % l;

		if (k == 0) {
			return head;
		}

		ListNode pointer1 = head;
		ListNode pointer2 = head;

		Integer step = 0;
		while (pointer2.next != null) {

			if (step++ >= k) {
				pointer1 = pointer1.next;
			}

			pointer2 = pointer2.next;

		}

		ListNode newHead = pointer1.next;
		pointer2.next = head;
		pointer1.next = null;

		return newHead;

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
