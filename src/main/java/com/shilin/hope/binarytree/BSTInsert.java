package com.shilin.hope.binarytree;


/**
 * Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a
 * valid binary search tree.
 * <p>
 * Notice
 * <p>
 * You can assume there is no duplicate values in this tree + node.
 *
 * @author Shilin
 */
public class BSTInsert {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }

        TreeNode parent = new TreeNode(Integer.MIN_VALUE);
        parent.right = root;
        TreeNode current = root;

        while (current != null) {
            parent = current;
            // branch left
            if (node.val < current.val) {
                current = current.left;
            }
            // branch right
            else {
                current = current.right;
            }
        }
        if (parent.val > node.val) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return root;
    }

    private TreeNode insertNodeRecursive(TreeNode root, TreeNode node) {
        if (node == null) {
            return root;
        }

        if (root == null) {
            return node;
        }

        if (node.val < root.val) {
            root.left = insertNodeRecursive(root.left, node);
        } else {
            root.right = insertNodeRecursive(root.right, node);
        }

        return root;

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
