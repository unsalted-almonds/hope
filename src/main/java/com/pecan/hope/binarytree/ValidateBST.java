package com.pecan.hope.binarytree;

import com.pecan.hope.binarytree.BalancedBinaryTree.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key. The right subtree of a node
 * contains only nodes with keys greater than the node's key. Both the left and right subtrees must also be binary
 * search trees. A single node tree is a BST
 *
 * @author Shilin
 */
public class ValidateBST {
    Long previous = Long.MIN_VALUE;
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    // in order traversal to check if node is sorted
    private Long lastVal = Long.MIN_VALUE;

    public boolean isValidBST1(TreeNode root) {
        // write your code here

        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= lastVal) {
            return false;
        } else {
            lastVal = new Long(root.val);
        }

        if (!isValidBST(root.right)) {
            return false;
        }

        return true;

    }

    // use range!
    public boolean isValidBST(TreeNode root) {

        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, Long min, Long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBSTHelper(root.left, min, new Long(root.val)) && isValidBSTHelper(root.right, new Long(root.val), max);

    }

    private boolean isValidBSTIterative(TreeNode root) {
        // write your code here
        // use inorder traversal
        // or how about just use its definition
        // Both the left and right subtrees must also be binary search trees.
        // the above statement is tricky to implement
        // use inorder traversal may break the program earilier though
        // when it detects that it's not valid

        // first try inorder traversal
        Stack<TreeNode> inorder = new Stack<>();

        TreeNode current = root;

        Long previous = Long.MIN_VALUE;

        while (!inorder.isEmpty() || current != null) {
            if (current != null) {
                inorder.push(current);
                current = current.left;
            } else {
                TreeNode tmp = inorder.pop();
                if (tmp.val <= previous) {
                    return false;
                }
                previous = new Long(tmp.val);
                current = tmp.right;
            }

        }

        return true;


    }

    public boolean isValidBSTRecur(TreeNode root) {
        // write your code here
        // do the inorder traversal recursively

        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (root.val > previous) {
            previous = new Long(root.val);
            return inorder(root.right);
        } else {
            return false;
        }
    }
}
