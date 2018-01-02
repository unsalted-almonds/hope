package com.shilin.hope.yama;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.

 Example 1:

 Input:
 5
 / \
 10 10
 /  \
 2   3

 Output: True
 Explanation:
 5
 /
 10

 Sum: 15

 10
 /  \
 2    3

 Sum: 15
 Example 2:

 Input:
 1
 / \
 2  10
 /  \
 2   20

 Output: False
 Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
 Note:

 The range of tree node value is in the range of [-100000, 100000].
 1 <= n <= 10000
 */
public class EqualTreePartition {


    public static void main(String[] args) {
        EqualTreePartition test = new EqualTreePartition();

        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(10);
        TreeNode right = new TreeNode(10);
        root.left = left;
        root.right = right;
        TreeNode leftLeft = new TreeNode(2);
        TreeNode leftRight = new TreeNode(3);
        left.left = leftLeft;
        left.right = leftRight;

        boolean res = test.checkEqualTree(root);

        System.out.println(res);

        root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(-1);

        res = test.checkEqualTree2(root);

        System.out.println(res);

        res = test.checkEqualTree(root);

        System.out.println(res);

    }

    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> sumCount = new HashMap<>();

        int sum = helper(root, sumCount);
        // deal sum is 0
        if (sum == 0) return sumCount.get(0) > 1;
        return sum % 2 == 0 && sumCount.get(sum) != null;
    }

    private int helper(TreeNode root, Map<Integer, Integer> sumCount) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + helper(root.left, sumCount) + helper(root.right, sumCount);
        if (sumCount.containsKey(sum)) {
            sumCount.put(sum, sumCount.get(sum) + 1);
        } else {
            sumCount.put(sum, 1);
        }

        return sum;
    }



    public boolean checkEqualTree2(TreeNode root) {

        int sum = getSum(root);

        if (sum == 0 || sum % 2 != 0) {
            return false;
        }

        int subTreeSum = sum / 2;

        return equalSum(root, subTreeSum) == subTreeSum;

    }

    private int equalSum(TreeNode root, int target) {

        if (root == null) {
            return 0;
        }

        int leftSum = equalSum(root.left, target);

        if (leftSum == target) {
            return target;
        }

        int rightSum = equalSum(root.right, target);

        if (rightSum == target) {
            return target;
        }

        return root.val + leftSum + rightSum;

    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + getSum(root.left) + getSum(root.right);
    }

}
