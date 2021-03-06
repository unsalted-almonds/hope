package com.pecan.hope.linkedlist;

/**
 * Reverse a linked list.
 * <p>
 * Example For linked list 1->2->3, the reversed linked list is 3->2->1
 *
 * @author Shilin
 */
public class ReverseLinkedList {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */

    public ListNode reverse2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode last = dummy;

        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = last;
            last = current;
            current = next;
        }
        head.next = null;

        return last;
    }

    public ListNode reverse(ListNode head) {

        // this is slightly different
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode node1 = null;

        while (head != null) {
            node1 = dummy.next;
            dummy.next = head;
            head = head.next;
            dummy.next.next = node1;
        }

        return dummy.next;
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
