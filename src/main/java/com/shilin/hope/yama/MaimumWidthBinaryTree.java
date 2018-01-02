package com.shilin.hope.yama;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

 The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

 Example 1:
 Input:

 1
 /   \
 3     2
 / \     \
 5   3     9

 Output: 4
 Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 Example 2:
 Input:

 1
 /
 3
 / \
 5   3

 Output: 2
 Explanation: The maximum width existing in the third level with the length 2 (5,3).
 Example 3:
 Input:

 1
 / \
 3   2
 /
 5

 Output: 2
 Explanation: The maximum width existing in the second level with the length 2 (3,2).
 Example 4:
 Input:

 1
 / \
 3   2
 /     \
 5       9
 /         \
 6           7
 Output: 8
 Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


 Note: Answer will in the range of 32-bit signed integer.


 */
public class MaimumWidthBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;

        if (root == null) {
            return res;
        }

        Queue<NodeId> bfs = new LinkedList<>();
        bfs.offer(new NodeId(root, 1));
        res = 1;

        while (!bfs.isEmpty()) {
            Queue<NodeId> level = new LinkedList<>();
            Integer lastId = 0;

            while (!bfs.isEmpty()) {
                NodeId current = bfs.poll();
                if (current.node.left != null) {
                    level.offer(new NodeId(current.node.left, current.id * 2));
                    lastId = current.id * 2;
                }
                if (current.node.right != null) {
                    level.offer(new NodeId(current.node.right, current.id * 2 + 1));
                    lastId = current.id * 2 + 1;
                }
            }
            bfs = level;
            if (lastId != 0)
                res = Math.max(res,  lastId - level.peek().id + 1);
        }

        return res;
    }

    static private class NodeId {
        TreeNode node;
        Integer id;

        public NodeId(TreeNode node, Integer id) {
            this.node = node;
            this.id = id;
        }
    }
}
