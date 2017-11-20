package com.shilin.hope.amazon;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomPointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();

        RandomListNode current = head;

        while (current != null) {
            RandomListNode copy = new RandomListNode(current.label);
            nodeMap.put(current, copy);
            current = current.next;
        }

        for (Map.Entry<RandomListNode, RandomListNode> entry : nodeMap.entrySet()) {
            RandomListNode copy = entry.getValue();
            RandomListNode original = entry.getKey();

            if (original.next != null) {
                copy.next = nodeMap.get(original.next);
            }

            if (original.random != null) {
                copy.random = nodeMap.get(original.random);
            }

        }

        return nodeMap.get(head);
    }

    // Definition for singly-linked list with a random pointer.
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

}
