package com.shilin.hope.linkedlist;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * Example Given linked list: 1->2->3->4->5->null, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5->null.
 * 
 * @author Shilin
 *
 */
public class RemoveNth {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @param n:
	 *            An integer.
	 * @return: The head of linked list.
	 */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        
        // double pointer
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        
        Integer i = 0;
        while (pointer2 != null){
            
            if (i++ >= n + 1) {
                pointer1 = pointer1.next;
            }
            
            pointer2 = pointer2.next;
        }
        
        // remove head
        if (pointer1 == head) {
            return head.next;
        } else {
            pointer1.next = pointer1.next.next;
            return head;
        }
        
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
