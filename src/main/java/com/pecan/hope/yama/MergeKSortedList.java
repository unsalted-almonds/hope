package com.pecan.hope.yama;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return new Integer(n1.val).compareTo(n2.val);
            }
        });

        for (ListNode node : lists) {
            if (node != null)
                pq.offer(node);
        }

        if (pq.isEmpty()) {
            return null;
        }

        ListNode current = pq.poll();
        if (current.next != null) {
            pq.offer(current.next);
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = current;

        while (!pq.isEmpty()) {
            current.next = pq.poll();
            current = current.next;
            if (current.next != null) {
                pq.offer(current.next);
            }

        }

        return dummy.next;
    }
}
