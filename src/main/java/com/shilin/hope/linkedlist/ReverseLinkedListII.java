package com.shilin.hope.linkedlist;

/**
 * Reverse a linked list from position m to n.
 * <p>
 * Notice
 * <p>
 * Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Have you met this question in a real interview? Yes
 * Example
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 */
public class ReverseLinkedListII {

    /*
 * @param head: ListNode head is the head of the linked list
 * @param m: An integer
 * @param n: An integer
 * @return: The head of the reversed ListNode
 */
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        new ReverseLinkedListII().reverseBetween(node1, 2, 3);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        // input validation is omitted since not required

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode node1 = dummy;
        ListNode node2 = dummy;

        for (int i = 0; i < n - m; i++) {
            node2 = node2.next;
        }

        ListNode lastNode1 = dummy;

        for (int i = 0; i < m; i++) {
            lastNode1 = node1;
            node1 = node1.next;
            node2 = node2.next;
        }

        ListNode nextNode2 = node2.next;

        node2.next = null;

        ListNode result = reverse(node1);
        lastNode1.next = result;
        node1.next = nextNode2;

        return dummy.next;

    }

    private ListNode reverse(ListNode head) {
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
