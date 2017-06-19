package com.shilin.hope.binarytree;

import java.util.ArrayList;
import java.util.Stack;

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
    
    private ArrayList<Integer> preOrderIterative(TreeNode root){
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	if (root == null) {
    		return result;
    	}
    	
    	Stack<TreeNode> path = new Stack<TreeNode>();
    	path.push(root);
    	
    	while (!path.isEmpty()) {
    		TreeNode current = path.pop();
    		result.add(current.val);
    		if (current.right != null) {
    			path.push(current.right);
    		}
    		if (current.left != null) {
    			path.push(current.left);
    		}
    	}
    	
    	return result;
    }
}
