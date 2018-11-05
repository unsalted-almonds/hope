package com.pecan.hope.yama;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                prev.next = l2;
                l2 = l2.next;
                prev = prev.next;
                continue;
            }
            if (l2 == null) {
                prev.next = l1;
                l1 = l1.next;
                prev = prev.next;
                continue;
            }
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
                prev = prev.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
                prev = prev.next;
            }
        }

        return dummy.next;
    }
}
