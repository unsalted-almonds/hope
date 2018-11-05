package com.pecan.hope.amazon;

/**
 * Given a binary tree, find the maximum path sum.
 * <p>
 * The path may start and end at any node in the tree.
 */
public class BinaryTreeMaxPathSum {
    /*
 * @param root: The root of binary tree.
 * @return: An integer
 */
    // need an external variable to record result
    // because in the recursive call, the return value is not necessarily the result
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // write your code here
        helper(root);

        return max;
    }

    private int helper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(helper(root.left), 0);
        int rightMax = Math.max(helper(root.right), 0);

        int oneSideMax = root.val + Math.max(leftMax, rightMax);

        int twoSideMax = root.val + leftMax + rightMax;

        max = Math.max(max, Math.max(oneSideMax, twoSideMax));

        // important!! return one side max, upper layer uses one side max to calculate
        return oneSideMax;
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
