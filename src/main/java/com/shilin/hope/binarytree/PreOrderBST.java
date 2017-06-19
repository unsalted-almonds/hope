package com.shilin.hope.binarytree;

import java.util.ArrayList;

import com.shilin.hope.binarytree.BalancedBinaryTree.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * @author Shilin
 *
 */
public class PreOrderBST {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        preOrder(root, result);
        
        return result;
    }
    
    private void preOrder(TreeNode root, ArrayList<Integer> result){
        if (root != null) {
            result.add(root.val);
        } else {
            return;
        }
        
        preOrder(root.left, result);
        preOrder(root.right, result);
    }
}
