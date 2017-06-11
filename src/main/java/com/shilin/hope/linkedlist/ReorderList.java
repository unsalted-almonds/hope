package com.shilin.hope.linkedlist;

/**
 * Given a singly linked list L: L0 ¡ú L1 ¡ú ¡­ ¡ú Ln-1 ¡ú Ln
 * 
 * reorder it to: L0 ¡ú Ln ¡ú L1 ¡ú Ln-1 ¡ú L2 ¡ú Ln-2 ¡ú ¡­
 * 
 * Example Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 * 
 * @author Shilin
 *
 */
public class ReorderList {
	/**
	 * @param head:
	 *            The head of linked list.
	 * @return: void
	 */
	public void reorderList(ListNode head) {
		// write your code here
		if (head == null) {
			return;
		}
		if (head.next == null) {
			return;
		}

		// 0
		// 0 1
		// 0 1 2
		// 0 1 2 3
		// 0 1 2 3 4

		// 2 -1 0
		ListNode pointer1 = head;
		ListNode pointer2 = head;
		ListNode current = head;

		Integer step = getLength(head) / 2;

		for (Integer i = 0; i < step; i++) {
			current = current.next;
		}

		pointer2 = current.next;
		current.next = null;

		pointer2 = reverseList(pointer2);

		ListNode node2 = null;

		while (pointer1 != null && pointer2 != null) {
			current = pointer1.next;
			pointer1.next = pointer2;
			node2 = pointer2;
			pointer2 = node2.next;
			node2.next = current;
			pointer1 = current;

		}

		return;

	}

	private ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		while (head != null) {
			ListNode node = dummy.next;
			dummy.next = head;
			head = head.next;
			dummy.next.next = node;
		}

		return dummy.next;
	}

	private Integer getLength(ListNode head) {
		Integer result = 0;
		while (head != null) {
			result++;
			head = head.next;
		}
		return result;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	/**
	 *     private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

	 */
}
