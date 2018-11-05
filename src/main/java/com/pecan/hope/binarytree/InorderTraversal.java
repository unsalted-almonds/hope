package com.pecan.hope.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public ArrayList<Integer> inorderTraversalRecur(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();

        helper(res, root);

        return res;

    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root != null) {
            helper(res, root.left);
            res.add(root.val);
            helper(res, root.right);
        }
    }

    // iterative
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();

        Stack<TreeNode> inorder = new Stack<>();

        TreeNode current = root;
        // key is to push onto stack only when it's not null
        while (!inorder.isEmpty() || current != null) {
            while (current != null) {
                inorder.push(current);
                current = current.left;
            }

            current = inorder.pop();
            res.add(current.val);

            current = current.right;
        }

        return res;
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
