package com.shilin.hope.amazon;

import com.shilin.hope.binarytree.BalancedBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
 * <p>
 * A valid path is from root node to any of the leaf nodes.
 */
public class BinaryTreePathSum {

    /*
 * @param root: the root of binary tree
 * @param target: An integer
 * @return: all valid paths
 */
    public List<List<Integer>> binaryTreePathSum(BalancedBinaryTree.TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(target, root, root.val, path, res);

        return res;
    }

    private void helper(int target, BalancedBinaryTree.TreeNode current, Integer sum, List<Integer> path, List<List<Integer>> res) {

        // leaf
        if (current.left == null && current.right == null) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
        }

        if (current.left != null) {
            path.add(current.left.val);
            helper(target, current.left, sum + current.left.val, path, res);
            path.remove(path.size() - 1);
            // no need to substract, sum has not been incremented !!!
            //sum -= current.left.val;
        }

        if (current.right != null) {
            path.add(current.right.val);
            helper(target, current.right, sum + current.right.val, path, res);
            path.remove(path.size() - 1);
            //sum -= current.right.val;
        }

    }
}
