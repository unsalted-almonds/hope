package com.shilin.hope.yama;

import java.util.Stack;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
 5
 /   \
 2     13

 Output: The root of a Greater Tree like this:
 18
 /   \
 20     13
 */
public class BSTToGreaterTree {

    public static void main(String[] args) {
        BSTToGreaterTree test = new BSTToGreaterTree();

        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);
        root.left = left;
        root.right = right;

        test.convertBST(root);

        System.out.println("root = " + root.val);
        System.out.println("left = " + left.val);
        System.out.println("right = " + right.val);
    }

        public TreeNode convertBST(TreeNode root) {

            inorder(root);

            return  root;
        }

        private void inorder(TreeNode root) {

            Stack<TreeNode> stack = new Stack<>();

            TreeNode current = root;
            int prev = 0;
            while (!stack.isEmpty() || current != null) {

                while (current != null) {
                    stack.push(current);
                    current = current.right;
                }
                TreeNode tmp = stack.pop();
                tmp.val += prev;
                prev = tmp.val;
                current = tmp.left;
            }

        }
}
