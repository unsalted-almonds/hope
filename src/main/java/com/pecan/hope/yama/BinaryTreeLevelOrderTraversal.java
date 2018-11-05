package com.pecan.hope.yama;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by
 * level).
 * <p>
 * For example: Given binary tree [3,9,20,null,null,15,7], 3 / \ 9  20 /  \ 15   7 return its level order traversal as:
 * [ [3], [9,20], [15,7] ]
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);

        while (!bfs.isEmpty()) {
            Queue<TreeNode> level = new LinkedList<>();
            List<Integer> levelVal = new ArrayList<>();

            while (!bfs.isEmpty()) {
                TreeNode current = bfs.poll();
                levelVal.add(current.val);
                if (current.left != null) level.offer(current.left);
                if (current.right != null) level.offer(current.right);
            }

            res.add(levelVal);
            bfs = level;
        }

        return res;
    }
}
