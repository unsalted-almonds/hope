package com.pecan.hope.yama;

import java.util.*;

/**
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary
 * includes left boundary, leaves, and right boundary in order without duplicate nodes.
 * <p>
 * Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root
 * to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary
 * or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
 * <p>
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if
 * exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 * <p>
 * The right-most node is also defined by the same way with left and right exchanged.
 * <p>
 * Example 1
 * <p>
 * Input: 1 \ 2 / \ 3   4
 * <p>
 * Ouput: [1, 3, 4, 2]
 * <p>
 * Explanation: The root doesn't have left subtree, so the root itself is left boundary. The leaves are node 3 and 4.
 * The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
 * So order them in anti-clockwise without duplicates and we have [1,3,4,2].
 * <p>
 * <p>
 * Example 2
 * <p>
 * Input: ____1_____ /          \ 2            3 / \          / 4   5        6 / \      / \ 7   8    9  10
 * <p>
 * Ouput: [1,2,4,7,8,9,10,6,3]
 * <p>
 * Explanation: The left boundary are node 1,2,4. (4 is the left-most node according to definition) The leaves are node
 * 4,7,8,9,10. The right boundary are node 1,3,6,10. (10 is the right-most node). So order them in anti-clockwise
 * without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 */
public class Stress {
    public static void main(String[] args) {

        Stress test = new Stress();

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node7;
        node4.right = node8;
        node3.left = node6;
        node6.left = node9;
        node6.right = node10;

        System.out.println(test.getBoundary(root));

    }

    public List<Integer> getBoundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // root
        res.add(root.val);

        if (root.left == null && root.right == null) {
            return res;
        }

        res.addAll(getLeftBoundary(root));

        res.addAll(getLeaves(root));

        List<Integer> right = getRightBoundary(root);

        Collections.reverse(right);
        res.addAll(right);

        return res;
    }

    // cannot use this to solve this problem
    // this is not right as the bottom level may not have all the leaves
    private List<List<Integer>> levelOrder(TreeNode root) {
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

    // returns boundary without leaf
    private List<Integer> getLeftBoundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root.left == null) {
            return res;
        }
        root = root.left;

        while (root.left != null || root.right != null) {
            res.add(root.val);
            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }

        }

        return res;
    }

    // preorder
    private List<Integer> getLeaves(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left == null && current.right == null) res.add(current.val);

            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);

        }

        return res;
    }

    // right
    private List<Integer> getRightBoundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root.right == null) {
            return res;
        }
        root = root.right;

        while (root.left != null || root.right != null) {
            res.add(root.val);
            if (root.right != null) {
                root = root.right;
            } else {
                root = root.left;
            }

        }

        return res;
    }
}
