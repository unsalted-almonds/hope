package com.shilin.hope.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author Shilin
 *
 */
public class CopyListWithRandomPointer {
	/**
	 * @param head:
	 *            The head of linked list with a random pointer.
	 * @return: A new head of a deep copy of the list.
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		// write your code here

		if (head == null) {
			return null;
		}

		// orignal node -> copy node
		Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();

		RandomListNode originalHead = head;
		while (head != null) {
			nodeMap.put(head, new RandomListNode(head.label));
			head = head.next;
		}

		for (RandomListNode original : nodeMap.keySet()) {
			if (original.next != null) {
				nodeMap.get(original).next = nodeMap.get(original.next);
			}
			if (original.random != null) {
				nodeMap.get(original).random = nodeMap.get(original.random);
			}
		}

		return nodeMap.get(originalHead);
	}

	// Definition for singly-linked list with a random pointer.
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

}
