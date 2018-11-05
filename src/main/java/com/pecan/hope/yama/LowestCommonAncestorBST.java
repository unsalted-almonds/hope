package com.pecan.hope.yama;

public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode small = (p.val < q.val) ? p : q;
        TreeNode big = (p.val > q.val) ? p : q;

        while (root != null) {

            if (root.val >= small.val && root.val <= big.val) {
                return root;
            }

            if (root.val < small.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return root;
    }
}
