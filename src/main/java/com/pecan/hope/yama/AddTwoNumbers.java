package com.pecan.hope.yama;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = newNode;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = newNode;

            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = newNode;

            l2 = l2.next;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            tail.next = newNode;
            tail = newNode;
        }

        return dummy.next;
    }

    // this is when list is not reversed
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode reversedL1 = reverseList(l1);
        ListNode reversedL2 = reverseList(l2);

        ListNode dummy = new ListNode(-1);

        int carry = 0;
        while (reversedL1 != null && reversedL2 != null) {

            int sum = reversedL1.val + reversedL2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newHead = new ListNode(digit);

            ListNode oldHead = dummy.next;
            dummy.next = newHead;
            newHead.next = oldHead;

            reversedL1 = reversedL1.next;
            reversedL2 = reversedL2.next;
        }

        while (reversedL1 != null) {
            int sum = reversedL1.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode newHead = new ListNode(digit);
            ListNode oldHead = dummy.next;
            dummy.next = newHead;
            newHead.next = oldHead;

            reversedL1 = reversedL1.next;

        }

        while (reversedL2 != null) {
            int sum = reversedL2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode newHead = new ListNode(digit);
            ListNode oldHead = dummy.next;
            dummy.next = newHead;
            newHead.next = oldHead;

            reversedL2 = reversedL2.next;
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);

        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }

        return dummy.next;
    }

}
