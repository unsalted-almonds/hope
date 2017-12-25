package com.shilin.hope.yama;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        int len = getLength(head);

        int step = 0;
        ListNode pointer = head;

        // there's no need to consider odd or even
        while (step < len / 2) {
            pointer = pointer.next;
            step++;
        }

        ListNode reversedHalf = reverseList(pointer);

        while (reversedHalf != null) {
            if (head.val != reversedHalf.val) {
                return false;
            }
            head = head.next;
            reversedHalf = reversedHalf.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
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

    private int getLength(ListNode head) {
        int res = 0;

        while (head != null) {
            res++;
            head = head.next;
        }

        return res;
    }
}
