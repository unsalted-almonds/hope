package com.pecan.hope.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


 * @author Shilin
 *
 */
public class MaxDepth {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        Integer depth = 0;
        
        if (root == null) {
            return depth;
        }
        
        // level traversal? depth first traversal?
        Queue<TreeNode> levelNodes = new LinkedList<TreeNode>(Arrays.asList(root));
        
        while (levelNodes.size() > 0) {
            depth++;
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
            while (levelNodes.size() > 0) {
                TreeNode parent = levelNodes.remove();
                if (parent.left != null) {
                    nextLevel.add(parent.left);
                }
                if (parent.right != null) {
                    nextLevel.add(parent.right);
                }
                
            }
            levelNodes = nextLevel;
        }
        
        return depth;
    }
    
    

      public class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
      }
     
   // Version 1: Divide Conquer
      public class Solution1 {
          public int maxDepth(TreeNode root) {
              if (root == null) {
                  return 0;
              }

              int left = maxDepth(root.left);
              int right = maxDepth(root.right);
              return Math.max(left, right) + 1;
          }
      }

      // version 2: Traverse
      /**
       * Definition of TreeNode:
       * public class TreeNode {
       *     public int val;
       *     public TreeNode left, right;
       *     public TreeNode(int val) {
       *         this.val = val;
       *         this.left = this.right = null;
       *     }
       * }
       */
      public class Solution2 {
          /**
           * @param root: The root of binary tree.
           * @return: An integer.
           */
          private int depth;
          
          public int maxDepth(TreeNode root) {
              depth = 0;
              helper(root, 1);
              
              return depth;
          }
          
          private void helper(TreeNode node, int curtDepth) {
              if (node == null) {
                  return;
              }
              
              if (curtDepth > depth) {
                  depth = curtDepth;
              }
              
              helper(node.left, curtDepth + 1);
              helper(node.right, curtDepth + 1);
          }
      }  
}
