package com.shilin.hope.yama;

/**
 * Reverse a singly linked list.
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);

        while (head != null) {
            ListNode oldHead = dummy.next;
            ListNode nextNode = head.next;
            dummy.next = head;
            head.next = oldHead;
            head = nextNode;
        }

        return dummy.next;
    }
}
