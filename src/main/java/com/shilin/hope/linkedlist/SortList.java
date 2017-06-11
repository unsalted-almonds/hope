package com.shilin.hope.linkedlist;

/**
 * Sort List Sort a linked list in O(n log n) time using constant space
 * complexity.
 * 
 * @author Shilin
 *
 */
public class SortList {
	/**
	 * @param head:
	 *            The head of linked list.
	 * @return: You should return the head of the sorted linked list, using
	 *          constant space complexity.
	 */
	public ListNode sortList(ListNode head) {
		// write your code here

		if (head == null || head.next == null) {
			return head;
		}

		ListNode midNode = getMid(head);
		ListNode sortedRight = sortList(midNode.next);
		midNode.next = null;
		ListNode sortedLeft = sortList(head);

		// System.out.println("sortedLeft =" + sortedLeft.val + " next = " +
		// sortedLeft.next + " sortedRight = " + //sortedRight.val + " next = "
		// + sortedRight.next);
		return mergeSortedList(sortedLeft, sortedRight);

	}

	private ListNode mergeSortedList(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;

		while (l1 != null && l2 != null) {

			if (l1.val <= l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}

		if (l1 != null) {
			current.next = l1;
		}

		if (l2 != null) {
			current.next = l2;
		}

		return dummy.next;
	}

	// 1-> null
	// d -> 1 -> -> 2 -> null

	// return the middle node
	private ListNode getMid(ListNode head) {

		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode pointer1 = dummyNode;
		ListNode pointer2 = dummyNode;

		Integer step = 0;

		while (pointer1 != null) {
			step++;
			pointer1 = pointer1.next;
			if (step == 2) {
				pointer2 = pointer2.next;
				step = 0;
			}
		}

		return pointer2;
	}

	/*
	 * private ListNode findMiddle(ListNode head) { ListNode slow = head, fast =
	 * head.next; while (fast != null && fast.next != null) { fast =
	 * fast.next.next; slow = slow.next; } return slow; }
	 */

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
