package com.shilin.hope.datastructure;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class MergeKLists {
	/**
	 * @param lists:
	 *            a list of ListNode
	 * @return: The head of one sorted list.
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		// write your code here
		if (lists == null || lists.size() == 0) {
			return null;
		}

		// in java 7 must also specify the initial capacity 
		Queue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			public int compare(ListNode node1, ListNode node2) {
				return new Integer(node1.val).compareTo(new Integer(node2.val));
			}
		});

		ListNode dummy = new ListNode(-1);
		ListNode start = dummy;

		/*
		 * l1: 1 2 3 4 5 6 7 l2: 2 3 4 5 6 7 8 l3: 4 5 76 88 99 100
		 * 
		 */

		for (ListNode head : lists) {
			if (head != null) {
				minHeap.add(head);
			}
		}

		while (!minHeap.isEmpty()) {
			ListNode current = minHeap.poll();
			if (current.next != null) {
				minHeap.offer(current.next);
			}
			start.next = current;
			start = start.next;
		}

		return dummy.next;

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

}
