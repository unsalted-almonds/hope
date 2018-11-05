package com.pecan.hope.binarytree;

/*
 * Given a root of Binary Search Tree with unique value for each node. Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.
 * */
public class RemoveBST {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return root;
        }
        
        TreeNode dummy = new TreeNode(-1);
        dummy.right = root;
        
        TreeNode parent = getNodeParent(dummy, value);
        // if not found, return root
        if (parent == null) {
            return dummy.right;
        }
        
        // if found, grab the reference to it
        TreeNode node = (parent.left != null && parent.left.val == value) ? parent.left : parent.right;

        deleteNode(parent, node);
        
        return dummy.right;
    }
    
    private void deleteNode(TreeNode parent, TreeNode node) {
        // if node doesn't have left child
        if (node.left == null) {
            if (parent.left == node) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
            return;
        } 
        
        // if node doesn't have right child
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
            return;
        }
        
        // node has both left and right children
        // find greatest left child and use it to replace node
        TreeNode leftParent = node;
        TreeNode leftChild = node.left;
        while (leftChild.right != null) {
            leftParent = leftChild;
            leftChild = leftChild.right;
        }
        
        // remove this left child
        // if right branching didn't happen
        if (leftParent == node) {
            leftParent.left = leftChild.left;
        } else {
            leftParent.right = leftChild.left;
        }
        
        // replace node with the left child
        if (parent.left == node) {
            parent.left = leftChild;
        } else {
            parent.right = leftChild;
        }
        
        leftChild.left = node.left;
        leftChild.right = node.right;
        
        return;
        
    }
    
    // return parent of the node to remove, or null if not found
    private TreeNode getNodeParent(TreeNode root, int value) {
        TreeNode parent = null;
        while (root != null) {
            if (root.val == value) return parent;
            parent = root;
            root = (root.val > value) ? root.left : root.right;
        }
        
        return null;
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
