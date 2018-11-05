package com.pecan.hope.followup;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree and a number n, find two numbers in the tree that sums up to n.
 * <p>
 * Notice
 * <p>
 * Without any extra space.
 */
public class TwoSumBST {

    /**
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */

    List<Integer> inorder = new ArrayList<>();

    public int[] twoSum(TreeNode root, int n) {
        // write your code here

        if (root == null) {
            return null;
        }

        inorder(root);

        int[] result = new int[2];
        int p1 = 0;
        int p2 = inorder.size() - 1;

        while (p1 < p2) {
            int sum = inorder.get(p1) + inorder.get(p2);

            if (sum == n) {
                result[0] = inorder.get(p1);
                result[1] = inorder.get(p2);
                return result;
            } else if (sum < n) {
                p1++;
            } else {
                p2--;
            }
        }

        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
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
