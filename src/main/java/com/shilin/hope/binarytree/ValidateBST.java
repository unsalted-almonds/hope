package com.shilin.hope.binarytree;

import com.shilin.hope.binarytree.BalancedBinaryTree.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
 * @author Shilin
 *
 */
public class ValidateBST {
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
}
