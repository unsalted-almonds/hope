package com.pecan.hope.yama;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up: Can you solve it without using extra space?
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }

            if (slow == fast) {
                return true;
            }

        }

        return false;
    }
}
