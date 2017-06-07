package com.shilin.hope.linkedlist;

/**
 * Given a linked list, determine if it has a cycle in it. Example Given
 * -21->10->4->5, tail connects to node index 1, return true
 * 
 * @author Shilin
 *
 */
public class LinkedListCycle {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @return: True if it has a cycle, or false
	 */
	public boolean hasCycle(ListNode head) {
		// write your code here
		if (head == null) {
			return false;
		}

		ListNode slow = new ListNode(0);
		slow.next = head;
		ListNode fast = new ListNode(0);
		fast.next = head;
		Integer cnt = 0;
		while (fast != null && slow != fast) {
			fast = fast.next;
			if (cnt++ == 1) {
				cnt = 0;
				slow = slow.next;
			}
		}

		if (fast == null) {
			return false;
		}

		return true;

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
