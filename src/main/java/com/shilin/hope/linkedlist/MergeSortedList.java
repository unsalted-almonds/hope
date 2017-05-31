package com.shilin.hope.linkedlist;


public class MergeSortedList {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null) {
            return l2;
        } 
        
        if (l2 == null) {
            return l1;
        }
        
        // write your code here
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode current;
        
        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            pointer1 = pointer1.next;
        } else {
            head = l2;
            pointer2 = pointer2.next;
        }
        
        current = head;
        
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val <= pointer2.val) {
                current.next = pointer1;
                pointer1 = pointer1.next;
            } else {
                current.next = pointer2;
                pointer2 = pointer2.next;
            }
            current = current.next;
        }
        
        if (pointer1 != null){
            current.next = pointer1;
        }
        
        if (pointer2 != null) {
            current.next = pointer2;
        }
        
        return head;
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
