package com.shilin.hope.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * @author Shilin
 *
 */
public class LevelOrderTraversalBST {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> visiting = new LinkedList<TreeNode>();
        visiting.offer(root);
        
        while (!visiting.isEmpty()) {
            Queue<TreeNode> children = new LinkedList<TreeNode>();
            ArrayList<Integer> level = new ArrayList<Integer>();
            while (!visiting.isEmpty()) {
                TreeNode current = visiting.poll();
                level.add(current.val);
                if (current.left != null) {
                    children.offer(current.left);
                } 
                if (current.right != null) {
                    children.offer(current.right);
                }
            }
            visiting = children;
            result.add(level);
        }
        
        return result;
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
